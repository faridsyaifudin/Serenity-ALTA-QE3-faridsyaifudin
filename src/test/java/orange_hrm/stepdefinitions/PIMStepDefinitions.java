package orange_hrm.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import orange_hrm.pageobjects.HRMPIMPageObjects;
import tasks.*;

public class PIMStepDefinitions {
    // Read - Employee -- Begin
    @And("{actor} access employee list")
    public void accessEmployee(Actor actor) throws Exception {
        actor.wasAbleTo(navigateto.theUrl("HRM Employee List"));
    }

    @And("{actor} can see new employee list result")
    public void listResult(Actor actor) throws Exception {
        actor.attemptsTo(VerifyDisplayed.element("Employee List"));
    }
    // Read Employee -- End

    // Search Employee - Begin
    @And("{actor} search for new employee")
    public void filterEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                InputText.onField("employeeName", "Farid"),
                ClickOn.button("Search")
        );
    }
    // Search Employee -- End

    // Add Employee -- Begin
    @When("{actor} add new employee with required field only")
    public void addEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.button("Add"),
                InputText.onField("firstName", "Farid"),
                InputText.onField("lastName","Fudin"),
                ClickOn.button("Save")
        );
    }

    @Then ("{actor} can see my personal Details")
    public void personalDetails(Actor actor) throws Exception {
        actor.attemptsTo(VerifyDisplayed.element("Personal Details"));
    }
    // Add Employee --End

    // Update Employee -- Begin
    @When("{actor} update new employee's middle name")
    public void updateEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.employeelist(),
                ClickOn.button("Edit"),
                InputText.onField("editMiddleName", "Syai"),
                ClickOn.button("Save")
        );
    }

    @Then("{actor} can see the personal Details has changed")
    public void updatedEmployee(Actor actor) {
        actor.attemptsTo(
                Ensure.that(HRMPIMPageObjects.EDIT_MIDDLE_NAME_FIELD).value().isEqualTo("Syai")
        );
    }
    // Update Employee -- End

    // Delete Employee -- Begin
    @And("{actor} delete new employee")
    public void deleteEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.checkbox(),
                ClickOn.button("Delete"),
                ClickOn.button("Ok")
        );
    }

    @Then("{actor} can't see deleted employee on list")
    public void deletedEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                VerifyDisplayed.element("No Employee")
        );
    }
    // Delete Employee -- End
}



















