/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.CelsoFinanzas;
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
public class CelsoFinanzasJpaController implements Serializable {

    public CelsoFinanzasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public CelsoFinanzasJpaController(){
        emf = Persistence.createEntityManagerFactory("CelsoFinanzasPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CelsoFinanzas celsoFinanzas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(celsoFinanzas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CelsoFinanzas celsoFinanzas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            celsoFinanzas = em.merge(celsoFinanzas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = celsoFinanzas.getId();
                if (findCelsoFinanzas(id) == null) {
                    throw new NonexistentEntityException("The celsoFinanzas with id " + id + " no longer exists.");
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
            CelsoFinanzas celsoFinanzas;
            try {
                celsoFinanzas = em.getReference(CelsoFinanzas.class, id);
                celsoFinanzas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The celsoFinanzas with id " + id + " no longer exists.", enfe);
            }
            em.remove(celsoFinanzas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CelsoFinanzas> findCelsoFinanzasEntities() {
        return findCelsoFinanzasEntities(true, -1, -1);
    }

    public List<CelsoFinanzas> findCelsoFinanzasEntities(int maxResults, int firstResult) {
        return findCelsoFinanzasEntities(false, maxResults, firstResult);
    }

    private List<CelsoFinanzas> findCelsoFinanzasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CelsoFinanzas.class));
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

    public CelsoFinanzas findCelsoFinanzas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CelsoFinanzas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCelsoFinanzasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CelsoFinanzas> rt = cq.from(CelsoFinanzas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
