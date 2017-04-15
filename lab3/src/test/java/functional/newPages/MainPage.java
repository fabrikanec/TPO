package functional.newPages;

import functional.oldRoles.JUnitTestBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class MainPage extends Page {
    public static String URL = "http://spb.hh.ru/";

    /*
     *
     * WAT?
     *
     */

    public MainPage(WebDriver driver) {
        super(driver);
        URL = JUnitTestBase.baseUrl;
    }
}