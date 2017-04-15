package functional.pages;


import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
  public static String URL;

  @FindBy(xpath = "//form[@id=\"login-form\"]/input[@type=\"email\"]")
  @CacheLookup
  public WebElement email;

  @FindBy(xpath = "//form[@id=\"login-form\"]/input[@type=\"password\"]")
  @CacheLookup
  public WebElement password;

  @FindBy(xpath = "//form[@id=\"login-form\"]/input[@type=\"button\"]")
  @CacheLookup
  public WebElement button;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "users/login";
  }
}
