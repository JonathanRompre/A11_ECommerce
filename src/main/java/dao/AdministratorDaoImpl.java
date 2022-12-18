/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modele.Administrator;
import modele.User;

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
    public boolean saveAdminPassword(String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            List<Administrator> tmpAdmin = entityManager.createNativeQuery("SELECT * FROM ADMINISTRATOR", Administrator.class).getResultList();
            Administrator admin = tmpAdmin.get(0);
            admin.setPassword(password);
            entityManager.persist(admin);
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

    @Override
    public byte[] getAdminPassword() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            byte[] password = (byte[]) entityManager.createNativeQuery("SELECT password FROM ADMINISTRATOR").getResultList().get(0);
            entityManager.getTransaction().commit();
            return password;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }finally{
            entityManager.close();
        }
    }
 
    @Override
    public byte[] getAdminSalt() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            byte[] salt = (byte[]) entityManager.createNativeQuery("SELECT salt FROM ADMINISTRATOR").getResultList().get(0);
            entityManager.getTransaction().commit();
            return salt;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }finally{
            entityManager.close();
        }
    }
}
