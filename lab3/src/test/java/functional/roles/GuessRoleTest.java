package functional.roles;

import functional.newPages.*;
import functional.newPages.LoginPage;
import functional.newPages.RegistrationPage;
import functional.pages.*;
import functional.util.PropertyLoader;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by cezar on 4/15/17.
 */
public class GuessRoleTest extends JUnitTestBase {
    private GuestMainPage guestMainPage;
    private LoginPage loginPage;
    private CoursesPage coursesPage;
    private VKLoginPage vkLoginPage;
    private RestorePasswordPage passwordPage;
    private CreateVacantPage createVacantPage;
    private RegistrationPage registrationPage;

    @Before
    public void initPageObjects() {

        guestMainPage = PageFactory.initElements(driver, GuestMainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        coursesPage = PageFactory.initElements(driver, CoursesPage.class);
        vkLoginPage = PageFactory.initElements(driver, VKLoginPage.class);
        passwordPage = PageFactory.initElements(driver, RestorePasswordPage.class);
        createVacantPage = PageFactory.initElements(driver, CreateVacantPage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
    }

    @Test(expected = Exception.class)
    public void testLoginWithoutPassword () {
        driver.get(GuestMainPage.URL);
        guestMainPage.loginFormLogin.sendKeys("lol");
        guestMainPage.loginFormLogin.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
}
