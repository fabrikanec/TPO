package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class RestorePasswordPage extends Page {
    public static String URL = "https://spb.hh.ru/account/remember_password?backurl=%2F";
    //from GuestPage

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }
}
