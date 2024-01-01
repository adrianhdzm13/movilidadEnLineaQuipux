package co.quipux.stepsDefinitions;
import co.quipux.models.LoginData;
import co.quipux.questions.LoginQuestion;
import co.quipux.task.LoginTask;
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
    public void SetTheStage(Scenario scenario) throws Exception {
        this.scenarioName = scenario.getName();
        this.scenarioType = scenario.getSourceTagNames().iterator().next();
        startRecording();
        BaseConfig.log.info("Application start ["+this.getClass().getName()+"]");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }


    @When("the user enters a username and password")
    public void theUserEntersAUsernameAndPassword() throws IOException {
        readExcelData("login", scenarioName);
        for (int i = 0; i < ReadExcelFile.valuesExcel.size(); i += 2) {
            LoginData loginData = new LoginData( ReadExcelFile.valuesExcel.get(i),  ReadExcelFile.valuesExcel.get(i + 1));
            theActorInTheSpotlight().attemptsTo(
                    LoginTask.loginTaskInstrumented(Collections.singletonList(loginData))
            );
            ///ReadExcelFile.valuesExcel.remove(0);
            ReadExcelFile.valuesExcel.subList(0, 2).clear();
        }

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

    @After
    public void closeRecordingNameScenarioLogin() throws Exception {
        closeRecording();

    }
}
