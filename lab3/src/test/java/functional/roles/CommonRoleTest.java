package functional.roles;

import functional.newPages.*;
import org.junit.Test;

/**
 * Created by cezar on 4/15/17.
 */
public class CommonRoleTest extends JUnitTestBase {
    private MainPage mainPage;
    private UserMainPage userMainPage;
    private GuestMainPage guestMainPage;
    private CompanyCatalogPage companyCatalogPage;
    private HelpPage helpPage;

    @Test
    public void testSearch() throws Exception {
        selenium.open("/");
        selenium.type("//input[@name='text']", "devops");
        selenium.click("//button[@type='submit']");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(text(),'DevOps Engineer')]");
    }

    @Test
    public void testChangeLocate() throws Exception {
        selenium.open("/");
        selenium.click("xpath=(//a[contains(text(),'Английский')])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//a[contains(text(),'Russian')])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("xpath=(//a[contains(text(),'Английский')])[2]");
        selenium.waitForPageToLoad("30000");
        selenium.click("//input[@value='Registration']");
        selenium.click("xpath=(//a[contains(text(),'Russian')])[2]");
        selenium.waitForPageToLoad("30000");
    }

    @Test
    public void testCatalogCom() throws Exception {
        selenium.open("/");
        selenium.click("//a[contains(@href, '/employers_company')]");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(text(),'Информационные технологии, системная интеграция, интернет')]");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(text(),'08')]");
        selenium.waitForPageToLoad("30000");
    }


}
