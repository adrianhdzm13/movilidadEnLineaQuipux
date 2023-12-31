package co.quipux.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateAccountPage extends PageObject {

    public static final Target LIST_TIPODOCUMENT =  Target.the("DESPLEGAR LISTA TIPO DOCUMENTO").located(By.cssSelector("b[role='presentation']"));
    public static final Target INPUT_NUMERO_DOCUMENTO =  Target.the("Input documento").located(By.id("numeroDocumento"));
    public static final Target INPUT_NOMBRE =  Target.the("Input nombre").located(By.id("nombre"));
    public static final Target INPUT_APELLIDOS =  Target.the("Input apellidos").located(By.id("apellido"));
    public static final Target LIST_PAIS =  Target.the("Desplegar país").located(By.xpath("//div[@title='Colombia: +57']//div[@class='iti__flag iti__co']"));
    public static final Target INPUT_CELULAR =  Target.the("Input phone").located(By.id("phone"));
    public static final Target INPUT_EMAIL =  Target.the("Input email").located(By.id("emailRegistro"));
    public static final Target INPUT_CONFIRM_EMAIL =  Target.the("Input  confirmar email").located(By.id("confirmEmailRegistro"));
    public static final Target INPUT_PASSWORD =  Target.the("Input  contraseña").located(By.id("password"));
    public static final Target INPUT_CONFIRM_PASSWORD =  Target.the("Input  confirmar contraseña").located(By.id("confirmPasswordRegistro"));
    public static final Target BUTTON_REGISTRARME =  Target.the("Input  confirmar contraseña").located(By.xpath("//button[contains(text(),'Registrarme')]"));

}
