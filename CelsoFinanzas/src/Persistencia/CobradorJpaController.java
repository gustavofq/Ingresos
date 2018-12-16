/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Cobrador;
import Persistencia.exceptions.NonexistentEntityException;
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
 * @author gustavo
 */
public class CobradorJpaController implements Serializable {

    public CobradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    CobradorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("celso");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cobrador cobrador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cobrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cobrador cobrador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cobrador = em.merge(cobrador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = cobrador.getDni();
                if (findCobrador(id) == null) {
                    throw new NonexistentEntityException("The cobrador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cobrador cobrador;
            try {
                cobrador = em.getReference(Cobrador.class, id);
                cobrador.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cobrador with id " + id + " no longer exists.", enfe);
            }
            em.remove(cobrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cobrador> findCobradorEntities() {
        return findCobradorEntities(true, -1, -1);
    }

    public List<Cobrador> findCobradorEntities(int maxResults, int firstResult) {
        return findCobradorEntities(false, maxResults, firstResult);
    }

    private List<Cobrador> findCobradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cobrador.class));
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

    public Cobrador findCobrador(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cobrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getCobradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cobrador> rt = cq.from(Cobrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
