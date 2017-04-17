package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class SuiteableVacantPage extends CVsChekingPage {
    private static String URL;
    private static String URL_FORWARD;

    public SuiteableVacantPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "applicant/resumes";
        URL_FORWARD = baseUrl + "search/vacancy?resume=" +
                "7ef419d1ff02d5d7fe0039ed1f6b3944433758&from=resumelist";
    }

    public String getURL() {
        return URL;
    }

    public String getURLForward() {
        return URL_FORWARD;
    }
}
