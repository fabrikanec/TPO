package functional.roles;

import com.thoughtworks.selenium.Selenium;
import functional.newPages.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static functional.newPages.Page.baseUrl;

/**
 * Created by cezar on 4/15/17.
 */
public class CommonRoleTest extends JUnitTestBase {
    private MainPage mainPage;
    private UserMainPage userMainPage;
    private GuestMainPage guestMainPage;
    private CompanyCatalogPage companyCatalogPage;
    private HelpPage helpPage;
    private Selenium selenium;

    @Before
    public void initPageObjects() {
        guestMainPage = PageFactory.initElements(driver, GuestMainPage.class);
        userMainPage = PageFactory.initElements(driver, UserMainPage.class);
        guestMainPage = PageFactory.initElements(driver, GuestMainPage.class);
        companyCatalogPage = PageFactory.initElements(driver, CompanyCatalogPage.class);
        helpPage = PageFactory.initElements(driver, HelpPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        if (selenium == null) {
            selenium = new WebDriverBackedSelenium(driver, baseUrl);
        }
    }

    @Test
    public void testSearch() throws Exception {
        selenium.open("/");
        selenium.type("//input[@name='text']", "devops");
        selenium.click("//button[@type='submit']");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(text(),'DevOps Engineer')]");
    }

    @Test
    public void testChangeLocate() throws Exception {
        /*driver.get(mainPage.getURL());
        Actions builder = new Actions(driver);
        builder.moveToElement(mainPage.locateRu);
        builder.moveToElement(mainPage.locateEn);
        builder.click(mainPage.locateEn).perform();*/

        /*builder.moveToElement(mainPage.locateEn);
        builder.click(mainPage.locateRu).perform();*/

        /*selenium.open("/");
        selenium.click("xpath=(//a[contains(text(),'Английский')])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//a[contains(text(),'Russian')])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//a[contains(text(),'Английский')])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("//input[@value='Registration']");
        selenium.click("xpath=(//a[contains(text(),'Russian')])[2]");
        selenium.waitForPageToLoad("30000");*/
    }

    @Test
    public void testCatalogCom() throws Exception {
        driver.get(mainPage.getURL());
        companyCatalogPage.company.click();
        companyCatalogPage.companyCatalog.click();
        /*selenium.open("/");
        selenium.click("xpath=(//a[contains(@href, '/employers_company')])");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//a[contains(text(),'Информационные технологии, системная интеграция, интернет')])");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//a[contains(text(),'08')])");
        selenium.waitForPageToLoad("30000");*/
    }


}
