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
 * @author Samuel
 */
@Entity
public class Administrator {

    @Id
    @Column(name = "admin_id")
    private Integer id;
    private byte[] password;
    private byte[] salt;

    public Administrator() {
    }

    public Administrator(Integer id, byte[] password, byte[] salt) {
        this.id = id;
        this.password = password;
        this.salt = salt;
    }

    public Administrator(Integer id, String password) {
        this.id = id;
        setPassword(password);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        salt = Passwords.getNextSalt();
        this.password = Passwords.hash(password.toCharArray(), salt);
    }

    public byte[] getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return "Administrator{" + "id=" + id + ", password=" + password + '}';
    }

}
