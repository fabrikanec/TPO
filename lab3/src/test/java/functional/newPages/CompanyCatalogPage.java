package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class CompanyCatalogPage extends MainPage {
    private static String URL;



    public CompanyCatalogPage(WebDriver driver) {
        super(driver);
        URL = baseUrl + "employers_company";
    }

    public String getURL() {
        return URL;
    }
}
