package functional.util;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by cezar on 4/21/17.
 */
public class WebDriverFactory {
    private static WebDriver firefox;
    private static WebDriver chrome;

    private WebDriverFactory() {
    }

    public static WebDriver getChromeDriver() {
        if (chrome == null) {
            chrome = new ChromeDriver();
            return chrome;
        } else {
            return chrome;
        }
    }

    public static WebDriver getFirefoxDriver() {
        if (firefox == null) {
            new WebDriverFactory();
            firefox = new FirefoxDriver();
            return firefox;
        } else {
            return firefox;
        }
    }
}
