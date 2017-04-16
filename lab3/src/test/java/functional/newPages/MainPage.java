package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/16/17.
 */
public class MainPage implements Page {

    protected WebDriver driver;

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


    @Override
    public String getTitle() {
        return driver.getTitle();
    }
}
