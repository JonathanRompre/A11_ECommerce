/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modele.Product;

/**
 *
 * @author Jon
 */
public interface IProductDao {

    /**
     * Saves a new product to the database
     *
     * @param product to save to the database
     * @return true on successful save, else false
     */
    boolean saveProduct(Product product);

    /**
     * Gets the product with the given id.
     *
     * @param id of the product to query
     * @return the product if found, else null.
     */
    Product getProductById(Integer id);

    /**
     * Gets whether the product is active, so can be bought, or not.
     *
     * @param id of the product to check
     * @return true if product is available, else false.
     */
    boolean isProductActive(Integer id);

    /**
     * Updates the whole product with the given product. Product in the database
     * with the same id will be overwritten with the information from the given
     * product.
     *
     * @param product with the informations already updated to persist in the
     * database
     * @return true if update was successful, else false.
     */
    boolean updateProduct(Product product);

    /**
     * Updates a product matching the given id with a given new price.
     *
     * @param id of the product to update
     * @param newPrice of the product
     * @return true if update successful, else false.
     */
    boolean updateProductPriceFromId(Integer id, double newPrice);

    /**
     * Updates the description of the product matching the given id for the
     * given locale.
     *
     * @param id of the product to update
     * @param locale for which the description needs to be updated
     * @param newDesc description that is to replace the current description for
     * the product.
     * @return true if update successful, else false.
     */
    boolean updateProductDescriptionFromId(Integer id, String locale, String newDesc);

    /**
     * Updates the available quantity of a product matching the given id with
     * the given new quantity.
     *
     * @param id of the product to update.
     * @param newQuantity of the product.
     * @return true if update successful, else false.
     */
    boolean updateProductQuantityFromId(Integer id, Integer newQuantity);

    /**
     * Deletes every product from the database and resets the ID autoincrement
     * counter
     *
     * @return true on success, else false.
     */
    boolean deleteAllProducts();

    /**
     * Deletes a product from the database.
     *
     * @param product to delete from the database
     * @return true if sucess, else false
     */
    boolean deleteProduct(Product product);
    
    /**
     * Gets all the products saved in the database. 
     * @return a list of all the products
     */
    List<Product> getAllProducts();
    
    /**
     * creates the product list from the filter
     * @param query built from the buildQueryFromUrl method.
     * @return the list of products matching the requested filter.
     */
    List<Product> getProductListFromCustomFilter(String query);
}
