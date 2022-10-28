/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import entidades.ViewDatosPagoOnline;
import java.io.Serializable;
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
 * @author gemacron
 */
public class ViewDatosPagoOnlineJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContSmartParkingPU");

    public ViewDatosPagoOnlineJpaController() {
    }

    public ViewDatosPagoOnlineJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewDatosPagoOnline viewDatosPagoOnline) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewDatosPagoOnline);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewDatosPagoOnline(viewDatosPagoOnline.getIdentificador()) != null) {
                throw new PreexistingEntityException("ViewDatosPagoOnline " + viewDatosPagoOnline + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewDatosPagoOnline viewDatosPagoOnline) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewDatosPagoOnline = em.merge(viewDatosPagoOnline);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewDatosPagoOnline.getIdentificador();
                if (findViewDatosPagoOnline(id) == null) {
                    throw new NonexistentEntityException("The viewDatosPagoOnline with id " + id + " no longer exists.");
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
            ViewDatosPagoOnline viewDatosPagoOnline;
            try {
                viewDatosPagoOnline = em.getReference(ViewDatosPagoOnline.class, id);
                viewDatosPagoOnline.getIdentificador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewDatosPagoOnline with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewDatosPagoOnline);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewDatosPagoOnline> findViewDatosPagoOnlineEntities() {
        return findViewDatosPagoOnlineEntities(true, -1, -1);
    }

    public List<ViewDatosPagoOnline> findViewDatosPagoOnlineEntities(int maxResults, int firstResult) {
        return findViewDatosPagoOnlineEntities(false, maxResults, firstResult);
    }

    private List<ViewDatosPagoOnline> findViewDatosPagoOnlineEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewDatosPagoOnline.class));
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

    public ViewDatosPagoOnline findViewDatosPagoOnline(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewDatosPagoOnline.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewDatosPagoOnlineCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewDatosPagoOnline> rt = cq.from(ViewDatosPagoOnline.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<ViewDatosPagoOnline> findViewDatosPagoDate(Integer ano, Integer mes, String pos) {
        EntityManager em = getEntityManager();
        Query q;
        em.getTransaction().begin();
        List<ViewDatosPagoOnline> pagos;
        if (!pos.equals("*.*")) {
            q = em.createNativeQuery("SELECT * FROM SistemaContableParaguay.dbo.View_DatosPagoOnline "
                    + "WHERE YEAR(FechaPago) = '" + ano + "' "
                    + "AND MONTH(FechaPago) = '" + mes + "' "
                    + "AND Modulo LIKE '%" + pos + "%' AND Identificador != 62612 ORDER BY Factura ASC", ViewDatosPagoOnline.class);
        } else {
            q = em.createNativeQuery("SELECT * FROM SistemaContableParaguay.dbo.View_DatosPagoOnline "
                    + "WHERE YEAR(FechaPago) = '" + ano + "' "
                    + "AND MONTH(FechaPago) = '" + mes + "' AND Identificador != 62612 ORDER BY Factura ASC", ViewDatosPagoOnline.class);
        }

        pagos = (List<ViewDatosPagoOnline>) q.getResultList();
        em.getTransaction().commit();
        return pagos;
    }

    public List<Integer> listFromYear() {
        EntityManager em = getEntityManager();
        Query q;
        em.getTransaction().begin();
        List<Integer> year;
        q = em.createNativeQuery("SELECT "
                + "DISTINCT YEAR(Fecha) "
                + "FROM SistemaContableParaguay.dbo.Tbl_Cabecera ORDER BY YEAR(Fecha) DESC;");
        year = (List<Integer>) q.getResultList();
        em.getTransaction().commit();
        return year;
    }

    public List<Integer> listFromMonth() {
        EntityManager em = getEntityManager();
        Query q;
        em.getTransaction().begin();
        List<Integer> month;
        q = em.createNativeQuery("SELECT "
                + "DISTINCT MONTH(Fecha) "
                + "FROM SistemaContableParaguay.dbo.Tbl_Cabecera ORDER BY MONTH(Fecha) DESC;");
        month = (List<Integer>) q.getResultList();
        em.getTransaction().commit();
        return month;
    }
}
