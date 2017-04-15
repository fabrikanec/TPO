package functional.pages;


import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobsPage extends Page {
  public static String URL;

  @FindBy(xpath = "//div[@id=\"content\"]//div[@class=\"listResults\"]//div[@class=\"-item -job\"]")
  @CacheLookup
  public List<WebElement> searchResult;

  @FindBy(xpath = "//div[@id=\"content\"]//section[@class=\"searchControls -row\"]//input[@id=\"searchTerm\"]")
  @CacheLookup
  public WebElement search;

  @FindBy(xpath = "//div[@id=\"content\"]//section[@class=\"searchControls -row\"]//button[@type=\"submit\"]")
  @CacheLookup
  public WebElement searchSubmit;

  public JobsPage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl + "jobs";
  }
}
