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
public class Messages extends ListResourceBundle {

    static final Object[][] contents = {
        {"registration","Registration"},
        {"firstName","First name"},
        {"lastName","Last name"},
        {"email","Email"},
        {"password","Password"},
        {"confirm","Confirm"},
        {"confirmPassword","Please confirm password"},
        {"homePage","Back to home page"},
        {"register","Register"}
    };
    
    @Override
    public Object[][] getContents() {
        return contents;
    }
}
