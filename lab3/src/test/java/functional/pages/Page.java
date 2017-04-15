package functional.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public abstract class Page {

  @FindBy(xpath = "//div[@class=\"topbar\"]//a[@class=\"profile-me js-gps-track\"]/div[position()=1]")
  @CacheLookup
  public WebElement avatar;

  @FindBy(xpath = "//div[@class=\"topbar\"]//a[@class=\"topbar-icon icon-site-switcher yes-hover js-site-switcher-button js-gps-track\"]")
  @CacheLookup
  public WebElement stackExchangeMenu;

  @FindBy(xpath = "//div[@class=\"topbar\"]//div[@class=\"modal-content current-site-container\"]//div[@class=\"related-links\"]/a[@href=\"/users/logout\"]")
  @CacheLookup
  public WebElement stackExchangeLogout;

  @FindBy(xpath = "//div[@id=\"logout-form\"]//form//input[@type=\"submit\"]")
  @CacheLookup
  public WebElement logoutBtn;

  protected WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

}
