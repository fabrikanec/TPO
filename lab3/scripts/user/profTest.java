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

public class profTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testProf() throws Exception {
		selenium.open("/search/vacancy?resume=b07da8e1ff03ba331f0039ed1f7167486b526c");
		selenium.click("//li[3]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(@href, '/article/proforientation_promo?from=menu')]");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(@href, 'http://hh.ru/applicant/proforientation')]");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
