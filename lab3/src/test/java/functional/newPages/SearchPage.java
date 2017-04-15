package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class SearchPage extends Page {
    public static String URL = "http://spb.hh.ru/article/expert_resume?from=myresume";
    public static String URL_FORWARD = "http://spb.hh.ru/applicant/complete_resume/payment";

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}