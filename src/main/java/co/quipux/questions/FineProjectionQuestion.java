package co.quipux.questions;

import co.quipux.ui.FineProjectionPage;

import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.TextContent;

import static co.quipux.utils.Utils.ACTOR;

public class FineProjectionQuestion extends BaseConfig {

    public FineProjectionQuestion() {
        super(FineProjectionQuestion.class);
    }

    public static Question<String> messageProyeccion() {
        log.info("Message Fecha mandamiento [" + FineProjectionQuestion.class.getName() + "]");
        return actor -> TextContent.of(FineProjectionPage.MESSAGE_PROYECCION).
                viewedBy(actor).asString().toString().trim();
    }

    public static Question<String> messageNoMulta() {
        log.info("Message Fecha mandamiento [" + FineProjectionQuestion.class.getName() + "]");
        return actor -> TextContent.of(FineProjectionPage.MESSAGE_NO_MULTA).
                viewedBy(actor).asString().toString().trim();
    }


    public static boolean messageNoMulta2() {
        log.info("Message Fecha mandamiento [" + FineProjectionQuestion.class.getName() + "]");

        String message = CurrentVisibility.of(FineProjectionPage.MESSAGE_NO_MULTA)
                .viewedBy(Actor.named(ACTOR)).asString().toString().trim();
        System.out.println("********************"+message);
        return !message.isEmpty();
    }


    public static Question<String> messageMultas() {
        log.info("Message Multas [" + FineProjectionQuestion.class.getName() + "]");
        return actor -> TextContent.of(FineProjectionPage.MESSAGE_MULTAS).
                viewedBy(actor).asString().toString().trim();
    }
}
