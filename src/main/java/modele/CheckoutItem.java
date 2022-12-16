/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.io.Serializable;


/**
 *
 * @author Samuel
 */
public class CheckoutItem {
    
    public CartProduct cartProduct;
    public Product product;

    public CheckoutItem(CartProduct cartProduct, Product product) {
        this.cartProduct = cartProduct;
        this.product = product;
    }

    public CheckoutItem() {
    }

    public CartProduct getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(CartProduct cartProduct) {
        this.cartProduct = cartProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
}
