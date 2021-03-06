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

public class failLogin {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testFailLogin() throws Exception {
		selenium.open("/vacancy/20122459?query=devops");
		selenium.type("name=username", "lol");
		selenium.type("name=password", "123");
		selenium.click("//input[@value='Войти в личный кабинет']");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
