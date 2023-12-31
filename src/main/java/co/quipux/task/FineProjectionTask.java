package co.quipux.task;

import co.quipux.iteractions.PerformWait;
import co.quipux.models.FineProjectionData;
import co.quipux.models.LoginData;
import co.quipux.questions.FineProjectionQuestion;
import co.quipux.questions.LoginQuestion;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static co.quipux.ui.FineProjectionPage.*;
import static co.quipux.ui.HomePublicPage.*;
import static co.quipux.utils.Utils.convertUtf8;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FineProjectionTask extends BaseConfig implements Task {

    public FineProjectionTask() {
        super(FineProjectionTask.class);
    }

    public static FineProjectionTask fineProjectionTaskInstrumented() {
        return instrumented(FineProjectionTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PerformWait.wait(3),
                Click.on(SELECT_PROYECCION),
                PerformWait.wait(1)
        );
        theActorInTheSpotlight().should(
                seeThat(
                        "Fecha",
                        FineProjectionQuestion.messageProyeccion(),
                        equalTo(convertUtf8("Fecha mandamiento"))
                )
        );
        actor.attemptsTo(
                Click.on(BUTTON_CERRAR_PROYECCION)
        );
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}
