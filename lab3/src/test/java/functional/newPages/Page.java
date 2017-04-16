package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public abstract class Page {

    @FindBy(xpath = "//div[@class='navi-cell navi-cell_search']/form[not(contains(@class, 'g-hidden'))]/div/div/input")
    @CacheLookup
    public WebElement searchForm;

    @FindBy(xpath = "//div[@class='bloko-control-group__minor HH-Navi-SearchSelector-SelectWrapper']/select")
    @CacheLookup
    public WebElement searchTypeSelect;

    @FindBy(xpath = "//div[@class='navi-cell navi-cell_search']/form[not(contains(@class, 'g-hidden'))]/div/div[@class='navi-search-button']/button")
    @CacheLookup
    public WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'navi-item__dropdown HH-Navi-MenuItems-Dropdown HH-Navi-MenuItems-StaticDropdown')]/div[@class='navi-dropdown']/ul[@class='navi-dropdown__list navi-dropdown__list_small']/li[@class='navi-item navi-item_level-2'][2]/a[@class='navi-dropdown-link navi-dropdown-link_long']")
    @CacheLookup
    public WebElement enLanguageButton;

    @FindBy(xpath = "//div[contains(@class, 'navi-item__dropdown HH-Navi-MenuItems-Dropdown HH-Navi-MenuItems-StaticDropdown')]/div[@class='navi-dropdown']/ul[@class='navi-dropdown__list navi-dropdown__list_small']/li[@class='navi-item navi-item_level-2'][1]/span[@class='navi-dropdown-link navi-dropdown-link_long navi-dropdown-link_selected']")
    @CacheLookup
    public WebElement ruLanguageButton;


    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

}