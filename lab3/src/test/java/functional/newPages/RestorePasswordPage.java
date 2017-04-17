package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class RestorePasswordPage extends GuestMainPage {
    private static String URL;

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "account/remember_password?backurl=%2F";
    }

    public String getURL() {
        return URL;
    }
}
