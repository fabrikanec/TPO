package functional.oldRoles;


import functional.pages.*;
import functional.util.PropertyLoader;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class UserRoleTest extends JUnitTestBase {

    private LoginPage loginPage;
    private AskPage askPage;
    private CommentQuestionPage commentQuestionPage;
    private EditProfilePage editProfilePage;
    private RecoveryPage recoveryPage;

    @Before
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        askPage = PageFactory.initElements(driver, AskPage.class);
        commentQuestionPage = PageFactory.initElements(driver, CommentQuestionPage.class);
        editProfilePage = PageFactory.initElements(driver, EditProfilePage.class);
        recoveryPage = PageFactory.initElements(driver, RecoveryPage.class);
    }

    @Test
    public void testLogin() {
        driver.get(LoginPage.URL);

        loginPage.email.click();
        loginPage.email.sendKeys(PropertyLoader.loadProperty("username"));
        loginPage.password.click();
        loginPage.password.sendKeys(PropertyLoader.loadProperty("password"));

        loginPage.button.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertEquals(PropertyLoader.loadProperty("fullname"), loginPage.avatar.getAttribute("title"));
    }

    @Ignore
    @Test
    public void testEditDisplayName() {
        driver.get(EditProfilePage.URL);

        editProfilePage.displayName.clear();
        editProfilePage.displayName.click();
        editProfilePage.displayName.sendKeys(PropertyLoader.loadProperty("fullname") + "42");

        editProfilePage.save.click();

        assertEquals(PropertyLoader.loadProperty("fullname") + "42", editProfilePage.avatar.getAttribute("title"));
    }

    @Ignore
    @Test
    public void testFailEditDisplayName() {
        driver.get(EditProfilePage.URL);

        editProfilePage.displayName.clear();
        editProfilePage.displayName.click();
        editProfilePage.displayName.sendKeys("");

        editProfilePage.save.click();

        assertEquals("", editProfilePage.avatar.getAttribute("title"));
    }

    @Ignore
    @Test
    public void testEditTitle() {
        driver.get(EditProfilePage.URL);

        editProfilePage.titleDisplay.clear();
        editProfilePage.titleDisplay.click();
        editProfilePage.titleDisplay.sendKeys("Title 42");

        editProfilePage.save.click();

        assertEquals("Title 42", editProfilePage.avatar.getAttribute("title"));
    }

    @Ignore
    @Test
    public void testFailEditTitle() {
        driver.get(EditProfilePage.URL);

        editProfilePage.titleDisplay.clear();
        editProfilePage.titleDisplay.click();
        editProfilePage.titleDisplay.sendKeys("");

        editProfilePage.save.click();

        assertEquals("", editProfilePage.avatar.getAttribute("title"));
    }

    @Ignore
    @Test
    public void testAskQuestions() {
        driver.get(AskPage.URL);

        askPage.questionAdvised.click();
        askPage.questionAdvisedClick.click();
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

        askPage.questionTitle.clear();
        askPage.questionTitle.click();
        askPage.questionTitle.sendKeys("BIG QUESTION TITLE LEAST 15");
        askPage.questionContent.clear();
        askPage.questionContent.click();
        askPage.questionContent.sendKeys("Body must be at least 30 characters;");
        askPage.questionTags.clear();
        askPage.questionTags.click();
        askPage.questionTags.sendKeys("selenium java");

        askPage.questionSubmit.click();
    }

//    @Ignore
    @Test
    public void testFailAskQuestions() {
        driver.get(AskPage.URL);

        askPage.questionAdvised.click();
        askPage.questionAdvisedClick.click();
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

        askPage.questionTitle.clear();
        askPage.questionTitle.click();
        askPage.questionTitle.sendKeys("");
        askPage.questionContent.clear();
        askPage.questionContent.click();
        askPage.questionContent.sendKeys("Body must be at least 30 characters;");
        askPage.questionTags.clear();
        askPage.questionTags.click();
        askPage.questionTags.sendKeys("selenium java");

        askPage.questionSubmit.click();
        assertEquals("Title is missing.", askPage.msgsText.get(0).getText());
    }

    @Ignore
    @Test
    public void testCommentQuestion() {
        driver.get(CommentQuestionPage.URL);

        commentQuestionPage.questionComment.click();
        commentQuestionPage.questionComment.sendKeys("Comment");

        commentQuestionPage.questionSubmit.click();
    }

//    @Ignore
    @Test
    public void testFailCommentQuestion() {
        driver.get(CommentQuestionPage.URL);

        commentQuestionPage.questionComment.click();
        commentQuestionPage.questionComment.sendKeys("");

        commentQuestionPage.questionSubmit.click();

        assertEquals("Body is missing.", commentQuestionPage.msgText.getText());
    }

    @Ignore
    @Test
    public void testVoteUpQuestion() {
        driver.get(CommentQuestionPage.URL);

        int voteCount = Integer.parseInt(commentQuestionPage.voteCount.getText());
        commentQuestionPage.voteUp.click();

        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

        assertEquals((voteCount + 1) + "", commentQuestionPage.voteCount.getText());
    }

    @Ignore
    @Test
    public void testVoteDownQuestion() {
        driver.get(CommentQuestionPage.URL);

        int voteCount = Integer.parseInt(commentQuestionPage.voteCount.getText());
        commentQuestionPage.voteDown.click();

        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

        assertEquals((voteCount - 1) + "", commentQuestionPage.voteCount.getText());
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void testLogout() {
        driver.get(LoginPage.URL);

        loginPage.stackExchangeMenu.click();
        loginPage.stackExchangeLogout.click();
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

        loginPage.logoutBtn.click();
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

        assertNull(loginPage.avatar.getAttribute("fullname"));
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void testFailLogin() {
        driver.get(LoginPage.URL);

        loginPage.email.click();
        loginPage.email.sendKeys("notcorrect42@mail.ru");
        loginPage.password.click();
        loginPage.password.sendKeys("12345");

        loginPage.button.click();

        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

        assertNull(loginPage.avatar);
    }
}
