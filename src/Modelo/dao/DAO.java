/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Transient;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class DAO<T> implements Serializable{

    protected static EntityManager entityManager;

    public DAO(){
        
    }
    
    private EntityManager getEntityManager() {
              if (entityManager == null) {
                    EntityManagerFactory factory = Persistence.createEntityManagerFactory("batata");
                    entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public void save(){
        EntityManager entityManager = getEntityManager();
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(this);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    
    public void update(){
        EntityManager entityManager = getEntityManager();

        try {
                 entityManager.getTransaction().begin();
                 entityManager.merge(this);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    public void delete(){
        EntityManager entityManager = getEntityManager();

        try {
                 entityManager.getTransaction().begin();
                 entityManager.remove(this);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    @SuppressWarnings("unchecked")
    public List<T> all(){
        EntityManager entityManager = getEntityManager();
        return entityManager.createQuery("FROM " + this.getClass().getName()).getResultList();
    } 

}
