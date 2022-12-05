/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Jon
 */
class ConstantesDao {

    protected static final String PERSISTENCE_NAME = "persistence";

    // SQL
    /// USER
    protected static final String GET_USER_FROM_ID = "SELECT id_user FROM USER WHERE id_user = ";

    protected static final String GET_USER_FROM_EMAIL = "SELECT * FROM USER WHERE email = ";

    protected static final String GET_ALL_USERS = "SELECT * FROM USER";

    protected static final String RESET_HIBERNATE_SEQUENCE = "UPDATE hibernate_sequence SET next_val = 1";

    /// PRODUCT
    protected static final String GET_PRODUCT_FROM_ID = "SELECT product_id FROM PRODUCT WHERE product_id = ";

    protected static final String GET_PRODUCT_ACTIVE_STATUS = "SELECT active FROM PRODUCT WHERE product_id = ";

    protected static final String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCT";

    // HQL
    protected static final String GET_USER_ID_FROM_EMAIL_PASSWORD = "SELECT user_id FROM USER where email=:email AND password=:password";

    //Database
    protected static final String DATABASE_USER = "INSERT INTO user(firstName, lastName, email, password, isSuspended) Values(?, ?, ?, ?, ?)";
    
    protected static final String DATABASE_Product = "INSERT INTO product(description, imageName, quantity, price, active, recurrentPossible) Values(?, ?, ?, ?, ?, ?)";
}
