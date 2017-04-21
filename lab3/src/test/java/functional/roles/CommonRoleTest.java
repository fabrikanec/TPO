package functional.roles;

import com.thoughtworks.selenium.Selenium;
import functional.newPages.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static functional.newPages.Page.baseUrl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by cezar on 4/15/17.
 */
public class CommonRoleTest extends JUnitTestBase {
    private MainPage mainPage;
    private UserMainPage userMainPage;
    private GuestMainPage guestMainPage;
    private CompanyCatalogPage companyCatalogPage;
    private HelpPage helpPage;

    @AfterClass
    public  static void killDriver() {
        driver.quit();
    }

    @Before
    public void initPageObjects() {
        guestMainPage = PageFactory.initElements(driver, GuestMainPage.class);
        userMainPage = PageFactory.initElements(driver, UserMainPage.class);
        guestMainPage = PageFactory.initElements(driver, GuestMainPage.class);
        companyCatalogPage = PageFactory.initElements(driver, CompanyCatalogPage.class);
        helpPage = PageFactory.initElements(driver, HelpPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    /* SEARCH TESTS */

    @Test
    public void testSearchVacancy() throws Exception {
        driver.get(guestMainPage.getURL());

        guestMainPage.searchForm.sendKeys("devops");
        new Select(guestMainPage.searchTypeSelect).selectByVisibleText("Вакансии");
        guestMainPage.searchButton.click();
        selenium.waitForPageToLoad("6000");
        assertTrue(driver.getCurrentUrl().contains("search/vacancy"));
    }

    @Test
    public void testSearchCV() throws Exception {
        driver.get(guestMainPage.getURL());
        guestMainPage.searchForm.sendKeys("devops");
        selenium.waitForPageToLoad("6000");
        guestMainPage.searchTypeSelect.click();
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=/html/body/div[1]/div[1]/div/div[2]/div/div[2]/form[1]/div/div[2]/select/option[2]");
        guestMainPage.searchButton.click();
        selenium.waitForPageToLoad("30000");
        assertTrue(driver.getCurrentUrl().contains("search/"));
    }

    @Test
    public void testSearchCompany() throws Exception {
        driver.get(guestMainPage.getURL());

        guestMainPage.searchForm.sendKeys("Itiviti");
        guestMainPage.searchTypeSelect.click();
        selenium.waitForPageToLoad("6000");
        new Select(guestMainPage.searchTypeSelect).selectByVisibleText("Компании");
        selenium.waitForPageToLoad("6000");
        guestMainPage.searchButton.click();
        assertEquals( "Itiviti (Айтивити)",
                driver.findElement(By.xpath("//td[@class='l-cell b-companylist']/div/a")).getText());
    }

    @Test
    public void testExtendedSearch() throws Exception {
        driver.get(guestMainPage.getURL());

        guestMainPage.extendedSearchLink.click();
        selenium.waitForPageToLoad("6000");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[1]/div/form/div[1]/div[2]/div[1]/div/div[1]/div/input")).sendKeys("devops");
        selenium.waitForPageToLoad("6000");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[1]/div/form/div[1]/div[2]/div[1]/div/div[2]/input")).click();

        assertTrue(driver.getCurrentUrl().contains("search/vacancy"));
    }

    /* LOCATE TESTS */

    @Test
    public void testChangeLocaleToEn() throws Exception {
        WebElement locale = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<WebElement>) d -> d.findElement(By.xpath("//div[@class='navi-cell navi-cell_lang navi-cell_right']/div[@class='navi-item navi-item_lang HH-Navi-MenuItems-Item navi-item_level-1']")));
        WebElement changeLocale = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<WebElement>) d -> d.findElement(By.xpath("((//ul[@class='navi-dropdown__list navi-dropdown__list_small'])[2]//li)[2]")));
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(1)).moveToElement(locale).click().pause(Duration.ofSeconds(1)).build().perform();
        changeLocale.click();
        assertEquals( "Search", driver.findElement(By.xpath("//div[@class='navi-search-button']/button")).getText());
    }

    @Test
    public void testChangeLocaleToEnToRu() throws Exception {
        driver.get(mainPage.getURL());
        WebElement locale = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<WebElement>) d -> d.findElement(By.xpath("//div[@class='navi-cell navi-cell_lang navi-cell_right']/div[@class='navi-item navi-item_lang HH-Navi-MenuItems-Item navi-item_level-1']")));
        WebElement changeLocale = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<WebElement>) d -> d.findElement(By.xpath("((//ul[@class='navi-dropdown__list navi-dropdown__list_small'])[2]//li)[2]")));
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(1)).moveToElement(locale).click().pause(Duration.ofSeconds(1)).build().perform();
        changeLocale.click();

        locale = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<WebElement>) d -> d.findElement(By.xpath("//div[@class='navi-cell navi-cell_lang navi-cell_right']/div[@class='navi-item navi-item_lang HH-Navi-MenuItems-Item navi-item_level-1']")));
        changeLocale = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<WebElement>) d -> d.findElement(By.xpath("((//ul[@class='navi-dropdown__list navi-dropdown__list_small'])[2]//li)[2]")));
        actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(1)).moveToElement(locale).click().pause(Duration.ofSeconds(1)).build().perform();
        changeLocale.click();
        assertEquals( "Найти", driver.findElement(By.xpath("//div[@class='navi-search-button']/button")).getText());
    }


    @Test
    public void testCatalogCom() throws Exception {
        driver.get(mainPage.getURL());
        /*companyCatalogPage.company.click();
        companyCatalogPage.companyCatalog.click();*/
        selenium.waitForPageToLoad("6000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[6]/div[1]");
        selenium.waitForPageToLoad("6000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[6]/div[2]/div/ul/li[1]/a/span");
        selenium.waitForPageToLoad("6000");
    }


}
