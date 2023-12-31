package co.quipux.task;

import co.quipux.iteractions.PerformWait;
import co.quipux.models.CreateAccountData;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static co.quipux.ui.CreateAccountPage.*;
import static co.quipux.ui.HomePage.BUTTON_CREAR_CUENTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidEmailAndPhoneTask extends BaseConfig implements Task {

    private List<CreateAccountData> data;

    public ValidEmailAndPhoneTask(List<CreateAccountData> data) {
        super(ValidEmailAndPhoneTask.class);
        this.data = data;
    }

    public static ValidEmailAndPhoneTask validEmailAndPhoneNumberOkTask(List<CreateAccountData> data) {
        return instrumented(ValidEmailAndPhoneTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_CREAR_CUENTA),
                Enter.theValue(data.get(0).getCelular()).into(INPUT_CELULAR),
                Enter.theValue(data.get(0).getEmail()).into(INPUT_EMAIL),
                Click.on(BUTTON_REGISTRARME),
                PerformWait.wait(5)
        );
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}
