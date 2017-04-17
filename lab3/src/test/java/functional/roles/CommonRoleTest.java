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

    /* SEARCH TESTS */

    @Test
    public void testSearchVacancy() throws Exception {
        driver.get(guestMainPage.getURL());

        guestMainPage.searchForm.sendKeys("devops");
        new Select(guestMainPage.searchTypeSelect).selectByVisibleText("Вакансии");
        guestMainPage.searchButton.click();
        assertTrue(driver.getCurrentUrl().contains("search/vacancy"));
    }

    @Test
    public void testSearchCV() throws Exception {
        driver.get(guestMainPage.getURL());

        guestMainPage.searchForm.sendKeys("devops");
        new Select(guestMainPage.searchTypeSelect).selectByVisibleText("Резюме");
        guestMainPage.searchButton.click();
        assertTrue(driver.getCurrentUrl().contains("search/resume"));
    }

    @Test
    public void testSearchCompany() throws Exception {
        driver.get(guestMainPage.getURL());

        guestMainPage.searchForm.sendKeys("Itiviti");
        new Select(guestMainPage.searchTypeSelect).selectByVisibleText("Компании");
        guestMainPage.searchButton.click();

        assertEquals( "Itiviti (Айтивити)",
                driver.findElement(By.xpath("//a/[(contains(@text, 'Itiviti')]")));
    }

    @Test
    public void testExtendedSearch() throws Exception {
        driver.get(guestMainPage.getURL());

        guestMainPage.extendedSearchLink.click();
        driver.findElement(By.xpath("//div[@class='line__wrapper']/input")).sendKeys("devops");
        driver.findElement(By.xpath("//div[@class='line__element']/input")).click();

        assertTrue(driver.getCurrentUrl().contains("search/vacancy"));
    }

    /* LOCATE TESTS */

    @Test
    public void testChangeLocateToEn() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.locateEn.click();
        assertEquals( "Search", mainPage.searchButton.getText());
    }

    @Test
    public void testChangeLocateToEnToRu() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.locateEn.click();
        mainPage.locateRu.click();
        assertEquals( "Поиск", mainPage.searchButton.getText());
    }

    /* */

    @Test
    public void testCatalogCom() throws Exception {
        driver.get(mainPage.getURL());
        companyCatalogPage.company.click();
        companyCatalogPage.companyCatalog.click();

    }


}
