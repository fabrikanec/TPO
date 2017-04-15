package functional.roles;

import functional.newPages.*;
import org.junit.Test;

/**
 * Created by cezar on 4/15/17.
 */
public class UserRoleTest extends JUnitTestBase {
    private CreateCVPage createCVPage;
    private LoginPage loginPage;
    private CVsChekingPage cVsChekingPage;
    private OrderCVPage orderCVPage;
    private SuiteableVacantPage suiteableVacantPage;
    private ProfTestPage profTestPage;

    @Test
    public void testHelpLogin() throws Exception {
        selenium.open("/feedback");
        selenium.click("//li[6]/div[2]/div/ul/li[5]/a/span");
        selenium.selectWindow("name=8866");
        selenium.click("//a[contains(text(),'Автопоиск вакансий')]");
        selenium.waitForPageToLoad("30000");
    }

    @Test
    public void testProf() throws Exception {
        selenium.open("/search/vacancy?resume=b07da8e1ff03ba331f0039ed1f7167486b526c");
        selenium.click("//li[3]/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(@href, '/article/proforientation_promo?from=menu')]");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(@href, 'https://hh.ru/applicant/proforientation')]");
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

    @Test
    public void testOrderCV() throws Exception {
        selenium.open("/applicant/resumes");
        selenium.click("//li[3]/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(text(),'Заказать резюме')]");
        selenium.waitForPageToLoad("30000");
        selenium.click("//a[contains(text(),'Заказать резюме')]");
        selenium.waitForPageToLoad("30000");
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

    @Test
    public void testCheckCV() throws Exception {
        selenium.open("/applicant/resumes/suitable_vacancies?resume=b07da8e1ff03ba331f0039ed1f7167486b526c&published");
        selenium.click("//li[3]/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("//div[2]/div[2]/div/div/a/span");
        selenium.waitForPageToLoad("30000");
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



}
