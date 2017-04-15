package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class CreateVacantPage extends Page {
    public static String URL = "http://spb.hh.ru/auth/employer";
    //from GuestPage

    public CreateVacantPage(WebDriver driver) {
        super(driver);
    }
}
