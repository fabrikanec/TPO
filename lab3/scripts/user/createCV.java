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

public class createCV {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testCreateCV() throws Exception {
		selenium.open("/applicant/resumes");
		selenium.click("//li[3]/div[2]/div/ul/li/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(@href, '/applicant/resumes/edit/personal?resume=')]");
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='middleName.string']", "Kok");
		selenium.select("//span/select", "label=1");
		selenium.select("//span[2]/select", "label=января");
		selenium.select("//span[3]/select", "label=2003");
		selenium.click("//option[@value='2003']");
		selenium.click("//input[@name='gender.string']");
		selenium.type("xpath=(//input[@value=''])[5]", "Ва");
		selenium.click("//div[7]/ul/li");
		selenium.click("//input[@value='Сохранить']");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[4]/div/div/div/div/div/div/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='title.string']", "Учредитель");
		selenium.click("//input[@type='checkbox']");
		selenium.click("//label/span");
		selenium.click("xpath=(//input[@name='specialization.string'])[6]");
		selenium.click("//div[6]/label/span");
		selenium.type("//input[@name='title.string']", "Учредительство");
		selenium.click("//input[@value='Сохранить']");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[4]/div/div/div/div/div[2]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.type("xpath=(//input[@value=''])[4]", "Опыт");
		selenium.click("//div[7]/ul/li");
		selenium.click("xpath=(//button[@type='button'])[19]");
		selenium.click("//div[2]/div/form/div");
		selenium.type("//textarea[@name='skills.string']", "Умный");
		selenium.click("//input[@value='Сохранить']");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[contains(@href, '/applicant/resumes/edit/contacts?resume=b07da8e1ff03ba331f0039ed1f7167486b526c')]");
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='phone.formatted']", "+79996666666");
		selenium.click("//input[@value='Сохранить']");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[5]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='primaryEducation.name']", "МГУ");
		selenium.type("//input[@name='primaryEducation.organization']", "КТиу");
		selenium.type("//input[@name='primaryEducation.result']", "Учредитель");
		selenium.select("//select[@name='primaryEducation.year']", "label=2010");
		selenium.click("//input[@value='Сохранить']");
		selenium.waitForPageToLoad("30000");
		selenium.click("//form/span");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
