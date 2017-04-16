package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class RestorePasswordPage extends GuestMainPage {
    public static String URL = "http://spb.hh.ru/account/remember_password?backurl=%2F";

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }
}
