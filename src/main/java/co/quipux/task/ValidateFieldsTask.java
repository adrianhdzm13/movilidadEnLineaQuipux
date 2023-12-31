package co.quipux.task;

import co.quipux.iteractions.PerformWait;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.quipux.ui.CreateAccountPage.BUTTON_REGISTRARME;
import static co.quipux.ui.HomePage.BUTTON_CREAR_CUENTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateFieldsTask extends BaseConfig implements Task {


    public ValidateFieldsTask() {
        super(ValidateFieldsTask.class);
    }

    public static ValidateFieldsTask validateFieldsTaskInstrumented() {
        return instrumented(ValidateFieldsTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_CREAR_CUENTA),
                Click.on(BUTTON_REGISTRARME),
                PerformWait.wait(5)
        );
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}
