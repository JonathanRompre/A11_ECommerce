/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modele.Product;

/**
 *
 * @author Jon
 */
public class ProductDaoImpl implements IProductDao {

    private EntityManagerFactory entityManagerFactory;

    public ProductDaoImpl() {
        entityManagerFactory = ConnectionManager.getInstance().getEntityManagerFactory();
    }

    @Override
    public boolean saveProduct(Product product) {
        EntityManager entityManager;
        entityManager = entityManagerFactory.createEntityManager();
        if (entityManager.find(Product.class, product.getId()) == null) {
            try {
                
                entityManager.getTransaction().begin();
                entityManager.persist(product);
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
        return false;
    }

    @Override
    public Product getProductById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        }finally{
            entityManager.close();
        }
    }

    @Override
    public boolean isProductActive(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        }finally{
            entityManager.close();
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
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
    public boolean updateProductPriceFromId(Integer id, double newPrice) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // get product from id
            // update product
            entityManager.getTransaction().begin();
            Product product = (Product) entityManager.createNativeQuery(ConstantesDao.GET_PRODUCT_FROM_ID + id, Product.class).getResultList().get(0);
            product.setPrice(newPrice);
            entityManager.merge(product);
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
    public boolean updateProductDescriptionFromId(Integer id, String locale, String newDesc) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // get product from id
            Product product = getProductById(id);
            // update product
            product.setDescription(newDesc);
            entityManager.getTransaction().begin();
            entityManager.merge(product);
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
    public boolean updateProductQuantityFromId(Integer id, Integer newQuantity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // get product from id
            Product product = getProductById(id);
            // update product
            product.setQuantity(newQuantity);
            entityManager.getTransaction().begin();
            entityManager.merge(product);
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
    public boolean deleteAllProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        }finally{
            entityManager.close();
        }
    }

     @Override
    public List<Product> getProductListFromCustomFilter(String query) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Product> products = new ArrayList<>();
        try{
            entityManager.getTransaction().begin();
            products = entityManager.createNativeQuery(query, Product.class).getResultList();
            entityManager.getTransaction().commit();
            return products;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return new ArrayList<Product>();
        }finally{
            entityManager.close();
        }
    }
}
