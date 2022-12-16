/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Jon
 */
@Entity
public class Product implements Serializable {
    @Id
    @Column(name = "product_id")
    private Integer id;
    private String type;
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

    public Product(Integer id, String type, String description, String imageName, Integer quantity, double price, String categorie, boolean active, boolean recurrentPossible) {
        this.id = id;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "Product{" + "id=" + id + ", name=" + type + ", description=" + description + ", imageName=" + imageName + ", quantity=" + quantity + ", price=" + price + ", categorie=" + categorie + ", active=" + active + ", recurrentPossible=" + recurrentPossible + '}';
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
        final Product other = (Product) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (this.recurrentPossible != other.recurrentPossible) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.imageName, other.imageName)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.quantity, other.quantity);
    }
}
