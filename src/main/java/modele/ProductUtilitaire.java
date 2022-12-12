/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import dao.ProductDaoImpl;
import java.util.List;

/**
 *
 * @author Jon
 */
public class ProductUtilitaire {
    public static List<Product> getFilteredProductList(String urlQuery){
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        
        String query = Utilitaire.getQueryFromUrl(urlQuery);
        
        List<Product> products = productDaoImpl.getProductListFromCustomFilter(query);
        
        return products;
    }
}
