package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class CreateVacantPage extends GuestMainPage {
    private static String URL;
    //from GuestPage

    public CreateVacantPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "auth/employer";
    }

    public String getURL() {
        return URL;
    }
}
