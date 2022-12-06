/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modele.Product;
import modele.User;

/**
 *
 * @author Jon
 */
public class ProductDaoImpl implements IProductDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public ProductDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(ConstantesDao.PERSISTENCE_NAME);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean saveProduct(Product product) {
        if(entityManager.find(Product.class, product.getId())== null){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }}
        return false;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = null;
        try {
            entityManager.getTransaction().begin();
            List<Product> tmpProductList = entityManager.createNativeQuery(ConstantesDao.GET_PRODUCT_FROM_ID + id, Product.class).getResultList();
            if (!tmpProductList.isEmpty()) {
                product = tmpProductList.get(0);
            }
            entityManager.getTransaction().commit();
            return product;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isProductActive(Integer id) {
        boolean productActive = false;
        try {
            entityManager.getTransaction().begin();
            List<Boolean> tmpActiveList = entityManager.createNativeQuery(ConstantesDao.GET_PRODUCT_ACTIVE_STATUS + id).getResultList();
            if (!tmpActiveList.isEmpty()) {
                productActive = tmpActiveList.get(0);
            }
            entityManager.getTransaction().commit();
            return productActive;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProductPriceFromId(Integer id, double newPrice) {
        try{
            // get product from id
            Product product = getProductById(id);
            // update product
            product.setPrice(newPrice);
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProductDescriptionFromId(Integer id, String locale, String newDesc) {
        try{
            // get product from id
            Product product = getProductById(id);
            // update product
            product.setDescription(newDesc);
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProductQuantityFromId(Integer id, Integer newQuantity) {
        try{
            // get product from id
            Product product = getProductById(id);
            // update product
            product.setQuantity(newQuantity);
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAllProducts() {
        try {
            // start by getting all products
            List<Product> productList = this.getAllProducts();
            // delete each product.
            for (Product p : productList) {
                this.deleteProduct(p);
            }
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery(ConstantesDao.RESET_HIBERNATE_SEQUENCE).executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            Product productMerged = entityManager.merge(product);
            entityManager.remove(productMerged);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products;
        try {
            entityManager.getTransaction().begin();
            products = entityManager.createNativeQuery(ConstantesDao.GET_ALL_PRODUCTS, Product.class).getResultList();
            entityManager.getTransaction().commit();
            return products;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

}
