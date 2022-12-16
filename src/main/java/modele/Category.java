/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Jon
 */
public class Category implements Serializable {
    private String name;
    private Set<ItemCategorie> items;

    public Category(String name, Set<ItemCategorie> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ItemCategorie> getItems() {
        return items;
    }

    public void setItems(Set<ItemCategorie> items) {
        this.items = items;
    }
}