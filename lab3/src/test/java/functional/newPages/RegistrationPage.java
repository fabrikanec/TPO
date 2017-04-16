package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class RegistrationPage extends GuestMainPage {
    private static String EmplURL = "http://spb.hh.ru/auth/employer";
    private static String SeekerURL = "http://spb.hh.ru/account/signup";
    //from GuestPage

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
}
