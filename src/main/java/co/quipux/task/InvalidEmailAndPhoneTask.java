package co.quipux.task;

import co.quipux.iteractions.PerformWait;
import co.quipux.models.CreateAccountData;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static co.quipux.ui.CreateAccountPage.*;
import static co.quipux.ui.HomePage.BUTTON_CREAR_CUENTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InvalidEmailAndPhoneTask extends BaseConfig implements Task {

    private List<CreateAccountData> data;

    public InvalidEmailAndPhoneTask(List<CreateAccountData> data) {
        super(InvalidEmailAndPhoneTask.class);
        this.data = data;
    }

    public static InvalidEmailAndPhoneTask invalidEmailAndPhoneTask(List<CreateAccountData> data) {
        return instrumented(InvalidEmailAndPhoneTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       //Keys.chord(Keys.F5);
        actor.attemptsTo(
                Enter.theValue(data.get(0).getCelular()).into(INPUT_CELULAR),
                Enter.theValue(data.get(0).getEmail()).into(INPUT_EMAIL),
                Click.on(BUTTON_REGISTRARME),
                PerformWait.wait(3)
        );
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}