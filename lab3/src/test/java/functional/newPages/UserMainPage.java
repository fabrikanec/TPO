package functional.newPages;

/**
 * Created by cezar on 4/15/17.
 */

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class UserMainPage extends MainPage implements Page {
    private static String URL = baseUrl;

    @FindBy(xpath = "//div[@class='my-events']/div[@class='my-events__list my-events__list_wrapper']/a[@class='my-events__item my-events__item_link my-events__item_views']")
    @CacheLookup
    public WebElement userResumeListLink;

    @FindBy(xpath = "//div[@class='my-events']/div[@class='my-events__list my-events__list_wrapper']/a[@class='my-events__item my-events__item_link my-events__item_letters']")
    @CacheLookup
    public WebElement userInviteListLink;

    @FindBy(xpath = "//div[@class='navi-dropdown']/ul[@class='navi-dropdown__list']/li[@class='navi-item navi-item_level-2']/form/button[@class='navi-dropdown-link']")
    @CacheLookup
    public WebElement logoutButton;

    @FindBy(xpath = "//div[starts-with(@class,'navi-item__dropdown navi-item__dropdown_right HH-Navi-MenuItems-Dropdown HH-Navi-MenuItems-StaticDropdown')]/div[@class='navi-dropdown']/ul[@class='navi-dropdown__list']/li[@class='navi-item navi-item_level-2 HH-Navi-MenuItems-Leaf'][1]/a[@class='navi-dropdown-link']")
    @CacheLookup
    public WebElement userSettingsLink;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/ul[1]/li[6]/div[2]/div/ul/li[1]/a/span")
    @CacheLookup
    public WebElement resume;

    @FindBy(xpath = "//div[2]/div[2]/div/div/a/span")
    @CacheLookup
    public WebElement resumes;

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return URL;
    }
}