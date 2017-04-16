package functional.roles;

import functional.util.PropertyLoader;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class JUnitTestBase {

    public static String baseUrl;
    protected static Capabilities capabilities;


    protected WebDriver driver;

    @ClassRule
    public static ExternalResource webDriverProperties = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            baseUrl = PropertyLoader.loadProperty("site.url");
            capabilities = PropertyLoader.loadCapabilities();
        }
    };

    @Rule
    public ExternalResource webDriver = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            //WebDriverPool dp = new ThreadLocalSingleWebDriverPool();
            //driver = dp.getDriver(gridHubUrl, capabilities);
            System.setProperty("webdriver.chrome.driver", "/home/izoomko/wrk/3grade/testing/chromedriver");
            if (driver == null) {
                driver = new ChromeDriver();
            }
        };
    };
}
