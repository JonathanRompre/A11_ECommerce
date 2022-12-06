/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import modele.Administrator;
import modele.Product;
import modele.User;

/**
 *
 * @author Samuel
 */
public interface IConfigDatabaseDao {
    
    boolean addDatabaseProduct(Product product);
    
    boolean addDatabaseUser(User user);
}
