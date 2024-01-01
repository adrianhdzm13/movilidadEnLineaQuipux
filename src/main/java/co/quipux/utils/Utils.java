package co.quipux.utils;

import co.quipux.ui.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static java.nio.charset.StandardCharsets.UTF_8;


public class Utils {

    public static String convertUtf8(String text) {
        return new String(text.getBytes(), UTF_8);
    }
    @Managed
    static
    WebDriver driver;
    public static final String ACTOR = "QuipuxTest";
    public static final Actor QUIPUX_ACTOR = Actor.named(ACTOR);
    public static final String URL = "https://digital.quipux.com/portal-movilidad/#/inicio-login";
    public static final String URL_HOME_PUBLIC = "https://digital.quipux.com/portal-movilidad/#/public";


    public static void setUpActorWithBrowserTheWebManger(){
        WebDriverManager.chromedriver().setup();
        QUIPUX_ACTOR.can(BrowseTheWeb.with(WebDriverManager.getInstance(DriverManagerType.CHROME).create()));
    }

    public static void setUpActorWithBrowserTheWebDriver(){
        QUIPUX_ACTOR.can(BrowseTheWeb.with(driver));
    }

 


}
