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

public class autoUpdateAndSelectCV {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testAutoUpdateAndSelectCV() throws Exception {
		selenium.open("/applicant/resumes");
		selenium.click("//li[3]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[5]/div[2]/div[2]/div/div");
		selenium.click("//div[5]/div[2]/div[2]/div/div");
		selenium.click("//div[5]/div[2]/div[2]/div/div");
		selenium.click("//div[5]/div[2]/div[2]/div/div");
		selenium.click("//div[2]/div[2]/div/div[2]");
		selenium.click("//div[2]/div[2]/div/div[2]");
		selenium.click("//div[2]/div[2]/div/div[2]");
		selenium.click("//div[2]/div[2]/div/div[2]");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
