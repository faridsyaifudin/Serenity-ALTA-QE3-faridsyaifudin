package tasks;

import fb.pageobjects.LoginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import orange_hrm.pageobjects.HRMLoginPageObjects;
import orange_hrm.pageobjects.HRMPIMPageObjects;

public class InputText {
    public static Performable onField(String fieldType, String value) throws Exception {
        Target field;

        switch (fieldType) {
            case "FB email":
                field = LoginPageObjects.EMAIL_FIELD;
                break;
            case "FB password":
                field = LoginPageObjects.PASSWORD_FIELD;
                break;
            case "HRM username":
                field = HRMLoginPageObjects.USERNAME_FIELD;
                break;
            case "HRM password":
                field = HRMLoginPageObjects.PASSWORD_FIELD;
                break;
            case "firstName":
                field = HRMPIMPageObjects.FIRST_NAME_FIELD;
                break;
            case "lastName":
                field = HRMPIMPageObjects.LAST_NAME_FIELD;
                break;
            case "editMiddleName":
                field = HRMPIMPageObjects.EDIT_MIDDLE_NAME_FIELD;
                break;
            case "employeeName":
                field = HRMPIMPageObjects.EMPLOYEE_NAME;
                break;
            default:
                throw new Exception("There is no field type: " + fieldType);
        }

        // I input: 'Admin'
        // I input: 'admin123'
        return Task.where("{0} input value: '" + value + "'",
                Enter.theValue(value)
                        .into(field)
        );
    }
}
