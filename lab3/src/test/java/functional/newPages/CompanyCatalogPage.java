package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class CompanyCatalogPage extends Page {
    public static String URL = "http://spb.hh.ru/employers_company";

    @FindBy(xpath = "//div[6]/a[starts-with(.,'Инфор')]")
    @CacheLookup
    public WebElement ITSubcatalogAnchor;

    @FindBy(xpath = "//h1[@class='employers-company__title' and starts-with(.,'Компании')]")
    @CacheLookup
    public WebElement ITSubcatalogPageH1Title;

    public CompanyCatalogPage(WebDriver driver) {
        super(driver);
    }
    //from GuestPage
}
