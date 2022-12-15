/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modele.CartProduct;

/**
 *
 * @author Jon
 */
public interface ICartProductDao {
    
    /**
     * Saves a new CartProduct to the database
     * This will add the CartProduct to the associated cart.
     *
     * @param CartProduct to save to the database
     * @return true on successful save, else false
     */
    boolean saveCartProduct(CartProduct cartProduct);
    
    /**
     * Deletes a CartProduct from the database. 
     * This will remove the CartProduct from the associated cart.
     *
     * @param CartProduct to delete from the database
     * @return true if sucess, else false
     */
    boolean deleteCartProduct(CartProduct cartProduct);
    
    /**
     * Updates the quantity of the given CartProduct with the given newQuantity.
     * 
     * @param cartProduct for which the quantity is to be updated
     * @param newQuantity to give the CartProduct
     * @return true on successful update, else false.
     */
    boolean updateCartProductQuantity(CartProduct cartProduct, Integer newQuantity);
    
    /**
     * Returns all the CartProducts which belong to the given CartId.
     * 
     * @param cartId for which to retrieve the CartProducts
     * @return a list containing all the CartProducts attached to the given
     * Cart. List will be empty if no CartProducts in Cart.
     */
    List<CartProduct> getAllCartProductsWithCartId(Integer cartId);
    
    /**
     * Deletes all the CartProducts from the database. Only for testing purposes.
     * Checks for use outside of tests is not enforced but strongly suggested.
     * 
     * @return true if deletion successful, else false.
     */
    boolean deleteAllCartProducts();
    
     /**
     * Updates the quantity of the given CartProduct with the given newQuantity.
     * 
     * @param cartProductId for which the quantity is to be updated
     * @param newQuantity to give the CartProduct
     * @return true on successful update, else false.
     */
    public boolean updateCartProductQuantityById(Integer cartProductId, Integer newQuantity);
    /**
     * Deletes a CartProduct from the database. 
     * This will remove the CartProduct from the associated cart.
     *
     * @param cartProductId to delete from the database
     * @return true if sucess, else false
     */
    boolean deleteCartProductById(Integer cartProductId);
}
