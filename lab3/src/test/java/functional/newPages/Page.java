package functional.newPages;

import functional.util.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public interface Page {
    String baseUrl = PropertyLoader.loadProperty("site.url");
    String getTitle();
}