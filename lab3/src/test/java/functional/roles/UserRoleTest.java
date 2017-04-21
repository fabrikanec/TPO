package functional.roles;

import com.thoughtworks.selenium.Selenium;
import functional.newPages.*;
import org.junit.Before;
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

        driver.get(mainPage.getURL());
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.sendKeys(Keys.ENTER);
        selenium.waitForPageToLoad("30000");
    }

    @Test
    public void testLoginWithoutPassword() {
        mainPage.loginFormLogin.sendKeys("lol");
        mainPage.loginFormSubmit.click();

        assertEquals( "Неправильные данные для входа. Пожалуйста, попробуйте снова.",
                loginPage.wrongCredentialsError.getText());
    }

    @Test
    public void testLoginWithoutLogin() {
        mainPage.loginFormPassword.sendKeys("lel");
        mainPage.loginFormSubmit.click();

        assertEquals( "Неправильные данные для входа. Пожалуйста, попробуйте снова.",
                loginPage.wrongCredentialsError.getText());
    }

    @Test
    public void testLoginWrongCredentials() throws Exception {
        mainPage.loginFormLogin.sendKeys("lol");
        mainPage.loginFormPassword.sendKeys("lol");
        mainPage.loginFormSubmit.click();
        //assertEquals();
    }


    @Test
    public void testLoginForExistingUser() throws Exception {
        mainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        mainPage.loginFormPassword.sendKeys("kukukupopo");
        mainPage.loginFormLogin.click();

        //assertEquals();
    }

    @Test
    public void testVklogin() throws Exception {
        mainPage.vkLogin.click();

        //assertEquals();
    }


    @Test
    public void testRestorePassForeExistingUser() throws Exception {
        mainPage.forgotPasswordAnchor.click();

        restorePasswordPage.emailInput.sendKeys("monnort@gmail.com");
        restorePasswordPage.restorePasswordButton.click();

        //assertEquals();
    }

    /* TRASH */
    @Test
    public void testHelpLogin() throws Exception {
        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[6]/div[1]");
        selenium.waitForPageToLoad("10000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[6]/div[2]/div/ul/li[4]/a");
        selenium.waitForPageToLoad("8000");
    }

    @Test
    public void testProf() throws Exception {
        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[5]/div[1]");
        selenium.waitForPageToLoad("10000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[5]/div[2]/div/ul/li[4]/a/span");
        selenium.waitForPageToLoad("8000");
        profTestPage.start.click();
    }

    @Test
    public void testSuitableVacants() throws Exception {
        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("10000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[3]/a/span[1]");
        selenium.waitForPageToLoad("8000");
        cVsChekingPage.suitableVacant.click();
    }

    @Test
    public void testOrderCV() throws Exception {
        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[5]/div[1]");
        selenium.waitForPageToLoad("10000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[5]/div[2]/div/ul/li[1]/a/span");
        selenium.waitForPageToLoad("8000");
        orderCVPage.orderCV.click();
    }

    @Test
    public void testAutoUpdateCV() throws Exception {
        driver.get(cVsChekingPage.getURL());
        selenium.waitForPageToLoad("6000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("6000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[3]/a/span[1]");
        selenium.waitForPageToLoad("6000");
        driver.get(cVsChekingPage.getURL());
        cVsChekingPage.autoupdateCV.click();
    }

    @Test
    public void testSelectCV() throws Exception {
        driver.get(cVsChekingPage.getURL());
        selenium.waitForPageToLoad("6000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("6000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[3]/a/span[1]");
        selenium.waitForPageToLoad("6000");
        driver.get(cVsChekingPage.getURL());
        cVsChekingPage.selectCV.click();
    }

    @Test
    public void testCheckCV() throws Exception {
        selenium.waitForPageToLoad("6000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("6000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[3]/a/span[1]");
    }

    @Test
    public void testChangeSettings() throws Exception {
        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[2]/li/div[1]/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[2]/li/div[2]/div/ul/li[1]/a/span");
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/settings", driver.getCurrentUrl());
    }

    @Test
    public void testCheckInvites() throws Exception {
        selenium.waitForPageToLoad("30000");
        selenium.mouseOver("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[1]");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div/ul[1]/li[3]/div[2]/div/ul/li[2]/a/span[1]");
        selenium.waitForPageToLoad("6000");
        assertEquals("https://spb.hh.ru/applicant/negotiations", driver.getCurrentUrl());
    }


    @Test
    public void testCreateCV() throws Exception {
        selenium.open("/applicant/resumes");
        selenium.click("xpath=/html/body/div[5]/div[2]/div[2]/div[1]/a");
        selenium.waitForPageToLoad("30000");
        assertEquals(driver.getCurrentUrl(), "https://spb.hh.ru/applicant/resumes/view?resume=");
    }
}
