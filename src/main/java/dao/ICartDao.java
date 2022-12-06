/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modele.Cart;

/**
 *
 * @author Jon
 */
public interface ICartDao {
    /**
     * Saves a new cart to the database.
     * @param cart to save
     * @return true if save successful, else false
     */
    boolean saveCart(Cart cart);
    
    /**
     * Gets a cart matching the given cart id.
     * @param id of the cart to retrieve
     * @return the cart matching the id if present, else null.
     */
    Cart getCartById(Integer id);
    
    /**
     * For a given user, gets the currently active cart.
     * @param id of the user for which the active cart is desired.
     * @return the id of the cart if there is an active cart, else null.
     */
    Integer getCurrentCartIdByUserId(Integer id);
    
    /**
     * Retrieves a boolean indicating whether a user matching
     * the given id has a cart that is currently active.
     * @param id of the user for which to check if there is a current cart.
     * @return true if user has an active cart, else false.
     */
    boolean hasActiveCartForUserId(Integer id);
    
    /**
     * Gets all the carts for the user matching the given id.
     * @param id of the user for which to get all carts.
     * @return a list comprising all the carts for the given user. Empty
     * list if there are none for the user.
     */
    List<Cart> getAllCartsForUserId(Integer id);
    
    /**
     * Deletes a given cart from the database.
     * @param cart object of the cart to delete from the table.
     * @return true if delete successful, else false.
     */
    boolean deleteCart(Cart cart);
    
    /**
     * Deletes a cart matching the given cart id
     * @param id of the cart to delete from the table.
     * @return true if delete successful, else false.
     */
    boolean deleteCartByCartId(Integer id);
    
    /**
     * Deletes all the carts in the table.
     * @return true if delete successful, else false.
     */
    boolean deleteAllCarts();
    
    /**
     * For a given user id, sets the Current column of the user's current cart
     * to false. Validation that a cart with Current to true exists must be done
     * before calling this method.
     * @param id of the user for which to set the current cart to false.
     * @return true if change successful, else false.
     */
    boolean setCartCurrentFalseForUserId(Integer id);
}
