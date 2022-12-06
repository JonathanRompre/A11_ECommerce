/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.List;
import modele.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jon
 */
public class ProductDaoImplTest {

    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    public ProductDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        System.out.println("Delete all products: " + productDaoImpl.deleteAllProducts());
    }

    /**
     * Test of saveProduct method, of class ProductDaoImpl.
     */
    @Test
    public void testSaveProduct() {
        System.out.println("saveUser");
        Product product = new Product(1, "Name", "desc1", "img1", 1, 10.00, "dog", true, false);
        boolean expResult = true;
        boolean result = productDaoImpl.saveProduct(product);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductById method, of class ProductDaoImpl.
     */
    @Test
    public void testGetProductById() {
        System.out.println("getProductById");
        Product productSet = new Product(1, "Name", "desc1", "img1", 1, 10.00, "dog", true, false);
        // set up for test
        boolean result = productDaoImpl.saveProduct(productSet);
        assertTrue("Set up for getProductById", result);
        /// actual test
        // Get all users
        Product productExpected = productDaoImpl.getAllProducts().get(0);
        Product productResult = productDaoImpl.getProductById(productExpected.getId());
        assertEquals(productExpected, productResult);
    }

    /**
     * Test of isProductActive method, of class ProductDaoImpl.
     */
    @Test
    public void testIsProductActive() {
        System.out.println("isProductActive");
        Product product = new Product(1, "Name", "desc1", "img1", 1, 10.00, "dog", true, false);
        productDaoImpl.saveProduct(product);
        product = productDaoImpl.getAllProducts().get(0);
        boolean result = productDaoImpl.isProductActive(product.getId());
        assertEquals(true, result);
    }

    /**
     * Test of updateProduct method, of class ProductDaoImpl.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        productDaoImpl.saveProduct(new Product(1, "Name", "desc1", "img1", 1, 10.10, "dog", true, false));
        Product product = productDaoImpl.getAllProducts().get(0);
        product.setActive(false);
        product.setDescription("desc2");
        product.setImageName("img2");
        product.setPrice(20.20);
        product.setQuantity(2);
        product.setRecurrentPossible(true);
        Product expectedProduct = product;
        boolean result = productDaoImpl.updateProduct(product);
        Product resultProduct = productDaoImpl.getAllProducts().get(0);
        assertTrue(result);
        assertEquals(expectedProduct, resultProduct);
    }

    /**
     * Test of updateProductPriceFromId method, of class ProductDaoImpl.
     */
    @Test
    public void testUpdateProductPriceFromId() {
        System.out.println("updateProductPriceFromId");
        productDaoImpl.saveProduct(new Product(1, "Name", "desc1", "img1", 1, 10.10, "dog", true, false));
        Product product = productDaoImpl.getAllProducts().get(0);
        double newPrice = 20.20;
        int id = product.getId();
        boolean result = productDaoImpl.updateProductPriceFromId(id, newPrice);
        assertTrue(result);
        product.setPrice(newPrice);
        Product resultProduct = productDaoImpl.getAllProducts().get(0);
        assertEquals(product, resultProduct);
    }

    /**
     * Test of updateProductDescriptionFromId method, of class ProductDaoImpl.
     */
    @Test
    public void testUpdateProductDescriptionFromId() {
        System.out.println("updateProductDescriptionFromId");
        productDaoImpl.saveProduct(new Product(1, "Name", "desc1", "img1", 1, 10.10, "dog", true, false));
        Product product = productDaoImpl.getAllProducts().get(0);
        String newDesc = "desc2";
        int id = product.getId();
        boolean result = productDaoImpl.updateProductDescriptionFromId(id, "EN_ca", newDesc);
        assertTrue(result);
        product.setDescription(newDesc);
        Product resultProduct = productDaoImpl.getAllProducts().get(0);
        assertEquals(product, resultProduct);
    }

    /**
     * Test of updateProductQuantityFromId method, of class ProductDaoImpl.
     */
    @Test
    public void testUpdateProductQuantityFromId() {
        System.out.println("updateProductQuantityFromId");
        productDaoImpl.saveProduct(new Product(1, "Name", "desc1", "img1", 1, 10.10, "dog", true, false));
        Product product = productDaoImpl.getAllProducts().get(0);
        int newQte = 2;
        int id = product.getId();
        boolean result = productDaoImpl.updateProductQuantityFromId(id, newQte);
        assertTrue(result);
        product.setQuantity(newQte);
        Product resultProduct = productDaoImpl.getAllProducts().get(0);
        assertEquals(product, resultProduct);
    }

    /**
     * Test of deleteAllProducts method, of class ProductDaoImpl.
     */
    @Test
    public void testDeleteAllProducts() {
        System.out.println("deleteAllProducts");
        productDaoImpl.saveProduct(new Product(1, "Name1", "desc1", "img1", 1, 10.10, "dog", true, true));
        productDaoImpl.saveProduct(new Product(2, "Name2", "desc2", "img2", 2, 20.20, "dog", false, false));
        productDaoImpl.saveProduct(new Product(3, "Name3", "desc3", "img3", 3, 30.30, "dog", true, true));
        int expectedSize = 3;
        int result = productDaoImpl.getAllProducts().size();
        assertEquals(expectedSize, result);
        
        productDaoImpl.deleteAllProducts();
        expectedSize = 0;
        result = productDaoImpl.getAllProducts().size();
        assertEquals(expectedSize, result);
        
    }

    /**
     * Test of deleteProduct method, of class ProductDaoImpl.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        productDaoImpl.saveProduct(new Product(1, "Name", "desc1", "img1", 1, 10.10, "dog", true, true));
        int expectedSize = 1;
        int result = productDaoImpl.getAllProducts().size();
        assertEquals(expectedSize, result);
        
        Product product = productDaoImpl.getAllProducts().get(0);
        productDaoImpl.deleteProduct(product);
        expectedSize = 0;
        result = productDaoImpl.getAllProducts().size();
        assertEquals(expectedSize, result);
    }

    /**
     * Test of getAllProducts method, of class ProductDaoImpl.
     */
    @Test
    public void testGetAllProducts() {
        System.out.println("getAllProducts");
        productDaoImpl.saveProduct(new Product(1, "Name1", "desc1", "img1", 1, 10.10, "dog", true, true));
        productDaoImpl.saveProduct(new Product(2, "Name2", "desc2", "img2", 2, 20.20, "dog", false, false));
        productDaoImpl.saveProduct(new Product(3, "Name3", "desc3", "img3", 3, 30.30, "dog", true, true));
        int expectedSize = 3;
        int result = productDaoImpl.getAllProducts().size();
        assertEquals(expectedSize, result);
        
    }
}
