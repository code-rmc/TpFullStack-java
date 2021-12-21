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
import logica.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.PaqueteTuristico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Rodrigo
 */
public class PaqueteTuristicoJpaController implements Serializable {

    public PaqueteTuristicoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TPFinalPU");
    }
    
    public PaqueteTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PaqueteTuristico paqueteTuristico) {
        if (paqueteTuristico.getLista_servicios_incluidos() == null) {
            paqueteTuristico.setLista_servicios_incluidos(new ArrayList<Servicio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio> attachedLista_servicios_incluidos = new ArrayList<Servicio>();
            for (Servicio lista_servicios_incluidosServicioToAttach : paqueteTuristico.getLista_servicios_incluidos()) {
                lista_servicios_incluidosServicioToAttach = em.getReference(lista_servicios_incluidosServicioToAttach.getClass(), lista_servicios_incluidosServicioToAttach.getCodigo_servicio());
                attachedLista_servicios_incluidos.add(lista_servicios_incluidosServicioToAttach);
            }
            paqueteTuristico.setLista_servicios_incluidos(attachedLista_servicios_incluidos);
            em.persist(paqueteTuristico);
            for (Servicio lista_servicios_incluidosServicio : paqueteTuristico.getLista_servicios_incluidos()) {
                lista_servicios_incluidosServicio.getLista_paquete().add(paqueteTuristico);
                lista_servicios_incluidosServicio = em.merge(lista_servicios_incluidosServicio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PaqueteTuristico paqueteTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico persistentPaqueteTuristico = em.find(PaqueteTuristico.class, paqueteTuristico.getCodigo_paquete());
            List<Servicio> lista_servicios_incluidosOld = persistentPaqueteTuristico.getLista_servicios_incluidos();
            List<Servicio> lista_servicios_incluidosNew = paqueteTuristico.getLista_servicios_incluidos();
            List<Servicio> attachedLista_servicios_incluidosNew = new ArrayList<Servicio>();
            for (Servicio lista_servicios_incluidosNewServicioToAttach : lista_servicios_incluidosNew) {
                lista_servicios_incluidosNewServicioToAttach = em.getReference(lista_servicios_incluidosNewServicioToAttach.getClass(), lista_servicios_incluidosNewServicioToAttach.getCodigo_servicio());
                attachedLista_servicios_incluidosNew.add(lista_servicios_incluidosNewServicioToAttach);
            }
            lista_servicios_incluidosNew = attachedLista_servicios_incluidosNew;
            paqueteTuristico.setLista_servicios_incluidos(lista_servicios_incluidosNew);
            paqueteTuristico = em.merge(paqueteTuristico);
            for (Servicio lista_servicios_incluidosOldServicio : lista_servicios_incluidosOld) {
                if (!lista_servicios_incluidosNew.contains(lista_servicios_incluidosOldServicio)) {
                    lista_servicios_incluidosOldServicio.getLista_paquete().remove(paqueteTuristico);
                    lista_servicios_incluidosOldServicio = em.merge(lista_servicios_incluidosOldServicio);
                }
            }
            for (Servicio lista_servicios_incluidosNewServicio : lista_servicios_incluidosNew) {
                if (!lista_servicios_incluidosOld.contains(lista_servicios_incluidosNewServicio)) {
                    lista_servicios_incluidosNewServicio.getLista_paquete().add(paqueteTuristico);
                    lista_servicios_incluidosNewServicio = em.merge(lista_servicios_incluidosNewServicio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paqueteTuristico.getCodigo_paquete();
                if (findPaqueteTuristico(id) == null) {
                    throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.");
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
            PaqueteTuristico paqueteTuristico;
            try {
                paqueteTuristico = em.getReference(PaqueteTuristico.class, id);
                paqueteTuristico.getCodigo_paquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.", enfe);
            }
            List<Servicio> lista_servicios_incluidos = paqueteTuristico.getLista_servicios_incluidos();
            for (Servicio lista_servicios_incluidosServicio : lista_servicios_incluidos) {
                lista_servicios_incluidosServicio.getLista_paquete().remove(paqueteTuristico);
                lista_servicios_incluidosServicio = em.merge(lista_servicios_incluidosServicio);
            }
            em.remove(paqueteTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities() {
        return findPaqueteTuristicoEntities(true, -1, -1);
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities(int maxResults, int firstResult) {
        return findPaqueteTuristicoEntities(false, maxResults, firstResult);
    }

    private List<PaqueteTuristico> findPaqueteTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PaqueteTuristico.class));
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

    public PaqueteTuristico findPaqueteTuristico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PaqueteTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaqueteTuristico> rt = cq.from(PaqueteTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
