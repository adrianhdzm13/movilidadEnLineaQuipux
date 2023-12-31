package co.quipux.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target INPUT_USER =  Target.the("Input ingresar usuario o correo").located(By.id("usuario"));
    public static final Target INPUT_PASS_USER =  Target.the("Input ingrese contraseña").located(By.id("contrasena"));
    public static final Target BUTTON_LOGIN =  Target.the("Button iniciar sesión").located(By.xpath("//button[contains(@ng-click, 'login()')]"));
    public static final Target MESSAGE_LOGIN =  Target.the("Message (Registrado en RUNT:) inicio de sesión").located(By.xpath("//strong[contains(text(), 'Registrado en')]"));

}
