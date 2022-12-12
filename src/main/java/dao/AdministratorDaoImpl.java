/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modele.Administrator;

/**
 *
 * @author Samuel
 */
public class AdministratorDaoImpl implements IAdministratorDao {
    
    private EntityManagerFactory entityManagerFactory;

    public AdministratorDaoImpl() {
        entityManagerFactory = ConnectionManager.getInstance().getEntityManagerFactory();
    }

    @Override
    public boolean saveUserPassword(Administrator administrator) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(administrator);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if(entityManager != null)
                entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }
}
