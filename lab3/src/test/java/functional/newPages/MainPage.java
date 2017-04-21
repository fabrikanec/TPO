package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by cezar on 4/16/17.
 */
public class MainPage implements Page {
    protected WebDriver driver;
    private static String URL = baseUrl;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='navi-cell navi-cell_search']/form[not(contains(@class, 'g-hidden'))]/div/div/input")
    @CacheLookup
    public WebElement searchForm;

    @FindBy(xpath = "//div[@class='bloko-control-group__minor HH-Navi-SearchSelector-SelectWrapper']/select")
    @CacheLookup
    public WebElement searchTypeSelect;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[2]/div/div[2]/form[1]/div/div[3]/button")
    @CacheLookup
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='navi-cell navi-cell_lang navi-cell_right']/div[@class='navi-item navi-item_lang HH-Navi-MenuItems-Item navi-item_level-1']")
    @CacheLookup
    public WebElement locale;

    @FindBy(xpath = "((//ul[@class='navi-dropdown__list navi-dropdown__list_small'])[2]//li)[2]")
    @CacheLookup
    public WebElement changeLocale;

    @FindBy(xpath = "/x:html/x:body/x:div[1]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[6]/x:div[1]")
    @CacheLookup
    public WebElement company;

    @FindBy(xpath = "/x:html/x:body/x:div[1]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[6]/x:div[2]/x:div/x:ul/x:li[1]/x:a")
    @CacheLookup
    public WebElement companyCatalog;

    @FindBy(xpath = "/x:html/x:body/x:div[5]/x:div/x:div[3]/x:div/x:div/x:div[1]/x:input[2]")
    @CacheLookup
    public WebElement registration;

    @FindBy(xpath = "//div[@class='login-with__forgot']/a")
    @CacheLookup
    public WebElement forgotPasswordAnchor;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[2]/div/div[3]/span/a")
    @CacheLookup
    public WebElement extendedSearchLink;

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public String getURL() {
        return URL;
    }

}
