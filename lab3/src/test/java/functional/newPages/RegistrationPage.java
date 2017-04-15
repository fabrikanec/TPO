package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class RegistrationPage extends Page {
    private static String EmplURL = "https://spb.hh.ru/auth/employer";
    private static String SeekerURL = "https://spb.hh.ru/account/signup";
    //from GuestPage

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
}
