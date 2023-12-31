package co.quipux.task;

import co.quipux.iteractions.PerformWait;
import co.quipux.models.CreateAccountData;
import co.quipux.models.LoginData;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static co.quipux.ui.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask extends BaseConfig implements Task {

    private List<LoginData> data;

    public LoginTask(List<LoginData> data) {
        super(LoginTask.class);
        this.data = data;
    }

    public static LoginTask loginTaskInstrumented(List<LoginData> data) {
        return instrumented(LoginTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.get(0).getEmail()).into(INPUT_USER),
                Enter.theValue(data.get(0).getPassword()).into(INPUT_PASS_USER),
                Click.on(BUTTON_LOGIN),
                PerformWait.wait(3)
        );
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}