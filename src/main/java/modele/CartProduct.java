/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Samuel
 */
@Entity
public class CartProduct {
    @Id
    @Column(name = "cartProduct_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne  
    @JoinColumn(name = "cart_id")
    private Cart cart;
    
    @OneToOne
    @JoinColumn(name ="product_id")
    private Product product;
    
    private int quantity;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAjout;

    public CartProduct() {
    }

    public CartProduct(Cart cart, Product product, int quantity, Date dateAjout) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.dateAjout = dateAjout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    @Override
    public String toString() {
        return "CartProduct{" + "id=" + id + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity + ", dateAjout=" + dateAjout + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CartProduct other = (CartProduct) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cart, other.cart)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return Objects.equals(this.dateAjout, other.dateAjout);
    }
    
    
}
