package functional.pages;

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CommentQuestionPage extends Page {
  public static String URL;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"post-form\"]//textarea[@id=\"wmd-input\"]")
  @CacheLookup
  public WebElement questionComment;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"post-form\"]//input[@id=\"submit-button\"]")
  @CacheLookup
  public WebElement questionSubmit;

  @FindBy(xpath = "//div[@id=\"question\"]//a[@class=\"vote-up-off\"]")
  @CacheLookup
  public WebElement voteUp;

  @FindBy(xpath = "//div[@id=\"question\"]//a[@class=\"vote-down-off\"]")
  @CacheLookup
  public WebElement voteDown;

  @FindBy(xpath = "//div[@id=\"question\"]//span[@class=\"vote-count-post \"]")
  @CacheLookup
  public WebElement voteCount;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"post-form\"]//div[@class=\"message-text\"]")
  @CacheLookup
  public WebElement msgText;

  public CommentQuestionPage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "questions/8530875/get-around-capcha-in-selenium";
  }
}
