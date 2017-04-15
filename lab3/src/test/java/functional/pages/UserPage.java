package functional.pages;


import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPage extends Page {
  public static String URL;

  @FindBy(xpath = "//div[@id=\"content\"]//div[@class=\"page-description\"]//input[@id=\"userfilter\"]")
  @CacheLookup
  public WebElement userSearch;

  @FindBy(xpath = "//div[@id=\"content\"]//div[@id=\"user-browser\"]//div[@class=\"user-details\"]//a")
  @CacheLookup
  public List<WebElement> userNameList;

  @FindBy(xpath = "//div[@id=\"content\"]//div[@id=\"user-browser\"]//span[@class=\"reputation-score\"]")
  @CacheLookup
  public List<WebElement> userReputationList;

  public UserPage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "users";
  }
}
