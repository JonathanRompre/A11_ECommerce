/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i18n;

import java.util.ListResourceBundle;

/**
 *
 * @author Jon
 */
public class Messages_fr_CA extends ListResourceBundle {

    static final Object[][] contents = {
        {"registration","S'inscrire"},
        {"firstName","Prénom"},
        {"lastName","Nom"},
        {"email","Courriel"},
        {"password","Mot de passe"},
        {"confirm","Confirmer"},
        {"confirmPassword","Confirmer le mot de passe"},
        {"homePage","Retour à l'accueil"},
        {"register","S'inscrire"}
    };
    
    @Override
    public Object[][] getContents() {
        return contents;
    }
}
