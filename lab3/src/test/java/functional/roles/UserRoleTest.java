package functional.roles;

import com.thoughtworks.selenium.Selenium;
import functional.newPages.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.support.PageFactory;

import static functional.newPages.Page.baseUrl;
import static org.junit.Assert.assertEquals;

/**
 * Created by cezar on 4/15/17.
 */
public class UserRoleTest extends JUnitTestBase {
    private CreateCVPage createCVPage;
    private UserMainPage userMainPage;
    private CVsChekingPage cVsChekingPage;
    private OrderCVPage orderCVPage;
    private SuiteableVacantPage suiteableVacantPage;
    private ProfTestPage profTestPage;
    private GuestMainPage mainPage;
    private LoginPage loginPage;
    private RestorePasswordPage restorePasswordPage;

    @Before
    public void initPageObjects() throws Exception {
        mainPage = PageFactory.initElements(driver, GuestMainPage.class);
        createCVPage = PageFactory.initElements(driver, CreateCVPage.class);
        userMainPage = PageFactory.initElements(driver, UserMainPage.class);
        cVsChekingPage = PageFactory.initElements(driver, CVsChekingPage.class);
        orderCVPage = PageFactory.initElements(driver, OrderCVPage.class);
        suiteableVacantPage = PageFactory.initElements(driver, SuiteableVacantPage.class);
        profTestPage = PageFactory.initElements(driver, ProfTestPage.class);
        restorePasswordPage = PageFactory.initElements(driver, RestorePasswordPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void testLoginWithoutPassword() {
        driver.get(MainPage.baseUrl);
        mainPage.loginFormLogin.sendKeys("lol");
        mainPage.loginFormSubmit.click();
        selenium.waitForPageToLoad("6000");

        assertEquals( "https://spb.hh.ru/account/login?state=mismatch&backurl=%2F&login=lol",
                driver.getCurrentUrl());
    }

    @Test
    public void testLoginWithoutLogin() {
        driver.get(MainPage.baseUrl);
        mainPage.loginFormPassword.sendKeys("lel");
        mainPage.loginFormSubmit.click();

        selenium.waitForPageToLoad("6000");

        assertEquals( "https://spb.hh.ru/",
                driver.getCurrentUrl());
    }

    @Test
    public void testLoginWrongCredentials() throws Exception {
        driver.get(MainPage.baseUrl);
        mainPage.loginFormLogin.sendKeys("lol");
        mainPage.loginFormPassword.sendKeys("lol");
        mainPage.loginFormSubmit.click();
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/account/login?state=mismatch&backurl=%2F&login=lol", driver.getCurrentUrl());
    }


    @Test
    public void testLoginForExistingUser() throws Exception {
        driver.get(MainPage.baseUrl);
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormSubmit.click();

        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/", driver.getCurrentUrl());
    }


    @Ignore
    @Test
    public void testRestorePassForeExistingUser() throws Exception {
        driver.get(MainPage.baseUrl);
        mainPage.forgotPasswordAnchor.click();

        restorePasswordPage.emailInput.sendKeys("monnort@gmail.com");
        restorePasswordPage.restorePasswordButton.click();

        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/resumes", driver.getCurrentUrl());
    }

    @Test
    public void testHelpLogin() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[6]/div[1]");
        selenium.waitForPageToLoad("10000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[6]/div[2]/div/ul/li[4]/a");
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/", driver.getCurrentUrl());
    }

    @Test
    public void testProf() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[5]/div[1]");
        selenium.waitForPageToLoad("10000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[5]/div[2]/div/ul/li[4]/a/span");
        selenium.waitForPageToLoad("8000");
        profTestPage.start.click();
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/article/proforientation_promo?from=menu", driver.getCurrentUrl());
    }

    @Test
    public void testSuitableVacants() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[4]/div[1]");
        selenium.waitForPageToLoad("10000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[4]/div[2]/div/ul/li[2]/a/span");
        selenium.waitForPageToLoad("8000");
        assertEquals("https://spb.hh.ru/applicant/autosearch.xml", driver.getCurrentUrl());
    }

    @Test
    public void testOrderCV() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[5]/div[1]");
        selenium.waitForPageToLoad("10000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[5]/div[2]/div/ul/li[1]/a/span");
        selenium.waitForPageToLoad("8000");
        orderCVPage.orderCV.click();
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/complete_resume/payment", driver.getCurrentUrl());
    }

    @Ignore
    @Test
    public void testAutoUpdateCV() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        driver.get(cVsChekingPage.getURL());
        selenium.waitForPageToLoad("6000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("6000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[3]/a/span[1]");
        selenium.waitForPageToLoad("6000");
        driver.get(cVsChekingPage.getURL());
        cVsChekingPage.autoupdateCV.click();
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/resumes", driver.getCurrentUrl());
    }

    @Ignore
    @Test
    public void testSelectCV() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        driver.get(cVsChekingPage.getURL());
        selenium.waitForPageToLoad("6000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("6000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[3]/a/span[1]");
        selenium.waitForPageToLoad("6000");
        driver.get(cVsChekingPage.getURL());
        cVsChekingPage.selectCV.click();
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/resumes", driver.getCurrentUrl());
    }

    @Test
    public void testCheckCV() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("6000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[3]/a/span[1]");
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/resumes", driver.getCurrentUrl());
    }

    @Test
    public void testChangeSettings() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[2]/li/div[1]/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[2]/li/div[2]/div/ul/li[1]/a/span");
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/settings", driver.getCurrentUrl());
    }

    @Test
    public void testCheckInvites() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[2]/a/span[1]");
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/negotiations", driver.getCurrentUrl());
    }


    @Test
    public void testCreateCV() throws Exception {
        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");

        selenium.open("/applicant/resumes");
        selenium.click("xpath=/html/body/div[5]/div[2]/div[2]/div[1]/a");
        selenium.waitForPageToLoad("30000");
        assertEquals(driver.getCurrentUrl(), "https://spb.hh.ru/applicant/resumes/view?resume=");
    }
}
