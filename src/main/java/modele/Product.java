/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    private String description;
    private String imageName;
    private Integer quantity;
    private double price;
    private String categorie;
    private boolean active;
    @Column(name = "recurrent_possible")
    private boolean recurrentPossible;

    public Product() {
    }

    public Product(Integer id, String description, String imageName, Integer quantity, double price, String categorie, boolean active, boolean recurrentPossible) {
        this.id = id;
        this.description = description;
        this.imageName = imageName;
        this.quantity = quantity;
        this.price = price;
        this.categorie = categorie;
        this.active = active;
        this.recurrentPossible = recurrentPossible;
    }
    

    public Product(String description, String imageName, Integer quantity, double price, String categorie, boolean active, boolean recurrentPossible) {
        this.id = id;
        this.description = description;
        this.imageName = imageName;
        this.quantity = quantity;
        this.price = price;
        this.categorie = categorie;
        this.active = active;
        this.recurrentPossible = recurrentPossible;
    }
            

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
        return "Product{" + "id=" + id + ", description=" + description + ", imageName=" + imageName + ", quantity=" + quantity + ", price=" + price + ", categorie=" + categorie + ", active=" + active + ", recurrentPossible=" + recurrentPossible + '}';
    }
    
    
}
