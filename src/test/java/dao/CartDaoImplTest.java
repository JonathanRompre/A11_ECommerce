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
    User user;
    
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
        userDaoImpl.saveUser(new User("fn1", "ln1", "mail"));
        user = userDaoImpl.getAllUsers().get(0);
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
        boolean result = cartDaoImpl.saveCart(new Cart(user, true));
        assertTrue(result);
        Cart cart = cartDaoImpl.getAllCartsForUserId(1).get(0);
        Cart resultCart = cartDaoImpl.getCartById(cart.getId());
        assertTrue(cart.equals(resultCart));
        assertEquals(cart, resultCart);
    }

    /**
     * Test of getCurrentCartIdByUserId method, of class CartDaoImpl.
     */
    @Test
    public void testGetCurrentCartIdByUserId() {
        System.out.println("getCurrentCartIdByUserId");
        boolean result = cartDaoImpl.saveCart(new Cart(user, true));
        assertTrue(result);
        Cart cart = cartDaoImpl.getAllCartsForUserId(1).get(0);
        int cartCurrentId = cartDaoImpl.getCurrentCartIdByUserId(user.getId());
        assertEquals((int) cart.getId(), cartCurrentId);
    }

    /**
     * Test of hasActiveCartForUserId method, of class CartDaoImpl.
     */
    @Test
    public void testHasActiveCartForUserId() {
        System.out.println("hasActiveCartForUserId");
        boolean result = cartDaoImpl.saveCart(new Cart(user, true));
        assertTrue(result);
        boolean hasActive = cartDaoImpl.hasActiveCartForUserId(user.getId());
        assertTrue(hasActive);
        cartDaoImpl.setCartCurrentFalseForUserId(user.getId());
        hasActive = cartDaoImpl.hasActiveCartForUserId(user.getId());
        assertFalse(hasActive);
    }

    /**
     * Test of getAllCartsForUserId method, of class CartDaoImpl.
     */
    @Test
    public void testGetAllCartsForUserId() {
        System.out.println("getAllCartsForUserId");
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        assertTrue(cartDaoImpl.saveCart(new Cart(user, true)));
        int expectedSize = 5;
        
        List<Cart> cartList = cartDaoImpl.getAllCartsForUserId(user.getId());
        assertEquals(expectedSize, cartList.size());
    }

    /**
     * Test of deleteCart method, of class CartDaoImpl.
     */
    @Test
    public void testDeleteCart() {
        System.out.println("deleteCart");
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        List<Cart> cartResultList = cartDaoImpl.getAllCartsForUserId(user.getId());
        int expectedSize = 1;
        assertEquals(expectedSize, cartResultList.size());
        assertTrue(cartDaoImpl.deleteCart(cartResultList.get(0)));
        expectedSize = 0;
        cartResultList = cartDaoImpl.getAllCartsForUserId(user.getId());
        assertEquals(expectedSize, cartResultList.size());
    }

    /**
     * Test of deleteCartByCartId method, of class CartDaoImpl.
     */
    @Test
    public void testDeleteCartByCartId() {
        System.out.println("deleteCartByCartId");
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        List<Cart> cartResultList = cartDaoImpl.getAllCartsForUserId(user.getId());
        int expectedSize = 1;
        assertEquals(expectedSize, cartResultList.size());
        assertTrue(cartDaoImpl.deleteCartByCartId(cartResultList.get(0).getId()));
        expectedSize = 0;
        cartResultList = cartDaoImpl.getAllCartsForUserId(user.getId());
        assertEquals(expectedSize, cartResultList.size());
    }

    /**
     * Test of deleteAllCarts method, of class CartDaoImpl.
     */
    @Test
    public void testDeleteAllCarts() {
        System.out.println("deleteAllCarts");
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        assertTrue(cartDaoImpl.saveCart(new Cart(user, false)));
        assertTrue(cartDaoImpl.saveCart(new Cart(user, true)));
        int expectedSize = 5;
        
        List<Cart> cartList = cartDaoImpl.getAllCartsForUserId(user.getId());
        assertEquals(expectedSize, cartList.size());
        
        assertTrue(cartDaoImpl.deleteAllCarts());
        expectedSize = 0;
        cartList = cartDaoImpl.getAllCartsForUserId(user.getId());
        assertEquals(expectedSize, cartList.size());
        
    }

    /**
     * Test of setCartCurrentFalseForUserId method, of class CartDaoImpl.
     */
    @Test
    public void testSetCartCurrentFalseForUserId() {
        System.out.println("setCartCurrentFalseForUserId");
        assertTrue(cartDaoImpl.saveCart(new Cart(user, true)));
        assertTrue(cartDaoImpl.setCartCurrentFalseForUserId(user.getId()));
        assertFalse(cartDaoImpl.getAllCartsForUserId(user.getId()).get(0).isCurrent());
    }
}
