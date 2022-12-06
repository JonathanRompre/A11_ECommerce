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
import modele.CartProduct;

/**
 *
 * @author Jon
 */
public class CartProductDaoImpl implements ICartProductDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public CartProductDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(ConstantesDao.PERSISTENCE_NAME);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean saveCartProduct(CartProduct cartProduct) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cartProduct);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCartProduct(CartProduct cartProduct) {
        try {
            entityManager.getTransaction().begin();
            CartProduct cartProductMerged = entityManager.merge(cartProduct);
            entityManager.remove(cartProductMerged);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCartProductQuantity(CartProduct cartProduct, Integer newQuantity) {
        try {
            cartProduct.setQuantity(newQuantity);
            entityManager.getTransaction().begin();
            entityManager.merge(cartProduct);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CartProduct> getAllCartProductsWithCartId(Integer cartId) {
        List<CartProduct> tmpList = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            tmpList = entityManager.createNativeQuery(ConstantesDao.GET_ALL_CART_PRODUCTS_FOR_CART_ID + cartId, CartProduct.class).getResultList();
            entityManager.getTransaction().commit();
            return tmpList;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return tmpList;
        }
    }

    @Override
    public boolean deleteAllCartProducts() {
        try {
            entityManager.getTransaction().begin();
            List<CartProduct> tmpList = entityManager.createNativeQuery(ConstantesDao.GET_ALL_CART_PRODUCTS, CartProduct.class).getResultList();
            for(CartProduct cp : tmpList){
                entityManager.remove(cp);
            }
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

}
