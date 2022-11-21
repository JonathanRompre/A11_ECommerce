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
import javax.persistence.Query;
import modele.User;

public class UserDaoImpl implements IUserDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UserDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(ConstantesDao.PERSISTENCE_NAME);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean saveUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean userIdExists(Integer id) {
        boolean idExists = false;
        try {
            entityManager.getTransaction().begin();
            idExists = entityManager.createNativeQuery(ConstantesDao.GET_USER_FROM_ID + id).getResultList().size() > 0;
            entityManager.getTransaction().commit();
            return idExists;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean userEmailExists(String email) {
        boolean emailExists = false;
        try {
            entityManager.getTransaction().begin();
            emailExists = !entityManager.createNativeQuery(ConstantesDao.GET_USER_FROM_EMAIL + email).getResultList().isEmpty();
            entityManager.getTransaction().commit();
            return emailExists;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(Integer id) {
        User user = null;
        try {
            entityManager.getTransaction().begin();
            List<User> tmpUserList = entityManager.createNativeQuery(ConstantesDao.GET_USER_FROM_ID + id, User.class).getResultList();
            if(!tmpUserList.isEmpty()){
                user = tmpUserList.get(0);
            }
            entityManager.getTransaction().commit();
            return user;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer getUserIdByEmailPassword(String email, String password) {
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(ConstantesDao.GET_USER_ID_FROM_EMAIL_PASSWORD);
            query.setParameter("email", email);
            query.setParameter("password", password);
            Integer returnId = query.executeUpdate();
            entityManager.getTransaction().commit();
            return returnId;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            users = entityManager.createNativeQuery(ConstantesDao.GET_ALL_USERS, User.class).getResultList();
            entityManager.getTransaction().commit();
            return users;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUserEmailFromId(Integer id, String newEmail) {
        try{
            entityManager.getTransaction().begin();
            // get user from id
            User user = this.getUserById(id);
            user.setEmail(newEmail);
            // update user
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUserPasswordFromId(Integer id, String newPassword) {
        try{
            entityManager.getTransaction().begin();
            // get user from id
            User user = this.getUserById(id);
            user.setPassword(newPassword);
            // update user
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }    }

    @Override
    public boolean deleteUser(User user) {
        try{
            entityManager.getTransaction().begin();
            User userMerged = entityManager.merge(user);
            entityManager.remove(userMerged);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

}
