package functional.roles;

import functional.newPages.*;
import functional.newPages.LoginPage;
import functional.newPages.RegistrationPage;
import functional.util.PropertyLoader;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.grid.web.servlet.handler.SeleniumBasedRequest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static functional.newPages.Page.baseUrl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.thoughtworks.selenium.*;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by cezar on 4/15/17.
 */
public class GuestRoleTest extends JUnitTestBase {

    private GuestMainPage guestMainPage;
    private RegistrationPage registrationPage;
    private RestorePasswordPage restorePasswordPage;
    private LoginPage loginPage;
    private UserMainPage userMainPage;

    @Before
    public void initPageObjects() {
        guestMainPage = PageFactory.initElements(driver, GuestMainPage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        restorePasswordPage = PageFactory.initElements(driver, RestorePasswordPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        userMainPage = PageFactory.initElements(driver, UserMainPage.class);
        driver.get(registrationPage.getEmployeeURL());
    }


    /* REGISTRATION TESTS */

    @Test
    @Ignore //Ignored for now to avoid redundant registration on HH
    public void testEmployeeSuccessRegistration() throws Exception {
        registrationPage.firstName.sendKeys("Alexey");
        registrationPage.lastName.sendKeys("Vasin");
        registrationPage.login.sendKeys("justanotherrandom@gmail.com");
        registrationPage.password.sendKeys("kukukupopo");
        registrationPage.submitForm.click();

        assertEquals("Alexey Vasin", userMainPage.userName.getText());
    }

    @Test
    public void testEmployeeFailedRegistrationShortPassword() throws Exception {
        registrationPage.firstName.sendKeys("Alexey");
        registrationPage.lastName.sendKeys("Vasin");
        registrationPage.login.sendKeys("justanotherrandom@gmail.com");
        registrationPage.password.sendKeys("f");
        registrationPage.submitForm.click();

        assertEquals("Слишком короткий пароль", registrationPage.errorString.getText());
    }

    @Test
    public void testEmployeeFailedRegistrationInvalidLogin() throws Exception {

        registrationPage.firstName.sendKeys("Alexey");
        registrationPage.lastName.sendKeys("Vasin");
        registrationPage.login.sendKeys("justanotherrandom.com");
        registrationPage.password.sendKeys("ffffffffffffffffffff");
        registrationPage.submitForm.click();

        assertEquals("Пожалуйста, укажите email или телефон", registrationPage.errorString.getText());
    }

    @Ignore
    @Test
    public void testVklogin() throws Exception {
        driver.get(MainPage.baseUrl);
        guestMainPage.vkLogin.click();
        selenium.waitForPageToLoad("1000");
        assertEquals("https://oauth.vk.com/authorize?display=mobile&response_type=code&client_id=3295164&redirect_uri=https%3A%2F%2Fhhid.ru%2Foauth2%2Fcode&scope=4194304&state=token%3DUW9Rqq8c27f4HP8r4ohifD91ks2bYS6%21HFyPO9oBpnlleXVcL87RDb9Snccq38DReG59U%21fhp7hRsnYSRdXLtVIBva8W%26reg%3Dhttps%253A%252F%252Fspb.hh.ru%252Faccount%252Fconnect%252Fregister%26fail%3Dhttps%253A%252F%252Fspb.hh.ru%252Faccount%252Fconnect%252Fresult%253Ffail%253Dtrue%26login%3Dhttps%253A%252F%252Fspb.hh.ru%252Faccount%252Fconnect%252Fresult%26system%3DVK%26mergeOAuth%3Dfalse", driver.getCurrentUrl());
    }

    /*



    @Test
    public void testHelpUnlogin() throws Exception {

        selenium.open("/");
        selenium.click("//li[5]/div[2]/div/ul/li[2]/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//input[@name='sendTo'])[3]");
        selenium.click("xpath=(//input[@name='sendTo'])[2]");
        selenium.click("xpath=(//input[@name='sendTo'])[5]");
        selenium.click("xpath=(//input[@name='sendTo'])[4]");
        selenium.click("//input[@name='sendTo']");

    //assertEquals();
    @Test
    public void testCreateCVUnLogin() throws Exception {
        seleniumpen("/");
        selenium.click("//li[3]/div[2]/div/ul/li/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("//input[@value='Войти в личный кабинет']");
        selenium.waitForPageToLoad("30000");


        //assertEquals();
    }
    */
}
