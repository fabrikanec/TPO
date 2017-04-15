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

public class registration {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://spb.hh.ru/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testRegistration() throws Exception {
		selenium.open("/search/vacancy?text=devops&area=2");
		selenium.click("link=Соискателя");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=firstName", "Ivan");
		selenium.type("name=lastName", "Lavrov");
		selenium.type("name=login", "monnort@gmail.com");
		selenium.type("name=password", "kukukupopo");
		selenium.click("//input[@value='Зарегистрироваться']");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=gender.string");
		selenium.type("name=phone.formatted", "+79996666666");
		selenium.select("//span/select", "label=1");
		selenium.select("css=select.bloko-select.HH-Resume-Birthday-Month", "label=января");
		selenium.select("css=select.bloko-select.HH-Resume-Birthday-Year", "label=2003");
		selenium.click("name=primaryEducation.name");
		selenium.type("name=primaryEducation.name", "Универси");
		selenium.click("css=div.primary-edu-suggestion");
		selenium.type("name=primaryEducation.organization", "КТиУ");
		selenium.click("name=primaryEducation.result");
		selenium.type("name=primaryEducation.result", "Погромист");
		selenium.select("name=primaryEducation.year", "label=2011");
		selenium.click("css=option[value=\"2011\"]");
		selenium.click("css=span.bloko-link-switch.HH-Resume-Form-Info-Link-Template");
		selenium.click("css=span.bloko-link-switch.HH-Resume-Form-Info-Link-Template");
		selenium.click("css=div.bloko-form-row > label.bloko-radio > input[name=\"experienceChanger\"]");
		selenium.click("css=div.bloko-form-row > label.bloko-radio > span.bloko-radio__text");
		selenium.click("xpath=(//input[@name='specialization.string'])[2]");
		selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div/div[2]/label/span");
		selenium.click("xpath=(//input[@name='specialization.string'])[13]");
		selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div[2]/div[3]/label/span");
		selenium.click("xpath=(//input[@name='specialization.string'])[11]");
		selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div[2]/div/label/span");
		selenium.click("xpath=(//input[@name='specialization.string'])[2]");
		selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div/div[2]/label/span");
		selenium.click("xpath=(//input[@name='specialization.string'])[6]");
		selenium.click("//div[@id='positionBlock']/div[3]/div[3]/div[3]/div[2]/div/div[6]/label/span");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
