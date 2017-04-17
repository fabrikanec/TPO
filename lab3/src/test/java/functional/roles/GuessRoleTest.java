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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static functional.newPages.Page.baseUrl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.thoughtworks.selenium.*;
/**
 * Created by cezar on 4/15/17.
 */
public class GuessRoleTest extends JUnitTestBase {

    private GuestMainPage guestMainPage;
    private LoginPage loginPage;
    private VKLoginPage vkLoginPage;
    private RestorePasswordPage passwordPage;
    private CreateVacantPage createVacantPage;
    private RegistrationPage registrationPage;
    private Selenium selenium;

    @Before
    public void initPageObjects() {
        guestMainPage = PageFactory.initElements(driver, GuestMainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        vkLoginPage = PageFactory.initElements(driver, VKLoginPage.class);
        passwordPage = PageFactory.initElements(driver, RestorePasswordPage.class);
        createVacantPage = PageFactory.initElements(driver, CreateVacantPage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testLoginWithoutPassword () {
        driver.get(guestMainPage.getURL());
        guestMainPage.loginFormLogin.sendKeys("lol");
        guestMainPage.loginFormLogin.sendKeys(Keys.ENTER);
    }

    @Test
    public void testSearchUnLogin() throws Exception {
        /*driver.get(GuestMainPage.URL);
        guestMainPage.searchField.sendKeys("devops");
        guestMainPage.searchButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/

            selenium.open("/");
            selenium.type("//input[@name='text']", "devops");
            selenium.click("//button[@type='submit']");
            selenium.waitForPageToLoad("30000");
            selenium.click("//a[contains(text(),'DevOps Engineer')]");
    }

    @Test
    public void testFailLogin() throws Exception {
        driver.get(guestMainPage.getURL());
        guestMainPage.loginFormLogin.sendKeys("lol");
        guestMainPage.loginFormPassword.sendKeys("lol");
        guestMainPage.loginFormLogin.sendKeys(Keys.ENTER);

        /*selenium.open("/vacancy/20122459?query=devops");
        selenium.type("name=username", "lol");
        selenium.type("name=password", "123");
        selenium.click("//input[@value='Войти в личный кабинет']");
        selenium.waitForPageToLoad("30000");*/
    }

    @Test
    public void testLogin() throws Exception {
        driver.get(guestMainPage.getURL());
        guestMainPage.loginFormLogin.sendKeys("monnort@gmail.com");
        guestMainPage.loginFormPassword.sendKeys("kukukupopo");
        guestMainPage.loginFormLogin.sendKeys(Keys.ENTER);

        /*selenium.open("/");
        selenium.type("css=label.login-input > input[name=\"username\"]", "monnort@gmail.com");
        selenium.type("css=label.login-input > input[name=\"password\"]", "kukukupopo");
        selenium.click("name=action");
        selenium.waitForPageToLoad("30000");
        selenium.click("//li[3]/a/span");
        selenium.waitForPageToLoad("30000");*/
    }

    @Test
    public void testCourses() throws Exception {
        selenium.open("/");
        selenium.waitForPopUp("", "30000");
        selenium.selectWindow("name=45459");
        selenium.click("//div[@id='BaseApp-react-component-0']/div/div[2]/div/div/div/div/div/ul/li[6]/a/div[2]");
    }

    @Test
    public void testVklogin() throws Exception {
        driver.get(guestMainPage.getURL());
        guestMainPage.vkLogin.click();
        /*selenium.open("/");
        selenium.click("xpath=(//a[contains(@href, '/account/connect?backurl=%2F&site=VK')])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(@href, '/account/connect?backurl=%2F&site=VK')]");
        selenium.waitForPageToLoad("30000");*/
    }

    @Test
    public void testRestorePass() throws Exception {
        selenium.open("/");
        selenium.click("xpath=(//a[contains(text(),'Забыли пароль?')])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.type("//input[@name='login']", "monnort@gmail.com");
        selenium.click("//input[@value='Восстановить пароль']");
        selenium.waitForPageToLoad("30000");
    }

    @Test
    public void testCreateVacant() throws Exception {
        selenium.open("/");
        selenium.click("//a[contains(text(),'Опубликовать вакансию')]");
        selenium.waitForPageToLoad("30000");
        selenium.click("//button[@type='submit']");
    }

    @Test
    public void testRegistration() throws Exception {
        selenium.open("/search/vacancy?text=devops&area=2");
        selenium.click("link=Соискателя");
        selenium.waitForPageToLoad("30000");
        selenium.type("name=firstName", "Ivan");
        selenium.type("name=lastName", "Lavrov");
        selenium.type("name=login", "monnort@gmail.com");
        selenium.type("name=password", "kukukupopo");
        selenium.click("//input[@value='Зарегистрироваться']");
        selenium.waitForPageToLoad("30000");
        selenium.click("name=gender.string");
        selenium.type("name=phone.formatted", "+79996666666");
        selenium.select("//span/select", "label=1");
        selenium.select("css=select.bloko-select.HH-Resume-Birthday-Month", "label=января");
        selenium.select("css=select.bloko-select.HH-Resume-Birthday-Year", "label=2003");
        selenium.click("name=primaryEducation.name");
        selenium.type("name=primaryEducation.name", "Универси");
        selenium.click("css=div.primary-edu-suggestion");
        selenium.type("name=primaryEducation.organization", "КТиУ");
        selenium.click("name=primaryEducation.result");
        selenium.type("name=primaryEducation.result", "Погромист");
        selenium.select("name=primaryEducation.year", "label=2011");
        selenium.click("css=option[value=\"2011\"]");
        selenium.click("css=span.bloko-link-switch.HH-Resume-Form-Info-Link-Template");
        selenium.click("css=span.bloko-link-switch.HH-Resume-Form-Info-Link-Template");
        selenium.click("css=div.bloko-form-row > label.bloko-radio > input[name=\"experienceChanger\"]");
        selenium.click("css=div.bloko-form-row > label.bloko-radio > span.bloko-radio__text");
        selenium.click("xpath=(//input[@name='specialization.string'])[2]");
        selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div/div[2]/label/span");
        selenium.click("xpath=(//input[@name='specialization.string'])[13]");
        selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div[2]/div[3]/label/span");
        selenium.click("xpath=(//input[@name='specialization.string'])[11]");
        selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div[2]/div/label/span");
        selenium.click("xpath=(//input[@name='specialization.string'])[2]");
        selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div/div[2]/label/span");
        selenium.click("xpath=(//input[@name='specialization.string'])[6]");
        selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div/div[6]/label/span");
        selenium.click("name=submit");
        selenium.waitForPageToLoad("30000");
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
    }

    @Test
    public void testCreateCVUnLogin() throws Exception {
        selenium.open("/");
        selenium.click("//li[3]/div[2]/div/ul/li/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("//input[@value='Войти в личный кабинет']");
        selenium.waitForPageToLoad("30000");
    }
}
