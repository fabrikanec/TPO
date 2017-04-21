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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
}
