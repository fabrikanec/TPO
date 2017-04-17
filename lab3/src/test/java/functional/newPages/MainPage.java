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

    @FindBy(xpath = "//div[@class='navi-cell navi-cell_search']/form[not(contains(@class, 'g-hidden'))]/div/div[@class='navi-search-button']/button")
    @CacheLookup
    public WebElement searchButton;

    @FindBy(xpath = "(//a[contains(text(),'Русский')])[2]")
    @CacheLookup
    public WebElement locateRu;

    @FindBy(xpath = "(//a[contains(text(),'Английский')])[2]")
    @CacheLookup
    public WebElement locateEn;

    @FindBy(xpath = "/x:html/x:body/x:div[1]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[6]/x:div[1]")
    @CacheLookup
    public WebElement company;

    @FindBy(xpath = "/x:html/x:body/x:div[1]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[6]/x:div[2]/x:div/x:ul/x:li[1]/x:a")
    @CacheLookup
    public WebElement companyCatalog;

    @FindBy(xpath = "/x:html/x:body/x:div[5]/x:div/x:div[3]/x:div/x:div/x:div[1]/x:input[2]")
    @CacheLookup
    public WebElement registration;


    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public String getURL() {
        return URL;
    }
}
