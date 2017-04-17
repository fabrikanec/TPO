package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class CreateCVPage extends MainPage {
    private static String URL;

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[3]/x:div[1]")
    @CacheLookup
    public WebElement cvs;

    @FindBy(xpath = "/x:html/x:body/x:div[5]/x:div[2]/x:div[2]/x:div[1]/x:a[1]")
    @CacheLookup
    public WebElement createCV;


    public CreateCVPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "applicant/resumes/view?resume=";
    }

    public String getURL() {
        return URL;
    }
}
