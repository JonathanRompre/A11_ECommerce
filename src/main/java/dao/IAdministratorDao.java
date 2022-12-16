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
     * @param administrator to save to the database
     * @return true if success, else false
     */
    boolean saveAdminPassword(Administrator administrator);
    
}
