package functional.newPages;

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class GuestMainPage extends MainPage {
    public static String URL = "http://spb.hh.ru/";

    @FindBy(xpath = "//form[@class='login-form']/label[@class='login-input']/input[@type='text']")
    @CacheLookup
    public WebElement loginFormLogin;

    @FindBy(xpath = "//form[@class='login-form']/label[@class='login-input']/input[@type='password']")
    @CacheLookup
    public WebElement loginFormPassword;

    @FindBy(xpath = "//form[@class='login-form']/label[@class='login-input']/input[@type='submit']")
    @CacheLookup
    public WebElement loginFormSubmit;

    @FindBy(xpath = "//div[@class='bloko-column bloko-column_s-8 bloko-column_m-8 bloko-column_l-8'][2]/div[@class='index-dashboard__button']/a[@class='bloko-button bloko-button_promo bloko-button_large']")
    @CacheLookup
    public WebElement publishVacancy;

    @FindBy(xpath = "//div[@class='bloko-column bloko-column_s-8 bloko-column_m-8 bloko-column_l-8'][2]/a[@class='bloko-button bloko-button_promo bloko-button_large']")
    @CacheLookup
    public WebElement publishCV;

    @FindBy(xpath = "//input[@name='text']")
    @CacheLookup
    public WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    public WebElement searchButton;


    public GuestMainPage(WebDriver driver) {
        super(driver);
        //URL = JUnitTestBase.baseUrl;
    }
}