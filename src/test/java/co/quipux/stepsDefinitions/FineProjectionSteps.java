package co.quipux.stepsDefinitions;

import co.quipux.models.FineProjectionData;
import co.quipux.models.LoginData;
import co.quipux.questions.FineProjectionQuestion;
import co.quipux.questions.LoginQuestion;
import co.quipux.task.FineProjectionTask;
import co.quipux.task.HomePublicTask;
import co.quipux.task.LoginTask;
import co.quipux.task.NoFineProjectionTask;
import co.quipux.utils.BaseConfig;
import co.quipux.utils.ReadExcelFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;

import java.util.Collections;

import java.util.Map;

import static co.quipux.utils.Utils.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class FineProjectionSteps extends BaseConfig {


    public FineProjectionSteps() {
        super(FineProjectionSteps.class);
    }

    @DataTableType
    public FineProjectionData convert(Map<String, String> ent) {
        BaseConfig.log.info("Dataset registration [" + this.getClass().getName() + "]");
        return new FineProjectionData(
                ent.get("identificacion")
        );
    }

    @Before
    public void SetTheStage(Scenario scenario) throws Exception {
        this.scenarioName = scenario.getName();
        this.scenarioType = scenario.getSourceTagNames().iterator().next();
        startRecording();
        BaseConfig.log.info("Application start [" + this.getClass().getName() + "]");
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("the user enters a document {string} number on the public home page")
    public void theUserEntersADocumentNumberOnThePublicHomePage(String data) throws IOException {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL_HOME_PUBLIC));
        readExcelData("fineProjection", scenarioName);

        for (int i = 0; i < ReadExcelFile.valuesExcel.size(); i += 1) {
            FineProjectionData fineProjectionData = new FineProjectionData(ReadExcelFile.valuesExcel.get(i));
            theActorInTheSpotlight().attemptsTo(
                    HomePublicTask.homePublicTaskInstrumented(Collections.singletonList(fineProjectionData))
            );
            ///ReadExcelFile.valuesExcel.remove(0);
            ReadExcelFile.valuesExcel.subList(0, 1).clear();
        }

    }

    @When("they view and close the fine projection")
    public void theyViewAndCloseTheFineProjection() {
        theActorInTheSpotlight().attemptsTo(
                FineProjectionTask.fineProjectionTaskInstrumented()
        );
    }

    @Then("the fine projection should hide {string}")
    public void theFineProjectionShouldHide(String texto) {
        theActorInTheSpotlight().attemptsTo(
                NoFineProjectionTask.noFineProjectionTaskInstrumented(texto)
        );

    }

    @After
    public void closeRecordingNameScenarioLogin() throws Exception {
        closeRecording();

    }

}
