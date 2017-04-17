package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class CVsChekingPage extends UserMainPage {
    private static String URL;

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[3]/x:div[1]")
    @CacheLookup
    public WebElement cvs;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div[2]/div[1]/div[2]")
    @CacheLookup
    public WebElement autoupdateCV;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div[2]/div[1]/div[1]")
    @CacheLookup
    public WebElement selectCV;

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[3]/x:div[2]/x:div/x:ul/x:li[3]/x:a/x:span[1]")
    @CacheLookup
    public WebElement myCVs;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div[2]/div[2]/div[1]/div/div[2]/span[2]/a")
    @CacheLookup
    public WebElement suitableVacant;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div[2]/div[2]/div[1]/div/div[2]/span[2]/a")
    @CacheLookup
    public WebElement orderCV;

    public CVsChekingPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "applicant/resumes";
    }

    public String getURL() {
        return URL;
    }
}
