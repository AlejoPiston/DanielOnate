/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import modelos.Terapia;
import servicios.exceptions.NonexistentEntityException;
import servicios.exceptions.RollbackFailureException;

/**
 *
 * @author Liz
 */
public class TerapiaJpaController implements Serializable {

    public TerapiaJpaController(UserTransaction utx, EntityManager em) {
        this.utx = utx;
        this.em = em;
    }
    private UserTransaction utx = null;
    private EntityManager em = null;

   

    public void create(Terapia terapia) throws RollbackFailureException, Exception {
  
        try {
            utx.begin();
           
            em.persist(terapia);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } 
    }

    public void edit(Terapia terapia) throws NonexistentEntityException, RollbackFailureException, Exception {
        
        try {
            utx.begin();
            
            terapia = em.merge(terapia);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = terapia.getTerapiaid();
                if (findTerapia(id) == null) {
                    throw new NonexistentEntityException("The terapia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } 
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        
        try {
            utx.begin();
            
            Terapia terapia;
            try {
                terapia = em.getReference(Terapia.class, id);
                terapia.getTerapiaid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The terapia with id " + id + " no longer exists.", enfe);
            }
            em.remove(terapia);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } 
    }

    public List<Terapia> findTerapiaEntities() {
        return findTerapiaEntities(true, -1, -1);
    }

    public List<Terapia> findTerapiaEntities(int maxResults, int firstResult) {
        return findTerapiaEntities(false, maxResults, firstResult);
    }

    private List<Terapia> findTerapiaEntities(boolean all, int maxResults, int firstResult) {
       
        
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Terapia.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
       
    }

    public Terapia findTerapia(Integer id) {
        
        
            return em.find(Terapia.class, id);
        
    }

    public int getTerapiaCount() {
       
       
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Terapia> rt = cq.from(Terapia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
      
    }
    
}
