/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modele.Administrator;
import modele.Product;
import modele.User;

/**
 *
 * @author Samuel
 */
public class AdministratorDaoImpl implements IAdministratorDao {
    
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AdministratorDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(ConstantesDao.PERSISTENCE_NAME);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean saveUserPassword(Administrator administrator) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(administrator);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }}
    
}
