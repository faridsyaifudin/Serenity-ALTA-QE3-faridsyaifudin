package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import orange_hrm.pageobjects.HRMPIMPageObjects;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyDisplayed {
    public static Performable element(String elementType) throws Exception {
        Target element;

        switch (elementType) {
            case "Employee List":
                element = HRMPIMPageObjects.RESULT_TABLE;
                break;
            case "Personal Details":
                element = HRMPIMPageObjects.PERSONAL_DETAILS;
                break;
            case "No Employee":
                element = HRMPIMPageObjects.NO_EMPLOYEE;
                break;
            default:
                throw new Exception("There is no element type: " + elementType);
        }



        WaitUntil.the(element, isVisible()).forNoMoreThan(25).seconds();

        return Task.where("{0} verify element is displayed",
                Ensure.that(element)
                        .isDisplayed()
        );
    }
}
