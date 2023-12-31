package co.quipux.task;

import co.quipux.iteractions.PerformWait;
import co.quipux.models.FineProjectionData;
import co.quipux.questions.FineProjectionQuestion;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static co.quipux.ui.FineProjectionPage.BUTTON_CERRAR_PROYECCION;
import static co.quipux.ui.FineProjectionPage.SELECT_PROYECCION;
import static co.quipux.ui.HomePublicPage.*;
import static co.quipux.utils.Utils.convertUtf8;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class HomePublicTask extends BaseConfig implements Task {

    private List<FineProjectionData> data;

    public HomePublicTask(List<FineProjectionData> data) {
        super(FineProjectionTask.class);
        this.data = data;
    }

    public static HomePublicTask homePublicTaskInstrumented(List<FineProjectionData> data) {
        return instrumented(HomePublicTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_CERRAR),
                Enter.theValue(data.get(0).getIdentificacion()).into(INPUT_BUSCAR),
                Click.on(BUTTON_BUSCAR)
        );
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}
