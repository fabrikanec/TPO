package functional.newPages;

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class LoginPage extends GuestMainPage {
    private static String URL;



    public LoginPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "account/login?postponed&backurl=/applicant/resumes/new";
    }

    public String getURL() {
        return URL;
    }
}
