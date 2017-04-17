package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class RegistrationPage extends GuestMainPage {
    private static String emplURL;
    private static String seekerURL;
    //from GuestPage

    public RegistrationPage(WebDriver driver) {
        super(driver);
        emplURL = baseUrl + "auth/employer";
        seekerURL = baseUrl + "account/signup";
    }

    public static String getEmplURL() {
        return emplURL;
    }

    public static String getSeekerURL() {
        return seekerURL;
    }
}
