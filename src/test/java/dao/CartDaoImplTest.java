/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.List;
import modele.Cart;
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
public class CartDaoImplTest {
    CartDaoImpl cartDaoImpl = new CartDaoImpl();
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    
    public CartDaoImplTest() {
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
        System.out.println("Delete all carts: "+cartDaoImpl.deleteAllCarts());
        System.out.println("Delete all users: "+userDaoImpl.deleteAllUsers());
    }

    /**
     * Test of saveCart method, of class CartDaoImpl.
     */
    @Test
    public void testSaveCart() {
        System.out.println("saveCart");
        userDaoImpl.saveUser(new User("fn1", "ln1", "mail"));
        User user = userDaoImpl.getAllUsers().get(0);
        Cart cart = new Cart(user, true);
        boolean result = cartDaoImpl.saveCart(cart);
        assertTrue(result);
    }

    /**
     * Test of getCartById method, of class CartDaoImpl.
     */
    @Test
    public void testGetCartById() {
        System.out.println("getCartById");
        boolean tmp = userDaoImpl.saveUser(new User("fn1", "ln1", "mail"));
        User user = userDaoImpl.getAllUsers().get(0);
        boolean result = cartDaoImpl.saveCart(new Cart(user, true));
        assertTrue(result);
        Cart cart = cartDaoImpl.getAllCartsForUserId(1).get(0);
        Cart resultCart = cartDaoImpl.getCartById(cart.getId());
        assertEquals(cart, resultCart);
    }

    /**
     * Test of getCurrentCartIdByUserId method, of class CartDaoImpl.
     */
    @Test
    public void testGetCurrentCartIdByUserId() {
        System.out.println("getCurrentCartIdByUserId");
        Integer id = null;
        CartDaoImpl instance = new CartDaoImpl();
        Integer expResult = null;
        Integer result = instance.getCurrentCartIdByUserId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasActiveCartForUserId method, of class CartDaoImpl.
     */
    @Test
    public void testHasActiveCartForUserId() {
        System.out.println("hasActiveCartForUserId");
        Integer id = null;
        CartDaoImpl instance = new CartDaoImpl();
        boolean expResult = false;
        boolean result = instance.hasActiveCartForUserId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCartsForUserId method, of class CartDaoImpl.
     */
    @Test
    public void testGetAllCartsForUserId() {
        System.out.println("getAllCartsForUserId");
        Integer id = null;
        CartDaoImpl instance = new CartDaoImpl();
        List<Cart> expResult = null;
        List<Cart> result = instance.getAllCartsForUserId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCart method, of class CartDaoImpl.
     */
    @Test
    public void testDeleteCart() {
        System.out.println("deleteCart");
        Cart cart = null;
        CartDaoImpl instance = new CartDaoImpl();
        boolean expResult = false;
        boolean result = instance.deleteCart(cart);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCartByCartId method, of class CartDaoImpl.
     */
    @Test
    public void testDeleteCartByCartId() {
        System.out.println("deleteCartByCartId");
        Integer id = null;
        CartDaoImpl instance = new CartDaoImpl();
        boolean expResult = false;
        boolean result = instance.deleteCartByCartId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAllCarts method, of class CartDaoImpl.
     */
    @Test
    public void testDeleteAllCarts() {
        System.out.println("deleteAllCarts");
        CartDaoImpl instance = new CartDaoImpl();
        boolean expResult = false;
        boolean result = instance.deleteAllCarts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCartCurrentFalseForUserId method, of class CartDaoImpl.
     */
    @Test
    public void testSetCartCurrentFalseForUserId() {
        System.out.println("setCartCurrentFalseForUserId");
        Integer id = null;
        CartDaoImpl instance = new CartDaoImpl();
        boolean expResult = false;
        boolean result = instance.setCartCurrentFalseForUserId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
