/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modele.Administrator;
import modele.Product;
import modele.User;

/**
 *
 * @author Samuel
 */
public interface IAdministratorDao  {
    /**
     * Saves the password for an admin
     * @param password String of the new password
     * @return true if success, else false
     */
    boolean saveAdminPassword(String password);
    
    /**
     * Retrieves hashed value of the admin password.
     * @return byte array representing hashed value of the admin password.
     */
    byte[] getAdminPassword();
    
    /**
     * Retrieves the salt used to hash the password from the database.
     * @return byte array representing the salt.
     */
    byte[] getAdminSalt();
    
}
