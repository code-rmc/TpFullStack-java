/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.MediosPago;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Rodrigo
 */
public class MediosPagoJpaController implements Serializable {

    public MediosPagoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TPFinalPU");
    }
    
    public MediosPagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MediosPago mediosPago) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mediosPago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MediosPago mediosPago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mediosPago = em.merge(mediosPago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mediosPago.getId_medio();
                if (findMediosPago(id) == null) {
                    throw new NonexistentEntityException("The mediosPago with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MediosPago mediosPago;
            try {
                mediosPago = em.getReference(MediosPago.class, id);
                mediosPago.getId_medio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mediosPago with id " + id + " no longer exists.", enfe);
            }
            em.remove(mediosPago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MediosPago> findMediosPagoEntities() {
        return findMediosPagoEntities(true, -1, -1);
    }

    public List<MediosPago> findMediosPagoEntities(int maxResults, int firstResult) {
        return findMediosPagoEntities(false, maxResults, firstResult);
    }

    private List<MediosPago> findMediosPagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MediosPago.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public MediosPago findMediosPago(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MediosPago.class, id);
        } finally {
            em.close();
        }
    }

    public int getMediosPagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MediosPago> rt = cq.from(MediosPago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
