package co.quipux.stepsDefinitions;

import co.quipux.models.FineProjectionData;
import co.quipux.models.LoginData;
import co.quipux.questions.FineProjectionQuestion;
import co.quipux.questions.LoginQuestion;
import co.quipux.task.FineProjectionTask;
import co.quipux.task.HomePublicTask;
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

public class FineProjectionSteps extends BaseConfig {

    public FineProjectionSteps() {
        super(FineProjectionSteps.class);
    }

    @DataTableType
    public FineProjectionData convert(Map<String,String> ent) {
        BaseConfig.log.info("Dataset registration ["+this.getClass().getName()+"]");
        return new FineProjectionData(
                ent.get("identificacion")
        );
    }

    @Before
    public void SetTheStage() {
        BaseConfig.log.info("Application start ["+this.getClass().getName()+"]");
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("the user enters a document number on the public home page")
    public void theUserEntersADocumentNumberOnThePublicHomePage(List<FineProjectionData> data) {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL_HOME_PUBLIC));
        theActorInTheSpotlight().attemptsTo(
                HomePublicTask.homePublicTaskInstrumented(data)
        );
    }
    @When("they view and close the fine projection")
    public void theyViewAndCloseTheFineProjection() {
        theActorInTheSpotlight().attemptsTo(
                FineProjectionTask.fineProjectionTaskInstrumented()
        );
    }
    @Then("the fine projection should hide {string}")
    public void theFineProjectionShouldHide(String texto) {
        theActorInTheSpotlight().should(
                seeThat(
                        "Multas",
                        FineProjectionQuestion.messageMultas(),
                        equalTo(convertUtf8(texto))
                )
        );

    }

}
