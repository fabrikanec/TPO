package functional.newPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cezar on 4/15/17.
 */
public class HelpPage extends MainPage {
    private static String loginURL = "http://feedback.hh.ru/knowledgebase/category/id/220?utm_source=hh.ru&utm_medium=copiny&utm_campaign=applicant_menu";
    private static String unLoginURL = "http://feedback.hh.ru/?utm_source=hh.ru&utm_medium=copiny&utm_campaign=menu";

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[6]/x:div[1]")
    @CacheLookup
    public WebElement help;

    @FindBy(xpath = "/x:html/x:body/x:div[2]/x:div[2]/x:div/x:div/x:div/x:ul[1]/x:li[6]/x:div[2]/x:div/x:ul/x:li[5]/x:a/x:span")
    @CacheLookup
    public WebElement helpCommunity;


    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public static String getLoginURL() {
        return loginURL;
    }

    public static String getUnLoginURL() {
        return unLoginURL;
    }
}
