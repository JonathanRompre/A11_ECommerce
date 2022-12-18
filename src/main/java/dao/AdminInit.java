/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modele.Administrator;

/**
 *
 * @author Jon
 */
public class AdminInit {
    
    EntityManagerFactory entityManagerFactory = ConnectionManager.getInstance().getEntityManagerFactory();
    
    private static AdminInit instance = null;
    
    private AdminInit(){
        if(!isAdminInitialized()){
            initializeAdmin();
        }
    }
    
    public static void initAdmin(){
        if(instance == null)
            instance = new AdminInit();
    }
    
    private boolean isAdminInitialized(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean isInitialized;
        try{
            entityManager.getTransaction().begin();
            if(((Number)entityManager.createNativeQuery(ConstantesDao.IS_ADMIN_EXISTS).getSingleResult()).intValue() == 0){ // check whether there's an admin.
                isInitialized = false;
            }else if(((Number)entityManager.createNativeQuery(ConstantesDao.IS_ADMIN_PASSWORD_SET).getSingleResult()).intValue() == 0){ // check whether the password is set for the admin account.
                isInitialized = false;
            }else{
                isInitialized = true;
            }
            entityManager.getTransaction().commit();
            return isInitialized;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }finally{
            entityManager.close();
        }
    }
    
    public boolean initializeAdmin(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("DELETE FROM ADMINISTRATOR WHERE admin_id IS NOT NULL").executeUpdate();
            Administrator admin = new Administrator();
            admin.setId(1);
            admin.setPassword("admin");
            entityManager.persist(admin);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }finally{
            entityManager.close();
        }
    }
    
}
