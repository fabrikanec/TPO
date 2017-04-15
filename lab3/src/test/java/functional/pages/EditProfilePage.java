package functional.pages;

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends Page {
  public static String URL;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@class=\"user-edit-form\"]//input[@name=\"DisplayName\"]")
  @CacheLookup
  public WebElement displayName;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@class=\"user-edit-form\"]//input[@name=\"DisplayName\"]")
  @CacheLookup
  public WebElement titleDisplay;

  @FindBy(xpath = "//div[@id=\"content\"]//form[@class=\"user-edit-form\"]//div[@class=\"form-submit\"]//input[1]")
  @CacheLookup
  public WebElement save;

  public EditProfilePage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "users/edit/6244929";
  }
}
