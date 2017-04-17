package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class RestorePasswordPage extends GuestMainPage {
    private static String URL;

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "account/remember_password?backurl=%2F";
    }

    @FindBy(xpath = "//input[@class='bloko-input']")
    @CacheLookup
    public WebElement emailInput;

    @FindBy(xpath = "//input[@class='bloko-button bloko-button_primary bloko-button_stretched']")
    @CacheLookup
    public WebElement restorePasswordButton;

    public String getURL() {
        return URL;
    }
}
