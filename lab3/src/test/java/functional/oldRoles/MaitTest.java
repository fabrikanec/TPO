package functional.oldRoles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by cezar on 4/14/17.
 */
public class MaitTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/home/cezar/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://hh.ru/");

        System.out.println(driver.getCurrentUrl());
        //driver.findElement(By.xpath());

        driver.quit();
    }
}
