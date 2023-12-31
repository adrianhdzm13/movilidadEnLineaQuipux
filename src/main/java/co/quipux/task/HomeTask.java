package co.quipux.task;

import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.quipux.ui.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomeTask extends BaseConfig implements Task {


    public HomeTask() {
        super(HomeTask.class);
    }

    public static HomeTask homeTaskTaskInstrumented() {
        return instrumented(HomeTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_CREAR_CUENTA)
        );
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}
