/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

public class configLanguage {

    private static configLanguage instance;
    private ResourceBundle bundle;
    private Locale currentLocale;

    private configLanguage() {
        setLanguage("Inggris");
    }

    public static configLanguage getInstance() {
        if (instance == null) {
            instance = new configLanguage();
        }
        return instance;
    }

    public void setLanguage(String language) {
        switch (language.toLowerCase()) {
            case "indonesia":
                currentLocale = new Locale("id", "ID");
                break;
            case "inggris":
                currentLocale = new Locale("en", "US");
                break;
            case "arab":
                currentLocale = new Locale("ar", "SA"); 
                break;
            default:
                currentLocale = Locale.getDefault();
        }
        bundle = ResourceBundle.getBundle("internationalization.message", currentLocale);
    }

    public String getLanguageName() {
        if (currentLocale.equals(new Locale("id", "ID"))) {
            return "Indonesia";
        } else if (currentLocale.equals(new Locale("en", "US"))) {
            return "Inggris";
        } else {
            return "Inggris"; // default fallback
        }
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public Locale getLocale() {
        return currentLocale;
    }
}
