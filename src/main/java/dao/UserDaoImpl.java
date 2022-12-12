/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import modele.User;

public class UserDaoImpl implements IUserDao {

    private EntityManagerFactory entityManagerFactory;

    public UserDaoImpl() {
        entityManagerFactory = ConnectionManager.getInstance().getEntityManagerFactory();
    }

    @Override
    public boolean saveUser(User user) {
        if (!userEmailExists(user.getEmail())) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(user);
                entityManager.getTransaction().commit();
                return true;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                e.printStackTrace();
                return false;

            } finally {
                entityManager.close();
            }
        }
        return false;
    }

    @Override
    public boolean userIdExists(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean userEmailExists(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean emailExists;
        try {
            entityManager.getTransaction().begin();
            emailExists = !entityManager.createNativeQuery(ConstantesDao.GET_USER_FROM_EMAIL + "'" + email + "'").getResultList().isEmpty();
            entityManager.getTransaction().commit();
            return emailExists;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public User getUserById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = null;
        try {
            entityManager.getTransaction().begin();
            List<User> tmpUserList = entityManager.createNativeQuery(ConstantesDao.GET_USER_FROM_ID + id, User.class).getResultList();
            if (!tmpUserList.isEmpty()) {
                user = tmpUserList.get(0);
            }
            entityManager.getTransaction().commit();
            return user;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Integer getUserIdByEmailPassword(String email, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(ConstantesDao.GET_USER_ID_FROM_EMAIL_PASSWORD);
            query.setParameter("email", email);
            query.setParameter("password", password);
            String tmpString = query.toString();
            List<Integer> returnId = query.getResultList();
            entityManager.getTransaction().commit();
            if (returnId.isEmpty()) {
                return null;
            }
            return returnId.get(0);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
        
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> users;
        try {
            entityManager.getTransaction().begin();
            users = entityManager.createNativeQuery(ConstantesDao.GET_ALL_USERS, User.class).getResultList();
            entityManager.getTransaction().commit();
            return users;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updateUserEmailFromId(Integer id, String newEmail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // get user from id
            User user = getUserById(id);
            // update user
            user.setEmail(newEmail);
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updateUserPasswordFromId(Integer id, String newPassword) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // get user from id
            User user = getUserById(id);
            // update user
            user.setPassword(newPassword);
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deleteUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            User userMerged = entityManager.merge(user);
            entityManager.remove(userMerged);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deleteAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // start by getting all users
            List<User> userList = this.getAllUsers();
            // delete each user.
            for (User u : userList) {
                this.deleteUser(u);
            }
            // reset sequence
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery(ConstantesDao.RESET_HIBERNATE_SEQUENCE).executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }
}
