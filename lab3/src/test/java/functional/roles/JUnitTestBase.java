package functional.roles;

import com.thoughtworks.selenium.Selenium;
import functional.util.PropertyLoader;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static functional.newPages.Page.baseUrl;

/**
 * Created by cezar on 4/15/17.
 */
public class JUnitTestBase {
    protected static Capabilities capabilities;
    protected WebDriver driver;
    protected Selenium selenium;
    @ClassRule
    public static ExternalResource webDriverProperties = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            capabilities = PropertyLoader.loadCapabilities();
        }
    };

    @Rule
    public ExternalResource webDriver = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            //WebDriverPool dp = new ThreadLocalSingleWebDriverPool();
            //driver = dp.getDriver(gridHubUrl, capabilities);
            System.setProperty("webdriver.gecko.driver", "/home/cezar/Downloads/geckodriver");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladimirg\\chromedriver.exe");
            if (driver == null) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            if (selenium == null) {
                selenium = new WebDriverBackedSelenium(driver, baseUrl);
            }
        };
    };
}
