package co.quipux.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePublicPage extends PageObject {
    public static final Target BUTTON_CERRAR =  Target.the("Button cerrar Modal Sedes Medellín").located(By.xpath("//div[@class='modal-header border-0']//span[@aria-hidden='true']"));
    public static final Target INPUT_BUSCAR =  Target.the("Input ingresa número de identificación o placa del vehículo").located(By.xpath("(//input[@type='search' ])[1]"));
    public static final Target BUTTON_BUSCAR =  Target.the("Button buscar").located(By.cssSelector(".input-group-append.btn-search"));

}