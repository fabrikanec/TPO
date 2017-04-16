package functional.newPages;

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class LoginPage extends GuestMainPage {
    public static String URL = "http://spb.hh.ru/account/login?postponed&backurl=/applicant/resumes/new";


    public LoginPage(WebDriver driver) {
        super(driver);
        URL = JUnitTestBase.baseUrl;
    }
}
