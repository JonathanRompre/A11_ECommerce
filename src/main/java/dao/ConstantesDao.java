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

    /// USER
    // SQL
    protected static final String GET_USER_FROM_ID = "SELECT * FROM USER WHERE user_id = ";

    protected static final String GET_USER_FROM_EMAIL = "SELECT * FROM USER WHERE email = ";

    protected static final String GET_ALL_USERS = "SELECT * FROM USER";

    protected static final String RESET_HIBERNATE_SEQUENCE = "UPDATE hibernate_sequence SET next_val = 1";
    // HQL
    protected static final String GET_USER_ID_FROM_EMAIL_PASSWORD = "SELECT u.id FROM User u where u.email = :email AND u.password = :password";

    /// PRODUCT
    // SQL
    protected static final String GET_PRODUCT_FROM_ID = "SELECT * FROM PRODUCT WHERE product_id = ";

    protected static final String GET_PRODUCT_ACTIVE_STATUS = "SELECT active FROM PRODUCT WHERE product_id = ";

    protected static final String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCT";

    /// Cart
    // SQL
    protected static final String GET_CART_FROM_ID = "SELECT * FROM CART WHERE panier_id = ";
    
    protected static final String GET_CURRENT_CART_ID_FOR_USER_ID = "SELECT panier_id FROM CART WHERE current = 1 AND user_id = ";
    
    protected static final String GET_CURRENT_CART_EXISTS_FOR_USER_ID = "SELECT COUNT(*) FROM CART WHERE current = 1 AND user_id = ";
    
    protected static final String GET_ALL_CARTS_FOR_USER_ID = "SELECT * FROM CART WHERE user_id = ";
    
    protected static final String GET_ALL_CARTS = "SELECT * FROM CART";
    
    protected static final String SET_CART_CURRENT_FALSE_FOR_USER_ID = "UPDATE CART SET current = 0 WHERE user_id = ";
    
    //HQL
    protected static final String GET_CURRENT_CART_EXISTS_FOR_USER_ID_HQL = "SELECT c.current FROM Cart c WHERE c.user.id = :id";
    
    ///Config database
    protected static final String PRODUCT_EXIST = "SELECT description FROM product where description = :description";

    /// CartProduct
    protected static final String GET_ALL_CART_PRODUCTS_FOR_CART_ID = "SELECT * FROM CARTPRODUCT WHERE cart_id = ";
    
    protected static final String GET_ALL_CART_PRODUCTS = "SELECT * FROM CARTPRODUCT";
}
