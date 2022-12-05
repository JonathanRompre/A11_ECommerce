/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Samuel
 */
@Entity
public class Cart {
    @Id
    @Column (name = "panier_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    
    @OneToOne
    @JoinColumn(name ="user_id")
    private User user;
    
    private boolean current;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartProduct> cartProducts;

    public Cart() {
    }

    public Cart(User user, boolean current) {
        this.user = user;
        this.current = current;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", user=" + user + ", current=" + current + '}';
    }
    
    
}
