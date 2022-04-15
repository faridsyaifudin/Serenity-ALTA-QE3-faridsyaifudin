package fb.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import tasks.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;

public class CheckpointStepDefinitions {
    @Then("{actor} can't see my news feed")
    public void validateNewsFeed(Actor actor) {
        actor.should(seeThat(TheMenu.displayed(), not(contains("News Feed"))));
    }

    @But("{actor} see FB has disabled my account")
    public void validateAccountIsDisabled(Actor actor) {
        actor.should(
                seeThat(
                        TheMessage.displayed(), contains(
                                "Your account has been disabled"
                        )

                )
        );
        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains("checkpoint")
        );
    }
}




