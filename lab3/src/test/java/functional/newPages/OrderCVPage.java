package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class OrderCVPage extends CVsChekingPage {
    private static String URL;
    public static String URL_FORWARD = "http://spb.hh.ru/applicant/complete_resume/payment";

    @FindBy(xpath = "/x:html/x:body/x:div[1]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[5]/x:div[1]")
    @CacheLookup
    public WebElement service;

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[5]/x:div[2]/x:div/x:ul/x:li[1]/x:a/x:span")
    @CacheLookup
    public WebElement order;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div/div[1]/div[2]/a")
    @CacheLookup
    public WebElement orderCV;

    public OrderCVPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "article/expert_resume?from=myresume";
    }

    public String getURL() {
        return URL;
    }
}
