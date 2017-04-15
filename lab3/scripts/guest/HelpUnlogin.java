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

public class HelpUnlogin {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testHelpUnlogin() throws Exception {
		selenium.open("/");
		selenium.click("//li[5]/div[2]/div/ul/li[2]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//input[@name='sendTo'])[3]");
		selenium.click("xpath=(//input[@name='sendTo'])[2]");
		selenium.click("xpath=(//input[@name='sendTo'])[5]");
		selenium.click("xpath=(//input[@name='sendTo'])[4]");
		selenium.click("//input[@name='sendTo']");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
