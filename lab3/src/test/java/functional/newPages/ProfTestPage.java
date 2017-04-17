package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class ProfTestPage extends CVsChekingPage {
    private static String URL;
    private static String PAYMENT;

    @FindBy(xpath = "/x:html/x:body/x:div[1]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[5]/x:div[1]")
    @CacheLookup
    public WebElement service;

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[5]/x:div[2]/x:div/x:ul/x:li[4]/x:a/x:span")
    @CacheLookup
    public WebElement profTest;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div/div/div[1]/div/div/a")
    @CacheLookup
    public WebElement start;


    public ProfTestPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "article/proforientation_promo?from=menu";
        PAYMENT = baseUrl + "applicant/proforientation/payment";
    }

    public String getURL() {
        return URL;
    }

    public static String getPAYMENT() {
        return PAYMENT;
    }
}
