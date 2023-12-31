package co.quipux.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    public static final Target BUTTON_CREAR_CUENTA =  Target.the("Boton crear cuenta").located(By.xpath("(//a[contains(text(),'Crear')])[1]"));
    public static final Target TEXT_REGISTRATION = Target.the("Mensaje de regsitro de usuario").located(By.xpath("//h1[contains(text(),'Movilidad')]"));
}