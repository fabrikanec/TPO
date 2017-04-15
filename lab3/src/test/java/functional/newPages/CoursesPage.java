package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class CoursesPage extends Page {
    public static String URL = "http://academy.hh.ru/courses?from=tizer_100417"; // fromGuestPage

    public CoursesPage(WebDriver driver) {
        super(driver);
    }
}
