/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.PaqueteTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Servicio;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Rodrigo
 */
public class ServicioJpaController implements Serializable {

    public ServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ServicioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TPFinalPU");;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicio servicio) {
        if (servicio.getLista_paquete() == null) {
            servicio.setLista_paquete(new ArrayList<PaqueteTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PaqueteTuristico> attachedLista_paquete = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico lista_paquetePaqueteTuristicoToAttach : servicio.getLista_paquete()) {
                lista_paquetePaqueteTuristicoToAttach = em.getReference(lista_paquetePaqueteTuristicoToAttach.getClass(), lista_paquetePaqueteTuristicoToAttach.getCodigo_paquete());
                attachedLista_paquete.add(lista_paquetePaqueteTuristicoToAttach);
            }
            servicio.setLista_paquete(attachedLista_paquete);
            em.persist(servicio);
            for (PaqueteTuristico lista_paquetePaqueteTuristico : servicio.getLista_paquete()) {
                lista_paquetePaqueteTuristico.getLista_servicios_incluidos().add(servicio);
                lista_paquetePaqueteTuristico = em.merge(lista_paquetePaqueteTuristico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicio servicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio persistentServicio = em.find(Servicio.class, servicio.getCodigo_servicio());
            List<PaqueteTuristico> lista_paqueteOld = persistentServicio.getLista_paquete();
            List<PaqueteTuristico> lista_paqueteNew = servicio.getLista_paquete();
            List<PaqueteTuristico> attachedLista_paqueteNew = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico lista_paqueteNewPaqueteTuristicoToAttach : lista_paqueteNew) {
                lista_paqueteNewPaqueteTuristicoToAttach = em.getReference(lista_paqueteNewPaqueteTuristicoToAttach.getClass(), lista_paqueteNewPaqueteTuristicoToAttach.getCodigo_paquete());
                attachedLista_paqueteNew.add(lista_paqueteNewPaqueteTuristicoToAttach);
            }
            lista_paqueteNew = attachedLista_paqueteNew;
            servicio.setLista_paquete(lista_paqueteNew);
            servicio = em.merge(servicio);
            for (PaqueteTuristico lista_paqueteOldPaqueteTuristico : lista_paqueteOld) {
                if (!lista_paqueteNew.contains(lista_paqueteOldPaqueteTuristico)) {
                    lista_paqueteOldPaqueteTuristico.getLista_servicios_incluidos().remove(servicio);
                    lista_paqueteOldPaqueteTuristico = em.merge(lista_paqueteOldPaqueteTuristico);
                }
            }
            for (PaqueteTuristico lista_paqueteNewPaqueteTuristico : lista_paqueteNew) {
                if (!lista_paqueteOld.contains(lista_paqueteNewPaqueteTuristico)) {
                    lista_paqueteNewPaqueteTuristico.getLista_servicios_incluidos().add(servicio);
                    lista_paqueteNewPaqueteTuristico = em.merge(lista_paqueteNewPaqueteTuristico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicio.getCodigo_servicio();
                if (findServicio(id) == null) {
                    throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.");
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
            Servicio servicio;
            try {
                servicio = em.getReference(Servicio.class, id);
                servicio.getCodigo_servicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.", enfe);
            }
            List<PaqueteTuristico> lista_paquete = servicio.getLista_paquete();
            for (PaqueteTuristico lista_paquetePaqueteTuristico : lista_paquete) {
                lista_paquetePaqueteTuristico.getLista_servicios_incluidos().remove(servicio);
                lista_paquetePaqueteTuristico = em.merge(lista_paquetePaqueteTuristico);
            }
            em.remove(servicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicio> findServicioEntities() {
        return findServicioEntities(true, -1, -1);
    }

    public List<Servicio> findServicioEntities(int maxResults, int firstResult) {
        return findServicioEntities(false, maxResults, firstResult);
    }

    private List<Servicio> findServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio.class));
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

    public Servicio findServicio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio> rt = cq.from(Servicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
