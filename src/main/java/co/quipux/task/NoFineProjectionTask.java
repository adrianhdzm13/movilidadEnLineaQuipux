package co.quipux.task;

import co.quipux.iteractions.ElementVisibility;
import co.quipux.iteractions.PerformWait;
import co.quipux.questions.FineProjectionQuestion;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static co.quipux.ui.CreateAccountPage.BUTTON_REGISTRARME;
import static co.quipux.ui.FineProjectionPage.MESSAGE_NO_MULTA;
import static co.quipux.ui.HomePage.BUTTON_CREAR_CUENTA;
import static co.quipux.utils.Utils.convertUtf8;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class NoFineProjectionTask extends BaseConfig implements Task {


    String text;
    public NoFineProjectionTask (String text) {
        super(NoFineProjectionTask .class);
        this.text = text;
    }

    public static NoFineProjectionTask  noFineProjectionTaskInstrumented(String text) {
        return instrumented(NoFineProjectionTask.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       boolean valueText = ElementVisibility.answeredBy(MESSAGE_NO_MULTA);
        if (valueText == true) {
            theActorInTheSpotlight().should(
                    seeThat(
                            "En este momento",
                            FineProjectionQuestion.messageNoMulta(),
                            equalTo(convertUtf8("En este momento no presenta ninguna multa o acuerdos de pago vigentes en la Secretaría de Movilidad del Distrito Especial de Ciencia, Tecnología e Innovación de Medellín."))
                    )
            );
        } else {
            theActorInTheSpotlight().should(
                    seeThat(
                            "Multas",
                            FineProjectionQuestion.messageMultas(),
                            equalTo(convertUtf8(text))
                    )
            );
        }
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}
