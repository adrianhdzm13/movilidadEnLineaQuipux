package co.quipux.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidateFieldsPage extends PageObject {

    public static final Target ALERT_VALIDATION =  Target.the("Mensaje de validación ").located(By.cssSelector("#emailRegistro-error"));
    public static final Target ALERT_VALIDATION_EMAIL =  Target.the("Mensaje de validación ").located(By.id("emailRegistro-error"));

}
