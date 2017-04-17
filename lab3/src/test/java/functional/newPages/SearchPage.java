package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class SearchPage extends MainPage {
    private static String URL;
    private static String URL_FORWARD;

    public SearchPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "article/expert_resume?from=myresume";
        URL_FORWARD = baseUrl + "applicant/complete_resume/payment";
    }

    public String getURL() {
        return URL;
    }

    public String getURLForward() {
        return URL_FORWARD;
    }
}