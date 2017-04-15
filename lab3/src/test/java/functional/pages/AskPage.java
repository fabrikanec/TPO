package functional.pages;


import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AskPage extends Page {
  public static String URL;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"theForm\"]//input[@id=\"advised\"]")
  @CacheLookup
  public WebElement questionAdvised;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"theForm\"]//a[@class=\"js-gps-track\"]")
  @CacheLookup
  public WebElement questionAdvisedClick;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"post-form\"]//input[@id=\"title\"]")
  @CacheLookup
  public WebElement questionTitle;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"post-form\"]//textarea[@id=\"wmd-input\"]")
  @CacheLookup
  public WebElement questionContent;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"post-form\"]//div[@class=\"tag-editor\"]//input")
  @CacheLookup
  public WebElement questionTags;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"post-form\"]//input[@id=\"submit-button\"]")
  @CacheLookup
  public WebElement questionSubmit;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"post-form\"]//div[@class=\"message-text\"]")
  @CacheLookup
  public List<WebElement> msgsText;

  public AskPage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "questions/ask";
  }
}
