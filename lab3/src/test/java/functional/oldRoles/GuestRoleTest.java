package functional.oldRoles;

import functional.pages.JobsPage;
import functional.pages.QuestionsPage;
import functional.pages.RegistrationPage;
import functional.pages.UserPage;
import functional.util.PropertyLoader;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GuestRoleTest extends JUnitTestBase {

    private QuestionsPage questionsPage;
    private JobsPage jobsPage;
    private RegistrationPage registrationPage;
    private UserPage userPage;

    @Before
    public void initPageObjects() {
        questionsPage = PageFactory.initElements(driver, QuestionsPage.class);
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        userPage = PageFactory.initElements(driver, UserPage.class);
    }

    @Test
    public void testQuestionsPageHasAQuestions() {
        driver.get(QuestionsPage.URL);

        assertEquals(50, questionsPage.questions.size());

    }

    @Test
    public void testQuestionsPageSizerIsWork() {
        driver.get(QuestionsPage.URL);
        questionsPage.pageSizer.get(2).click();
        assertEquals(50, questionsPage.questions.size());

    }

    @Test
    public void testUserSearch() {
        driver.get(UserPage.URL + "?tab=reputation");

        userPage.userSearch.click();
        userPage.userSearch.sendKeys(PropertyLoader.loadProperty("fullname"));
        userPage.userSearch.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        assertEquals(PropertyLoader.loadProperty("fullname"), userPage.userNameList.get(1).getText());
    }

    @Test
    public void testJobSearch() {
        driver.get(JobsPage.URL);
        jobsPage.search.sendKeys("[java]");
        jobsPage.searchSubmit.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertNotEquals(0, jobsPage.searchResult.size());
    }

    @Ignore
    @Test
    public void testRegistration() {
        driver.get(RegistrationPage.URL);

        registrationPage.email.sendKeys("pushkin@kolotushkin.ru");
        registrationPage.userName.sendKeys("NASHE VSE");
        registrationPage.password.sendKeys("STRONG PASSWORD");
        registrationPage.submit.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        assertEquals("NASHE VSE", registrationPage.avatar.getAttribute("title"));
    }

    @Ignore
    @Test
    public void testFailExistUserRegistration() {
        driver.get(RegistrationPage.URL);

        registrationPage.email.sendKeys(PropertyLoader.loadProperty("fullname"));
        registrationPage.userName.sendKeys("NASHE VSE");
        registrationPage.password.sendKeys("STRONG PASSWORD");
        registrationPage.submit.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        assertEquals("NASHE VSE", registrationPage.avatar.getAttribute("title"));
    }

    @Ignore
    @Test
    public void testFailUserRegistration() {
        driver.get(RegistrationPage.URL);

        registrationPage.email.sendKeys("");
        registrationPage.userName.sendKeys("");
        registrationPage.password.sendKeys("");
        registrationPage.submit.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        assertEquals("", registrationPage.avatar.getAttribute("title"));
    }

    @Test
    public void testUserReputationSearch() {
        driver.get(UserPage.URL + "?tab=reputation");

        userPage.userSearch.click();
        userPage.userSearch.sendKeys(PropertyLoader.loadProperty("fullname"));
        userPage.userSearch.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        assertEquals("0", userPage.userReputationList.get(0).getText());
    }
}
