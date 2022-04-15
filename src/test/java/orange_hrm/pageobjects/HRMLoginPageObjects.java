package orange_hrm.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/")
public class HRMLoginPageObjects extends PageObject {
    public static Target USERNAME_FIELD = Target.the("username field")
            .locatedBy("#txtUsername");
    public static Target PASSWORD_FIELD = Target.the("password field")
            .locatedBy("#txtPassword");
    public static Target LOGIN_BUTTON = Target.the("Log in button")
            .locatedBy("#btnLogin");
}
