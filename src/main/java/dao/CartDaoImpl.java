/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Cart;

/**
 *
 * @author Jon
 */
public class CartDaoImpl implements ICartDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public CartDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(ConstantesDao.PERSISTENCE_NAME);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean saveCart(Cart cart) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cart);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cart getCartById(Integer id) {
        try {
            entityManager.getTransaction().begin();
            List<Cart> tmpList = entityManager.createNativeQuery(ConstantesDao.GET_CART_FROM_ID+id, Cart.class).getResultList();
            if (tmpList.isEmpty()) {
                return null;
            }
            entityManager.getTransaction().commit();
            return tmpList.get(0);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer getCurrentCartIdByUserId(Integer id) {
        try {
            entityManager.getTransaction().begin();
            List<Integer> tmpList = entityManager.createNativeQuery(ConstantesDao.GET_CURRENT_CART_ID_FOR_USER_ID+id).getResultList();
            entityManager.getTransaction().commit();
            if (tmpList.isEmpty()) {
                return null;
            }
            return tmpList.get(0);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean hasActiveCartForUserId(Integer id) {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(ConstantesDao.GET_CURRENT_CART_EXISTS_FOR_USER_ID_HQL);
            query.setParameter("id", id);
            List<Boolean> tmpList = query.getResultList();
            //List<BigInteger> tmpList = entityManager.createNativeQuery(ConstantesDao.GET_CURRENT_CART_EXISTS_FOR_USER_ID+id).getResultList();
            entityManager.getTransaction().commit();
            if(tmpList.isEmpty())
                return false;
            return tmpList.get(0);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Cart> getAllCartsForUserId(Integer id) {
        try {
            entityManager.getTransaction().begin();
            List<Cart> tmpList = entityManager.createNativeQuery(ConstantesDao.GET_ALL_CARTS_FOR_USER_ID+id, Cart.class).getResultList();
            entityManager.getTransaction().commit();
            return tmpList;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteCart(Cart cart) {
        try {
            entityManager.getTransaction().begin();
            Cart cartMerged = entityManager.merge(cart);
            entityManager.remove(cartMerged);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCartByCartId(Integer id) {
        try {
            Cart cart = getCartById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(cart);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAllCarts() {
        try {
            entityManager.getTransaction().begin();
            List<Cart> tmpList = entityManager.createNativeQuery(ConstantesDao.GET_ALL_CARTS, Cart.class).getResultList();
            entityManager.getTransaction().commit();
            for (Cart c : tmpList) {
                deleteCart(c);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setCartCurrentFalseForUserId(Integer id) {
        try {
            Integer cartId = getCurrentCartIdByUserId(id);
            Cart cart = getCartById(cartId);
            cart.setCurrent(false);
            entityManager.getTransaction().begin();
            entityManager.merge(cart);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

}
