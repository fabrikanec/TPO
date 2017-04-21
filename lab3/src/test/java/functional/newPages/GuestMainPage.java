package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by cezar on 4/15/17.
 */
public class GuestMainPage extends MainPage {
    private static String URL = baseUrl;

    @FindBy(xpath = "//form[@class='login-form']/label[@class='login-input']/input[@type='text']")
    @CacheLookup
    public WebElement loginFormLogin;

    @FindBy(xpath = "//form[@class='login-form']/label[@class='login-input']/input[@type='password']")
    @CacheLookup
    public WebElement loginFormPassword;

    @FindBy(xpath = "/html/body/div[5]/div/div[3]/div/div/div[2]/form/div[3]/input")
    @CacheLookup
    public WebElement loginFormSubmit;

    @FindBy(xpath = "//div[@class='bloko-column bloko-column_s-8 bloko-column_m-8 bloko-column_l-8'][2]/div[@class='index-dashboard__button']/a[@class='bloko-button bloko-button_promo bloko-button_large']")
    @CacheLookup
    public WebElement publishVacancy;

    @FindBy(xpath = "//div[@class='bloko-column bloko-column_s-8 bloko-column_m-8 bloko-column_l-8'][2]/a[@class='bloko-button bloko-button_promo bloko-button_large']")
    @CacheLookup
    public WebElement publishCV;

    @FindBy(xpath="/html/body/div[5]/div/div[3]/div/div/div[2]/p/span[4]/a")
    @CacheLookup
    public WebElement vkLogin;

    public GuestMainPage(WebDriver driver) {
        super(driver);
        //URL = JUnitTestBase.baseUrl;
    }

    public String getURL() {
        return URL;
    }
}