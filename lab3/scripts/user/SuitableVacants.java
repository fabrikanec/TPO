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

public class SuitableVacants {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testSuitableVacants() throws Exception {
		selenium.open("/resume/b07da8e1ff03ba331f0039ed1f7167486b526c");
		selenium.click("//li[3]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[2]/div[2]/div/div/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'подходящих вакансий к резюме')])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(text(),'Junior C# Developer')]");
		selenium.selectWindow("name=64504");
		selenium.click("//div[@id='hypercontext']/index/div[3]/div/div/span");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
