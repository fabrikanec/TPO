package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class CVsChekingPage extends UserMainPage {
    public static String URL = "http://spb.hh.ru/applicant/resumes";

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[3]/x:div[1]")
    @CacheLookup
    public WebElement cvs;

    @FindBy(xpath = "/x:html/x:body/x:div[5]/x:div[2]/x:div[2]/x:div[1]/x:div[2]")
    @CacheLookup
    public WebElement autoupdateCV;

    @FindBy(xpath = "/x:html/x:body/x:div[5]/x:div[2]/x:div[2]/x:div[1]/x:div[1]")
    @CacheLookup
    public WebElement selectCV;

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[3]/x:div[2]/x:div/x:ul/x:li[3]/x:a/x:span[1]")
    @CacheLookup
    public WebElement myCVs;

    @FindBy(xpath = "/x:html/x:body/x:div[5]/x:div[2]/x:div[2]/x:div[2]/x:div/x:div/x:div[2]/x:span[2]/x:a")
    @CacheLookup
    public WebElement suitableVacant;
    public CVsChekingPage(WebDriver driver) {
        super(driver);
    }
}
