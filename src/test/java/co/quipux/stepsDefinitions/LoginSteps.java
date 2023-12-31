package co.quipux.stepsDefinitions;

import co.quipux.models.CreateAccountData;
import co.quipux.models.LoginData;
import co.quipux.questions.LoginQuestion;
import co.quipux.questions.ValidateFieldsQuestion;
import co.quipux.task.CreateAccountTask;
import co.quipux.task.LoginTask;
import co.quipux.utils.BaseConfig;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static co.quipux.utils.Utils.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginSteps extends BaseConfig {

    public LoginSteps() {
        super(LoginSteps.class);
    }

    @DataTableType
    public LoginData convert(Map<String,String> ent) {
        BaseConfig.log.info("Dataset registration ["+this.getClass().getName()+"]");
        return new LoginData(
                ent.get("email"),
                ent.get("password")
        );
    }

    @Before
    public void SetTheStage() {
        BaseConfig.log.info("Application start ["+this.getClass().getName()+"]");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }

    @When("the user enters a username and password")
    public void theUserEntersAUsernameAndPassword(List<LoginData> data) {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.loginTaskInstrumented(data)
        );
    }

    @Then("the user should be redirected to the main dashboard {string}")
    public void theUserShouldBeRedirectedToTheMainDashboard(String text) {
        theActorInTheSpotlight().should(
                seeThat(
                        "Registrado",
                         LoginQuestion.messageLogin(),
                        equalTo(convertUtf8(text))
                )
        );
    }
}
