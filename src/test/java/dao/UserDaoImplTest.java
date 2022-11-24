/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.List;
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
public class UserDaoImplTest {
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    
    public UserDaoImplTest() {
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
        System.out.println("Delete all users: "+userDaoImpl.deleteAllUsers());
    }

    /**
     * Test of saveUser method, of class UserDaoImpl.
     */
    @Test
    public void testSaveUserSuccessReturnTrue() {
        System.out.println("saveUser");
        User user = new User("user", "test", "test@mail.com");
        user.setPassword("password");
        boolean expResult = true;
        boolean result = userDaoImpl.saveUser(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of userIdExists method, of class UserDaoImpl.
     */
    @Test
    public void testUserIdExists() {
        System.out.println("userIdExists");
        // set up for test
        User userSet = new User("user", "test", "test@mail.com");
        userSet.setPassword("password");
        boolean result = userDaoImpl.saveUser(userSet);
        assertTrue("Set up for userIdExists",result);
        /// actual test
        // Get all users
        User userGet = userDaoImpl.getAllUsers().get(0);
        result = userDaoImpl.userIdExists(userGet.getIdUser());
        assertTrue("Test for id exists",result);
    }

    /**
     * Test of userEmailExists method, of class UserDaoImpl.
     */
    @Test
    public void testUserEmailExists() {
        System.out.println("userEmailExists");
        System.out.println("==========setup");
        // set up for test
        User user = new User("user", "test", "test@mail.com");
        user.setPassword("password");
        boolean result1 = userDaoImpl.saveUser(user);
        assertTrue("Set up for userEmailExists",result1);
        /// actual test
        // Get all users
        System.out.println("==========exec");
        boolean result2 = userDaoImpl.userEmailExists(user.getEmail());
        assertTrue("Test for email ("+user.getEmail()+") exists: "+result2,result2);
    }

    /**
     * Test of getUserById method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        Integer id = null;
        UserDaoImpl instance = new UserDaoImpl();
        User expResult = null;
        User result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserIdByEmailPassword method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserIdByEmailPassword() {
        System.out.println("getUserIdByEmailPassword");
        String email = "";
        String password = "";
        UserDaoImpl instance = new UserDaoImpl();
        Integer expResult = null;
        Integer result = instance.getUserIdByEmailPassword(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class UserDaoImpl.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserDaoImpl instance = new UserDaoImpl();
        List<User> expResult = null;
        List<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserDaoImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        boolean expResult = false;
        boolean result = instance.updateUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserEmailFromId method, of class UserDaoImpl.
     */
    @Test
    public void testUpdateUserEmailFromId() {
        System.out.println("updateUserEmailFromId");
        Integer id = null;
        String newEmail = "";
        UserDaoImpl instance = new UserDaoImpl();
        boolean expResult = false;
        boolean result = instance.updateUserEmailFromId(id, newEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserPasswordFromId method, of class UserDaoImpl.
     */
    @Test
    public void testUpdateUserPasswordFromId() {
        System.out.println("updateUserPasswordFromId");
        Integer id = null;
        String newPassword = "";
        UserDaoImpl instance = new UserDaoImpl();
        boolean expResult = false;
        boolean result = instance.updateUserPasswordFromId(id, newPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDaoImpl.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        boolean expResult = false;
        boolean result = instance.deleteUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
