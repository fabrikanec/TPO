package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class RegistrationPage extends GuestMainPage {
    private static String employerURL;
    private static String employeeURL;
    //from GuestPage

    public RegistrationPage(WebDriver driver) {
        super(driver);
        employerURL = baseUrl + "auth/employer";
        employeeURL = baseUrl + "account/signup";
    }

    @FindBy(xpath = "//input[contains(@name, 'firstName')]")
    @CacheLookup
    public WebElement firstName;

    @FindBy(xpath = "//input[contains(@name, 'lastName')]")
    @CacheLookup
    public WebElement lastName;

    @FindBy(xpath = "//input[contains(@name, 'login')]")
    @CacheLookup
    public WebElement login;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    @CacheLookup
    public WebElement password;

    @FindBy(xpath = "//input[contains(@class, 'HH-FormLocker-Submit')]")
    @CacheLookup
    public WebElement submitForm;

    @FindBy(xpath = "//span[@class='account-form-error']")
    @CacheLookup
    public WebElement errorString;


    public String getEmployerURL() {
        return employerURL;
    }

    public String getEmployeeURL() {
        return employeeURL;
    }
}
