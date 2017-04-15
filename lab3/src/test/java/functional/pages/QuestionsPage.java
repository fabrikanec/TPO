package functional.pages;


import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QuestionsPage extends Page {
  public static String URL;

  @FindBy(xpath = "//div[@id=\"content\"]//div[@id=\"questions\"]//div[@class=\"question-summary\"]")
  @CacheLookup
  public List<WebElement> questions;

  @FindBy(xpath = "//div[@id=\"content\"]//div[@id=\"questions\"]//a[@class=\"question-hyperlink\"]")
  @CacheLookup
  public List<WebElement> questionLinks;

  @FindBy(xpath = "//div[@id=\"content\"]//div[@class=\"page-sizer fr\"]/a")
  @CacheLookup
  public List<WebElement> pageSizer;

  public QuestionsPage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "questions";
  }
}
