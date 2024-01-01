package co.quipux.stepsDefinitions;

import co.quipux.models.CreateAccountData;
import co.quipux.models.LoginData;
import co.quipux.questions.CreateAccountSuccesfulQuestion;
import co.quipux.questions.ValidateFieldsQuestion;
import co.quipux.task.*;
import co.quipux.utils.BaseConfig;
import co.quipux.utils.ReadExcelFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
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
    public void SetTheStage(Scenario scenario) throws Exception {
        this.scenarioName = scenario.getName();
        this.scenarioType = scenario.getSourceTagNames().iterator().next();
        startRecording();
        BaseConfig.log.info("Application start ["+this.getClass().getName()+"]");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that I am on the registration page")
    public void thatIAmOnTheRegistrationPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }
    @When("the required data is entered and the registration form is submitted")
    public void theRequiredDataIsEnteredAndTheRegistrationFormIsSubmitted() throws IOException {

        readExcelData("createAccount", scenarioName);

        for (int i = 0; i < ReadExcelFile.valuesExcel.size(); i += 10) {
            CreateAccountData createAccountData = new CreateAccountData( ReadExcelFile.valuesExcel.get(i),  ReadExcelFile.valuesExcel.get(i + 1), ReadExcelFile.valuesExcel.get(i + 2), ReadExcelFile.valuesExcel.get(i + 3), ReadExcelFile.valuesExcel.get(i + 4), ReadExcelFile.valuesExcel.get(i + 5), ReadExcelFile.valuesExcel.get(i + 6),
                    ReadExcelFile.valuesExcel.get(i + 7), ReadExcelFile.valuesExcel.get(i + 8), ReadExcelFile.valuesExcel.get(i + 9));
            theActorInTheSpotlight().attemptsTo(
                    CreateAccountTask.crearCuentaTaskInstrumented(Collections.singletonList(createAccountData))
            );
            ReadExcelFile.valuesExcel.subList(0, 10).clear();

        }

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

    //@VALIDATE_FIELDS
    @Given("I am on the create account page")
    public void iAmOnTheCreateAccountPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }

    @When("I enter incomplete information and submit the form")
    public void iEnterIncompleteInformationAndSubmitTheForm() {
        theActorInTheSpotlight().attemptsTo(
                ValidateFieldsTask.validateFieldsTaskInstrumented()
        );
    }

    @Then("error messages for the required fields should be displayed {string}")
    public void errorMessagesForTheRequiredFieldsShouldBeDisplayed(String text) {
        theActorInTheSpotlight().should(
                seeThat(
                        "Este campo es obligatorio",
                        ValidateFieldsQuestion.messageValidationFields(),
                        equalTo(convertUtf8(text))
                )
        );
    }

 //@VALIDATE_EMAIL
    @When("I enter valid email and phone number")
    public void iEnterValidEmailAndPhoneNumber(List<CreateAccountData> data) {
        theActorInTheSpotlight().attemptsTo(
                ValidEmailAndPhoneTask.validEmailAndPhoneNumberOkTask(data)
        );
    }

    @And("I enter invalid email and phone number")
    public void iEnterInvalidEmailAndPhoneNumber(List<CreateAccountData> data) {
        theActorInTheSpotlight().attemptsTo(
                InvalidEmailAndPhoneTask.invalidEmailAndPhoneTask(data)
        );
    }

    @Then("error messages should be displayed for both fields")
    public void errorMessagesShouldBeDisplayedForBothFields() {
        theActorInTheSpotlight().should(
                seeThat(
                        "Escriba una dirección de correo válida.",
                        ValidateFieldsQuestion.messageValidationFields(),
                        equalTo(convertUtf8("Escriba una dirección de correo válida."))
                )
        );
    }

    @After
    public void closeRecordingNameScenarioLogin() throws Exception {
        closeRecording();
    }
}
