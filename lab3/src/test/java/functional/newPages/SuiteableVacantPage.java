package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class SuiteableVacantPage extends Page {
    public static String URL = "http://spb.hh.ru/applicant/resumes";
    public static String URL_FORWARD = "http://spb.hh.ru/search/vacancy?resume=7ef419d1ff02d5d7fe0039ed1f6b3944433758&from=resumelist";

    public SuiteableVacantPage(WebDriver driver) {
        super(driver);
    }
}
