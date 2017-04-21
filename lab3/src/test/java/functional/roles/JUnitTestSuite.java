package functional.roles;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CommonRoleTest.class, GuestRoleTest.class, UserRoleTest.class})
public class JUnitTestSuite {

    @Rule
    public ExternalResource webDriverFactory = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            //WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
        }

        @Override
        protected void after() {
            //WebDriverFactory.dismissAll();
            JUnitTestBase.driver.close();
        }
    };
}
