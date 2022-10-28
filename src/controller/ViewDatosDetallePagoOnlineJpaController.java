/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import entidades.ViewDatosDetallePagoOnline;
import entidades.ViewDatosPagoOnline;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author EGLOBALT
 */
public class ViewDatosDetallePagoOnlineJpaController implements Serializable {

    public ViewDatosDetallePagoOnlineJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContSmartParkingPU");

    public ViewDatosDetallePagoOnlineJpaController() {
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewDatosDetallePagoOnline viewDatosDetallePagoOnline) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewDatosDetallePagoOnline);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewDatosDetallePagoOnline(viewDatosDetallePagoOnline.getIdentificador()) != null) {
                throw new PreexistingEntityException("ViewDatosDetallePagoOnline " + viewDatosDetallePagoOnline + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewDatosDetallePagoOnline viewDatosDetallePagoOnline) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewDatosDetallePagoOnline = em.merge(viewDatosDetallePagoOnline);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewDatosDetallePagoOnline.getIdentificador();
                if (findViewDatosDetallePagoOnline(id) == null) {
                    throw new NonexistentEntityException("The viewDatosDetallePagoOnline with id " + id + " no longer exists.");
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
            ViewDatosDetallePagoOnline viewDatosDetallePagoOnline;
            try {
                viewDatosDetallePagoOnline = em.getReference(ViewDatosDetallePagoOnline.class, id);
                viewDatosDetallePagoOnline.getIdentificador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewDatosDetallePagoOnline with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewDatosDetallePagoOnline);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewDatosDetallePagoOnline> findViewDatosDetallePagoOnlineEntities() {
        return findViewDatosDetallePagoOnlineEntities(true, -1, -1);
    }

    public List<ViewDatosDetallePagoOnline> findViewDatosDetallePagoOnlineEntities(int maxResults, int firstResult) {
        return findViewDatosDetallePagoOnlineEntities(false, maxResults, firstResult);
    }

    private List<ViewDatosDetallePagoOnline> findViewDatosDetallePagoOnlineEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewDatosDetallePagoOnline.class));
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

    public ViewDatosDetallePagoOnline findViewDatosDetallePagoOnline(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewDatosDetallePagoOnline.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewDatosDetallePagoOnlineCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewDatosDetallePagoOnline> rt = cq.from(ViewDatosDetallePagoOnline.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
