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

public class searchUnLogin {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testSearchUnLogin() throws Exception {
		selenium.open("/");
		selenium.type("//input[@name='text']", "devops");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(text(),'DevOps Engineer')]");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
