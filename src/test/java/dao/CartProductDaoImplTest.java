/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.Date;
import java.util.List;
import modele.Cart;
import modele.CartProduct;
import modele.Constantes;
import modele.Product;
import modele.User;
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
public class CartProductDaoImplTest {

    CartProductDaoImpl cartProductDaoImpl;
    UserDaoImpl userDaoImpl;
    CartDaoImpl cartDaoImpl;
    ProductDaoImpl productDaoImpl;
    // Préparation des requis pour le test.
    User user1;
    Cart cart1;
    Product product1;
    Product product2;

    public CartProductDaoImplTest() {
        cartProductDaoImpl = new CartProductDaoImpl();
        userDaoImpl = new UserDaoImpl();
        cartDaoImpl = new CartDaoImpl();
        productDaoImpl = new ProductDaoImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Préparation d'un user
        user1 = new User("fn1", "ln1", "mail");
        userDaoImpl.saveUser(user1);

        // Préparation d'un cart
        cart1 = new Cart(user1, true);
        cartDaoImpl.saveCart(cart1);

        //Préparation de produits
        product1 = new Product(5449, "description product 1", "imageProduct1.jpg", 10, 19.99, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
        productDaoImpl.saveProduct(product1);
        product2 = new Product(5450, "description product 2", "imageProduct2.jpg", 20, 29.99, Constantes.CATEGORIE_PRODUIT_CHIEN, false, true);
        productDaoImpl.saveProduct(product2);
    }

    @After
    public void tearDown() {
        cartProductDaoImpl.deleteAllCartProducts();
        cartDaoImpl.deleteAllCarts();
        userDaoImpl.deleteAllUsers();
        productDaoImpl.deleteAllProducts();
    }

    /**
     * Test of saveCartProduct method, of class CartProductDaoImpl.
     */
    @Test
    public void testSaveCartProduct() {
        System.out.println("saveCartProduct");
        CartProduct cartProduct = new CartProduct(cart1, product1, 1, new Date());
        boolean result = cartProductDaoImpl.saveCartProduct(cartProduct);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }

    /**
     * Test of deleteCartProduct method, of class CartProductDaoImpl.
     */
    @Test
    public void testDeleteCartProduct() {
        System.out.println("deleteCartProduct");
        CartProduct cartProduct = new CartProduct(cart1, product1, 1, new Date());
        boolean result = cartProductDaoImpl.saveCartProduct(cartProduct);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
        assertTrue(cartProductDaoImpl.deleteCartProduct(cartProduct));
        int resultSize = cartProductDaoImpl.getAllCartProductsWithCartId(cart1.getId()).size();
        int expectedSize = 0;
        assertEquals(expectedSize, resultSize);

    }

    /**
     * Test of updateCartProductQuantity method, of class CartProductDaoImpl.
     */
    @Test
    public void testUpdateCartProductQuantity() {
        System.out.println("updateCartProductQuantity");
        CartProduct cartProduct = new CartProduct(cart1, product1, 1, new Date());
        boolean result = cartProductDaoImpl.saveCartProduct(cartProduct);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
        int newQuantity = 21;
        assertTrue(cartProductDaoImpl.updateCartProductQuantity(cartProduct, newQuantity));
        int resultQuantity = cartProductDaoImpl.getAllCartProductsWithCartId(cart1.getId()).get(0).getQuantity();
        assertEquals(newQuantity, resultQuantity);
    }

    /**
     * Test of getAllCartProductsWithCartId method, of class CartProductDaoImpl.
     */
    @Test
    public void testGetAllCartProductsWithCartId() {
        System.out.println("getAllCartProductsWithCartId");
        assertTrue(cartProductDaoImpl.saveCartProduct(new CartProduct(cart1, product1, 1, new Date())));
        assertTrue(cartProductDaoImpl.saveCartProduct(new CartProduct(cart1, product2, 2, new Date())));
        int expectedSize = 2;
        int resultSize = cartProductDaoImpl.getAllCartProductsWithCartId(cart1.getId()).size();
        assertEquals(expectedSize, resultSize);
    }

    /**
     * Test of deleteAllCartProducts method, of class CartProductDaoImpl.
     */
    @Test
    public void testDeleteAllCartProducts() {
        System.out.println("deleteAllCartProducts");
        assertTrue(cartProductDaoImpl.saveCartProduct(new CartProduct(cart1, product1, 1, new Date())));
        assertTrue(cartProductDaoImpl.saveCartProduct(new CartProduct(cart1, product2, 2, new Date())));
        assertTrue(cartProductDaoImpl.deleteAllCartProducts());
        int expectedSize = 0;
        int resultSize = cartProductDaoImpl.getAllCartProductsWithCartId(cart1.getId()).size();
        assertEquals(expectedSize, resultSize);
    }
}
