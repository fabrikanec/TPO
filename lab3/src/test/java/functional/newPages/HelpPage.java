package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class HelpPage extends Page {
    private static String LoginURL = "http://feedback.hh.ru/knowledgebase/category/id/220?utm_source=hh.ru&utm_medium=copiny&utm_campaign=applicant_menu";
    private static String UnLoginURL = "http://feedback.hh.ru/?utm_source=hh.ru&utm_medium=copiny&utm_campaign=menu";

    public HelpPage(WebDriver driver) {
        super(driver);
    }
}
