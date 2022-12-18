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
        {"register.registration","S'inscrire"},
        {"register.firstName","Prénom"},
        {"register.lastName","Nom"},
        {"register.email","Courriel"},
        {"register.password","Mot de passe"},
        {"register.confirm","Confirmer"},
        {"register.confirmPassword","Confirmer le mot de passe"},
        {"register.homePage","Retour à l'accueil"},
        {"register.register","S'inscrire"},
        {"register.registrationSuccess","Enregistrement complété. Redirection vers la page de connexion"},
        {"register.emailExists","Un compte avec ce courriel existe déjà."},
        {"register.passwordMismatch","Les mots de passe doivent être les mêmes."},
        {"login.title","Connexion"},
        {"login.email","Courriel"},
        {"login.noAccount","Aucun compte associé à ce courriel."},
        {"login.password","Mot de passe"},
        {"login.invalidPassword","Mot de passe invalide"},
        {"login.btnLogin","connexion"},
        {"login.register","S'enregistrer"},
        {"login.homePage","Retour à l'accueil"},
        {"login.admin","Administration"}
    };
    
    @Override
    public Object[][] getContents() {
        return contents;
    }
}
