package co.quipux.questions;

import co.quipux.ui.FineProjectionPage;

import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class FineProjectionQuestion extends BaseConfig {

    public FineProjectionQuestion() {
        super(FineProjectionQuestion.class);
    }

    public static Question<String> messageProyeccion() {
        log.info("Message Fecha mandamiento [" + FineProjectionQuestion.class.getName() + "]");
        return actor -> TextContent.of(FineProjectionPage.MESSAGE_PROYECCION).
                viewedBy(actor).asString().toString().trim();
    }
    public static Question<String> messageMultas() {
        log.info("Message Multas [" + FineProjectionQuestion.class.getName() + "]");
        return actor -> TextContent.of(FineProjectionPage.MESSAGE_MULTAS).
                viewedBy(actor).asString().toString().trim();
    }
}
