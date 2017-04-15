package functional.newPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cezar on 4/15/17.
 */
public class VKLoginPage extends Page {
    public static String URL = "http://oauth.vk.com/authorize?display=mobile&response_type=code&client_id=3295164&redirect_uri=http%3A%2F%2Fhhid.ru%2Foauth2%2Fcode&scope=4194304&state=token%3DUW9Rqq8c27f4HP8r4ohifAZpYYdy5fxOM6pHH225%2196i7WwkTN7bllAKhX5LwisWIedn1uXqid%21Wm_1QlqptRUfa9e4c%26reg%3Dhttp%253A%252F%252Fspb.hh.ru%252Faccount%252Fconnect%252Fregister%26fail%3Dhttp%253A%252F%252Fspb.hh.ru%252Faccount%252Fconnect%252Fresult%253Ffail%253Dtrue%26login%3Dhttp%253A%252F%252Fspb.hh.ru%252Faccount%252Fconnect%252Fresult%26system%3DVK%26mergeOAuth%3Dfalse";
    //from GuestPage

    public VKLoginPage(WebDriver driver) {
        super(driver);
    }
}
