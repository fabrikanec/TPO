package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class courses {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testCourses() throws Exception {
		selenium.open("/");
		selenium.waitForPopUp("", "30000");
		selenium.selectWindow("name=45459");
		selenium.click("//div[@id='BaseApp-react-component-0']/div/div[2]/div/div/div/div/div/ul/li[6]/a/div[2]");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
