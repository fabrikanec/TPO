package functional.roles;

import functional.newPages.*;
import functional.newPages.LoginPage;
import functional.newPages.RegistrationPage;
import functional.pages.*;
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
    }


    /* REGISTRATION TESTS */

    @Test
    @Ignore //Ignored for now to avoid redundant registration on HH
    public void testEmployeeSuccessRegistration() throws Exception {
        driver.get(registrationPage.getEmployeeURL());

        registrationPage.firstName.sendKeys("Alexey");
        registrationPage.lastName.sendKeys("Vasin");
        registrationPage.login.sendKeys("justanotherrandom@gmail.com");
        registrationPage.password.sendKeys("kukukupopo");
        registrationPage.submitForm.click();

        assertEquals("Alexey Vasin", userMainPage.userName.getText());
    }

    @Test
    public void testEmployeeFailedRegistrationShortPassword() throws Exception {
        driver.get(registrationPage.getEmployeeURL());

        registrationPage.firstName.sendKeys("Alexey");
        registrationPage.lastName.sendKeys("Vasin");
        registrationPage.login.sendKeys("justanotherrandom@gmail.com");
        registrationPage.password.sendKeys("f");
        registrationPage.submitForm.click();

        assertEquals("Слишком короткий пароль", registrationPage.errorString.getText());
    }

    @Test
    public void testEmployeeFailedRegistrationInvalidLogin() throws Exception {
        driver.get(registrationPage.getEmployeeURL());

        registrationPage.firstName.sendKeys("Alexey");
        registrationPage.lastName.sendKeys("Vasin");
        registrationPage.login.sendKeys("justanotherrandom.com");
        registrationPage.password.sendKeys("ffffffffffffffffffff");
        registrationPage.submitForm.click();

        assertEquals("Пожалуйста, укажите email или телефон", registrationPage.errorString.getText());
    }

    /*
    @Test
    public void testLoginWithoutPassword() {
        driver.get(guestMainPage.getURL());
        guestMainPage.loginFormLogin.sendKeys("lol");
        guestMainPage.loginFormSubmit.click();

        assertEquals( "Неправильные данные для входа. Пожалуйста, попробуйте снова.",
                loginPage.wrongCredentialsError.getText());
    }

    @Test
    public void testLoginWithoutLogin() {
        driver.get(guestMainPage.getURL());
        guestMainPage.loginFormPassword.sendKeys("lel");
        guestMainPage.loginFormSubmit.click();

        assertEquals( "Неправильные данные для входа. Пожалуйста, попробуйте снова.",
                loginPage.wrongCredentialsError.getText());
    }

    @Test
    public void testLoginWrongCredentials() throws Exception {
        driver.get(guestMainPage.getURL());
        guestMainPage.loginFormLogin.sendKeys("lol");
        guestMainPage.loginFormPassword.sendKeys("lol");
        guestMainPage.loginFormSubmit.click();
        //assertEquals();
    }


    @Test
    public void testLoginForExistingUser() throws Exception {
        driver.get(guestMainPage.getURL());
        guestMainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        guestMainPage.loginFormPassword.sendKeys("kukukupopo");
        guestMainPage.loginFormLogin.click();

        //assertEquals();
    }

    @Test
    public void testVklogin() throws Exception {
        driver.get(guestMainPage.getURL());
        guestMainPage.vkLogin.click();

        //assertEquals();
    }


    @Test
    public void testRestorePassForeExistingUser() throws Exception {
        driver.get(guestMainPage.getURL());
        guestMainPage.forgotPasswordAnchor.click();

        restorePasswordPage.emailInput.sendKeys("monnort@gmail.com");
        restorePasswordPage.restorePasswordButton.click();

        //assertEquals();
    }


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
