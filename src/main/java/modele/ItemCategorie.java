/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.Objects;

/**
 *
 * @author Jon
 */
public class ItemCategorie implements Comparable<ItemCategorie> {

    private String name;
    private String url;
    private boolean activeFilter;

//    public ItemCategorie(String name, String url) {
//        this.name = name;
//        this.url = url;
//    }

    public ItemCategorie(String name, String url, boolean activeFilter) {
        this.name = name;
        this.url = url;
        this.activeFilter = activeFilter;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActiveFilter() {
        return activeFilter;
    }

    public void setActiveFilter(boolean activeFilter) {
        this.activeFilter = activeFilter;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.url);
        hash = 71 * hash + (this.activeFilter ? 1 : 0);
        return hash;
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
        final ItemCategorie other = (ItemCategorie) obj;
        if (this.activeFilter != other.activeFilter) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.url, other.url);
    }

    @Override
    public int compareTo(ItemCategorie o) {
        int res;
        if(this.equals(o)){
            res = 0;
        }
        if(Utilitaire.getPriceRangeOrder(this.getName()) > Utilitaire.getPriceRangeOrder(o.getName())){
            res = 1;
        }else if(Utilitaire.getPriceRangeOrder(this.getName()) < Utilitaire.getPriceRangeOrder(o.getName())){
            res = -1;
        }else{
            res = 0;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ItemCategorie{");
        sb.append("name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", activeFilter=").append(activeFilter);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
