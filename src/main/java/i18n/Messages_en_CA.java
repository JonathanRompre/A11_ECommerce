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
public class Messages_en_CA extends ListResourceBundle {

    static final Object[][] contents = {
        {"register.registration","Registration"},
        {"register.firstName","First name"},
        {"register.lastName","Last name"},
        {"register.email","Email"},
        {"register.password","Password"},
        {"register.confirm","Confirm"},
        {"register.confirmPassword","Please confirm password"},
        {"register.homePage","Back to home page"},
        {"register.register","Register"},
        {"register.registrationSuccess","Registration successful. Redirecting to login page."},
        {"register.emailExists","An account with this email already exists."},
        {"register.passwordMismatch","Passwords must match."},
        {"login.title","Login"},
        {"login.email","Email"},
        {"login.noAccount","There is no account associated with this email."},
        {"login.password","Password"},
        {"login.invalidPassword","Invalid password."},
        {"login.btnLogin","login"},
        {"login.register","Register"},
        {"login.homePage","Home page"},
        {"login.admin","Administration"}
    };
    
    @Override
    public Object[][] getContents() {
        return contents;
    }
}
