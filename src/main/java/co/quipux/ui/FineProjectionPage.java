package co.quipux.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FineProjectionPage extends PageObject {

    public static final Target SELECT_PROYECCION =  Target.the("Seleccionar proyección").located(By.xpath("(//strong[contains(text(), 'del valor')])[1]"));
    public static final Target MESSAGE_PROYECCION =  Target.the("Message proyección").located(By.xpath("//div[@id='proyeccionMulta0']//p[contains(@class,'ng-binding')][normalize-space()='Fecha mandamiento']"));
    public static final Target MESSAGE_NO_MULTA =  Target.the("Message no multas").located(By.cssSelector("p[class='font-weight-bold ng-binding']"));
    public static final Target BUTTON_CERRAR_PROYECCION =  Target.the("Button cerrar proyección").located(By.xpath("//button[contains(@aria-expanded,'true')]//strong[contains(@class,'binding')]"));
    public static final Target MESSAGE_MULTAS =  Target.the("Mensaje Multas").located(By.xpath("//header[normalize-space()='Multas']"));


}
