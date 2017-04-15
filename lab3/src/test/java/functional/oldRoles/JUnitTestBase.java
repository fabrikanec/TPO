package functional.oldRoles;


import functional.util.PropertyLoader;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.selenium.factory.*;

public class JUnitTestBase {

  protected static String gridHubUrl;
  public static String baseUrl;
  protected static Capabilities capabilities;


  protected WebDriver driver;

  @ClassRule
  public static ExternalResource webDriverProperties = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      baseUrl = PropertyLoader.loadProperty("site.url");
      gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
      baseUrl = PropertyLoader.loadProperty("site.url");
      gridHubUrl = PropertyLoader.loadProperty("grid.url");
      if ("".equals(gridHubUrl)) {
        gridHubUrl = null;
      }
      capabilities = PropertyLoader.loadCapabilities();
    }
  };

  @Rule
  public ExternalResource webDriver = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      //driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
      //WebDriverPool dp = new ThreadLocalSingleWebDriverPool();
      //driver = dp.getDriver(gridHubUrl, capabilities);
      System.setProperty("webdriver.gecko.driver", "/home/cezar/Downloads/geckodriver");
      driver = new FirefoxDriver();
    };
  };
}
