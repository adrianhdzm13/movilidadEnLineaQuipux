package co.quipux.stepsDefinitions;

import co.quipux.models.CreateAccountData;
import co.quipux.questions.CreateAccountSuccesfulQuestion;
import co.quipux.task.CreateAccountTask;
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

public class CreateAccountSteps extends BaseConfig {

    public CreateAccountSteps() {
        super(CreateAccountSteps.class);
    }

    @DataTableType
    public CreateAccountData convert(Map<String,String> ent) {
        BaseConfig.log.info("Dataset registration ["+this.getClass().getName()+"]");
        return new CreateAccountData(
                ent.get("tipo"),
                ent.get("numeroDocumento"),
                ent.get("nombres"),
                ent.get("apellidos"),
                ent.get("pais"),
                ent.get("celular"),
                ent.get("email"),
                ent.get("confirmarEmail"),
                ent.get("password"),
                ent.get("confirmarPassword")
        );
    }

    @Before
    public void SetTheStage() {
        BaseConfig.log.info("Application start ["+this.getClass().getName()+"]");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that I am on the registration page")
    public void thatIAmOnTheRegistrationPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }
    @When("the required data is entered and the registration form is submitted")
    public void theRequiredDataIsEnteredAndTheRegistrationFormIsSubmitted(List<CreateAccountData> data) {
        theActorInTheSpotlight().attemptsTo(
                CreateAccountTask.crearCuentaTaskInstrumented(data)
        );
    }
    @Then("I should see the successful registration message")
    public void iShouldSeeTheSuccessfulRegistrationMessage() {
        theActorInTheSpotlight().should(
                seeThat(
                        "Movilidad en Línea",
                        CreateAccountSuccesfulQuestion.titleOfRegistrationSuccesful(),
                        equalTo(convertUtf8("Movilidad en Línea"))
                )
        );
    }

}
