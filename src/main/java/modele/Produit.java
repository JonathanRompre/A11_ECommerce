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
public class Produit {
    @Id
    @Column(name = "id_produit")
    private Integer id;
    private String description; // changer pour FK internationalisation
    private String imageName;
    private Integer quantite;
    private boolean actif;
    private boolean recurrent_possible;

    public Produit() {
    }

    public Produit(String description, String imageName, Integer quantite, boolean actif, boolean recurrent_possible) {
        this.description = description;
        this.imageName = imageName;
        this.quantite = quantite;
        this.actif = actif;
        this.recurrent_possible = recurrent_possible;
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

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public boolean isRecurrent_possible() {
        return recurrent_possible;
    }

    public void setRecurrent_possible(boolean recurrent_possible) {
        this.recurrent_possible = recurrent_possible;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", description=" + description + ", imageName=" + imageName + ", quantite=" + quantite + ", actif=" + actif + ", recurrent_possible=" + recurrent_possible + '}';
    }
}
