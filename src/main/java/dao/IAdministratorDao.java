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
     * Saves a new user to the database. New is defined by email. 
     * No two accounts can have the same email. 
     * @param administrator to save to the database
     * @return true if success, else false
     */
    boolean saveUserPassword(Administrator administrator);
}
