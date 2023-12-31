package co.quipux.task;

import co.quipux.iteractions.PerformWait;
import co.quipux.models.CreateAccountData;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

import static co.quipux.ui.CreateAccountPage.*;
import static co.quipux.ui.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateAccountTask extends BaseConfig implements Task {

    private List<CreateAccountData> data;

    public CreateAccountTask(List<CreateAccountData> data) {
        super(CreateAccountTask.class);
        this.data = data;
    }

    public static CreateAccountTask crearCuentaTaskInstrumented(List<CreateAccountData> data) {
        return instrumented(CreateAccountTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target SELECT_TIPODOCUMENT =  Target.the("SELECCIONAR UN ELEMENTO DE LISTA TIPO DOCUMENTO").located(By.xpath("//li[@class='select2-results__option' and contains(text(), '"+data.get(0).getTipo()+"')]"));
        Target SELECT_PAIS =  Target.the("SELECCIONAR EL PAIS DE LA LISTA").located(By.xpath("(//ul[@id='iti-1__country-listbox']//span[contains(text(), '"+data.get(0).getPais()+"')])[1]"));
        actor.attemptsTo(
                Click.on(BUTTON_CREAR_CUENTA),
                Click.on(LIST_TIPODOCUMENT),
                Click.on(SELECT_TIPODOCUMENT),
                Enter.theValue(data.get(0).getNumeroDocumento()).into(INPUT_NUMERO_DOCUMENTO),
                Enter.theValue(data.get(0).getNombres()).into(INPUT_NOMBRE),
                Enter.theValue(data.get(0).getApellidos()).into(INPUT_APELLIDOS),
                Click.on(LIST_PAIS),
                Click.on(SELECT_PAIS),
                Enter.theValue(data.get(0).getCelular()).into(INPUT_CELULAR),
                Enter.theValue(data.get(0).getEmail()).into(INPUT_EMAIL),
                Enter.theValue(data.get(0).getConfirmarEmail()).into(INPUT_CONFIRM_EMAIL),
                Enter.theValue(data.get(0).getPassword()).into(INPUT_PASSWORD),
                Enter.theValue(data.get(0).getConfirmarPassword()).into(INPUT_CONFIRM_PASSWORD),
                Click.on(BUTTON_REGISTRARME),
                PerformWait.wait(10)
        );
        BaseConfig.log.info("Execution of tasks and actions ["+this.getClass().getName()+"]");
    }
}
