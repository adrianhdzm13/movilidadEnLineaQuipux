package co.quipux.iteractions;

import co.quipux.task.FineProjectionTask;
import co.quipux.utils.Utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

import javax.swing.text.html.HTML;

import static co.quipux.ui.FineProjectionPage.MESSAGE_NO_MULTA;
import static co.quipux.utils.Utils.QUIPUX_ACTOR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ElementVisibility implements Interaction {

    public ElementVisibility() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }

    public static Boolean answeredBy(Target selector) {
        Utils.setUpActorWithBrowserTheWebDriver();
        return Visibility.of(selector).viewedBy(QUIPUX_ACTOR).resolve();
    }

}
