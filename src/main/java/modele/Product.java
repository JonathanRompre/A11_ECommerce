/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Jon
 */
@Entity
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer id;
    private String description; // changer pour FK internationalisation
    private String imageName;
    private Integer quantity;
    private double price;
    private boolean active;
    @Column(name = "recurrent_possible")
    private boolean recurrentPossible;

    public Product() {
    }

    public Product(String description, String imageName, Integer quantite, boolean actif, boolean recurrent_possible) {
        this.description = description;
        this.imageName = imageName;
        this.quantity = quantite;
        this.active = actif;
        this.recurrentPossible = recurrent_possible;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRecurrentPossible() {
        return recurrentPossible;
    }

    public void setRecurrentPossible(boolean recurrentPossible) {
        this.recurrentPossible = recurrentPossible;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", description=" + description + ", imageName=" + imageName + ", quantite=" + quantity + ", actif=" + active + ", recurrent_possible=" + recurrentPossible + '}';
    }
}
