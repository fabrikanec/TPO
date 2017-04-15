package functional.pages;

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Page {
  public static String URL;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"login-form\"]//input[@id=\"display-name\"]")
  @CacheLookup
  public WebElement userName;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"login-form\"]//input[@id=\"email\"]")
  @CacheLookup
  public WebElement email;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"login-form\"]//input[@id=\"password\"]")
  @CacheLookup
  public WebElement password;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@id=\"login-form\"]//input[@id=\"submit-button\"]")
  @CacheLookup
  public WebElement submit;

  public RegistrationPage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "users/signup";
  }
}
