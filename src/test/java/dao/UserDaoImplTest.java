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
        result = userDaoImpl.userIdExists(userGet.getId());
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
        boolean result2 = userDaoImpl.userEmailExists(user.getEmail());
        assertTrue("Test for email ("+user.getEmail()+") exists: "+result2,result2);
    }

    /**
     * Test of getUserById method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        // set up for test
        User userSet = new User("user", "test", "test@mail.com");
        userSet.setPassword("password");
        boolean result = userDaoImpl.saveUser(userSet);
        assertTrue("Set up for getUserById",result);
        /// actual test
        // Get all users
        User userGet = userDaoImpl.getAllUsers().get(0);
        User resultUser = userDaoImpl.getUserById(userGet.getId());
        assertEquals(userGet, resultUser);
    }

    /**
     * Test of getUserIdByEmailPassword method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserIdByEmailPassword() {
        System.out.println("getUserIdByEmailPassword");
        // set up for test
        User userSet = new User("user", "test", "test@mail.com");
        userSet.setPassword("password");
        boolean result = userDaoImpl.saveUser(userSet);
        assertTrue("Set up for getUserIdByEmailPassword",result);
        Integer resultId = userDaoImpl.getUserIdByEmailPassword(userSet.getEmail(), userSet.getPassword());
        User user = userDaoImpl.getAllUsers().get(0);
        assertEquals(user.getId(), resultId);
    }

    /**
     * Test of getAllUsers method, of class UserDaoImpl.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        System.out.println("Ajout users pour test");
        userDaoImpl.saveUser(new User("fn1","ln1","testmail1"));
        userDaoImpl.saveUser(new User("fn2","ln2","testmail2"));
        userDaoImpl.saveUser(new User("fn3","ln3","testmail3"));
        System.out.println("Retrieve list");
        List<User> result = userDaoImpl.getAllUsers();
        assertTrue(result.size() == 3);
    }

    /**
     * Test of updateUser method, of class UserDaoImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        userDaoImpl.saveUser(new User("fn1","ln1","testmail1"));
        User user = userDaoImpl.getAllUsers().get(0);
        user.setFirstName("fn2");
        user.setLastName("ln2");
        user.setEmail("testmail2");
        user.setSuspended(true);
        user.setPassword("testPw");
        User expUserResult = user;
        boolean result = userDaoImpl.updateUser(user);
        User userResult = userDaoImpl.getAllUsers().get(0);
        assertTrue(result);
        assertEquals(expUserResult, userResult);
    }

    /**
     * Test of updateUserEmailFromId method, of class UserDaoImpl.
     */
    @Test
    public void testUpdateUserEmailFromId() {
        System.out.println("updateUserEmailFromId");
        userDaoImpl.saveUser(new User("fn1","ln1","testmail1"));
        User user = userDaoImpl.getAllUsers().get(0);
        Integer id = user.getId();
        String newEmail = "testmail2";
        boolean result = userDaoImpl.updateUserEmailFromId(id, newEmail);
        assertTrue(result);
        user.setEmail(newEmail);
        User resultUser = userDaoImpl.getAllUsers().get(0);
        assertEquals(user, resultUser);
    }

    /**
     * Test of updateUserPasswordFromId method, of class UserDaoImpl.
     */
    @Test
    public void testUpdateUserPasswordFromId() {
        System.out.println("updateUserPasswordFromId");
        userDaoImpl.saveUser(new User("fn1","ln1","testmail1"));
        User user = userDaoImpl.getAllUsers().get(0);
        Integer id = user.getId();
        String newPassword = "testPw1";
        boolean result = userDaoImpl.updateUserPasswordFromId(id, newPassword);
        assertTrue(result);
        user.setPassword(newPassword);
        User resultUser = userDaoImpl.getAllUsers().get(0);
        assertEquals(user, resultUser);
    }

    /**
     * Test of deleteUser method, of class UserDaoImpl.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        userDaoImpl.saveUser(new User("fn1","ln1","testmail1"));
        User user = userDaoImpl.getAllUsers().get(0);
        boolean result = userDaoImpl.deleteUser(user);
        assertTrue(result);
        assertTrue(userDaoImpl.getAllUsers().isEmpty());
    }

}
