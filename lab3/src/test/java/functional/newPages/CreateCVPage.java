package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class CreateCVPage extends Page {
    public static String URL = "http://spb.hh.ru/applicant/resumes/view?resume=";

    public CreateCVPage(WebDriver driver) {
        super(driver);
    }
}
