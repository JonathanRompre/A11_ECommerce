/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modele.CartProduct;

/**
 *
 * @author Jon
 */
public class CartProductDaoImpl implements ICartProductDao {

    private EntityManagerFactory entityManagerFactory;

    public CartProductDaoImpl() {
        entityManagerFactory = ConnectionManager.getInstance().getEntityManagerFactory();
    }

    @Override
    public boolean saveCartProduct(CartProduct cartProduct) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cartProduct);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public boolean deleteCartProduct(CartProduct cartProduct) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        }finally{
            entityManager.close();
        }
    }

    @Override
    public boolean updateCartProductQuantity(CartProduct cartProduct, Integer newQuantity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<CartProduct> getAllCartProductsWithCartId(Integer cartId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        }finally{
            entityManager.close();
        }
    }

    @Override
    public boolean deleteAllCartProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        }finally{
            entityManager.close();
        }
    }

}
