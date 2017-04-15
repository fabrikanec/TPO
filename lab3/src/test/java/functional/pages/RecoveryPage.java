package functional.pages;


import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RecoveryPage extends Page {
  public static String URL;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"account-recovery\"]//input[@id=\"display-name\"]")
  @CacheLookup
  public WebElement email;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"login-form\"]//input[@type=\"submit\"]")
  @CacheLookup
  public WebElement submit;

  public RecoveryPage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "users/account-recovery";
  }
}
