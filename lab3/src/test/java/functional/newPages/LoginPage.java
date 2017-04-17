package functional.newPages;

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class LoginPage extends GuestMainPage {
    private static String URL;

    @FindBy(xpath = "//div[@class='light-page-message light-page-message_error']")
    @CacheLookup
    public WebElement wrongCredentialsError;

    public LoginPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "account/login";
    }


    public String getURL() {
        return URL;
    }
}
