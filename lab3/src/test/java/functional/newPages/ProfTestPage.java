package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class ProfTestPage extends Page {
    public static String URL = "https://spb.hh.ru/article/proforientation_promo?from=menu";
    private static String PAYMENT = "https://spb.hh.ru/applicant/proforientation/payment";

    public ProfTestPage(WebDriver driver) {
        super(driver);
    }
}
