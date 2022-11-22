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
    protected static final String GET_USER_FROM_ID = "SELECT id_user FROM USER WHERE id_user = ";

    protected static final String GET_USER_FROM_EMAIL = "SELECT * FROM USER WHERE email = ";
        
    protected static final String GET_ALL_USERS = "SELECT * FROM USER";
    
    protected static final String RESET_HIBERNATE_SEQUENCE = "UPDATE hibernate_sequence SET next_val = 1";
    
    // HQL
    
    
    protected static final String GET_USER_ID_FROM_EMAIL_PASSWORD = "SELECT user_id FROM USER where email=:email AND password=:password";
}
