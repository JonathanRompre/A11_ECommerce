/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modele.User;

/**
 * Defines the basic CRUD operations for interaction with the User table
 * @author Jon
 */
public interface IUserDao {
    
    /**
     * Saves a new user to the database. New is defined by email. 
     * No two accounts can have the same email. 
     * @param user to save to the database
     * @return true if success, else false
     */
    boolean saveUser(User user);
    
    /**
     * Checks whether a user with the given id exists in the database.
     * @param id to check for in the databse
     * @return true if id is found, else false
     */
    boolean userIdExists(Integer id);
    
    /**
     * Checks whether a user with the given email exists in the database;
     * @param email to check for in the database
     * @return true if email is found, else false
     */
    boolean userEmailExists(String email);
    
    /**
     * Gets a user matching given id from the database
     * @param id of the user to get
     * @return the User object corresponding to the id, else null
     */
    User getUserById(Integer id);
    
    /**
     * Retrieves the salt for the user matching the given id
     * @param id of the user for which to get the salt.
     * @return byte array of the salt saved for this user, null if no salt saved.
     */
    byte[] getUserSaltById(Integer id);
    
    /**
     * Retrieves the hashed password for the user matching the given id.
     * @param id of the user for which to get the password.
     * @return byte array of the hashed password of the user, else null.
     */
    byte[] getUserPasswordById(Integer id);
    
    /**
     * Gets the user id matching the given email. The id is to be used to
     * authenticate the user by then comparing the given password using the
     * appropriate method.
     * @param email of the user for which to retrieve the id.
     * @return the id of the user matching the email, null if
     * none exist or error occurs.
     */
    Integer getUserIdFromEmail(String email);
    
    /**
     * Gets all the users saved in the database. 
     * @return a list of all the users
     */
    List<User> getAllUsers();
    
    /**
     * Persists the whole user to the database.
     * @param user to update
     * @return true if success, else false
     */
    boolean updateUser(User user);
    
    /**
     * Updates the email of a user, who's id is given, with the given email that
     * replaces the current one. Confirms that the new email does not already exist
     * in the database before updating
     * @param id of the uesr to update
     * @param newEmail of the user to update
     * @return true if success, else false
     */
    boolean updateUserEmailFromId(Integer id, String newEmail);
    
    /**
     * Updates the password of a user who's id is given with the given new 
     * password. Password validation must be done before calling this method.
     * @param id
     * @param newPassword
     * @return true if success, else false
     */
    boolean updateUserPasswordFromId(Integer id, String newPassword);
    
    /**
     * Deletes a user from the database. 
     * Only use if a logged in user deletes their own account.
     * User validation must be done before calling this method.
     * @param user to delete from the database
     * @return true if sucess, else false
     */
    boolean deleteUser(User user);
    
    /**
     * Deletes every user from the database and resets the 
     * ID autoincrement counter
     * @return true on success, else false.
     */
    boolean deleteAllUsers();
    
    /**
     * Checks whether the user matching the given id is suspended
     * @return true if user suspended, else false;
     */
    boolean isUserSuspended(Integer id);
}