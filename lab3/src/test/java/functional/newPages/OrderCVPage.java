package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class OrderCVPage extends Page {
    public static String URL = "https://spb.hh.ru/article/expert_resume?from=myresume";
    public static String URL_FORWARD = "https://spb.hh.ru/applicant/complete_resume/payment";

    public OrderCVPage(WebDriver driver) {
        super(driver);
    }
}