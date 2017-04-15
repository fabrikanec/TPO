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

public class searchLogin {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testSearchLogin() throws Exception {
		selenium.open("/");
		selenium.type("css=label.login-input > input[name=\"password\"]", "kukukupopo");
		selenium.click("name=action");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=text", "devops");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=DevOps Engineer");
		selenium.selectWindow("name=57089");
		selenium.click("css=span.highlighted");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
