package co.quipux.questions;

import co.quipux.ui.ValidateFieldsPage;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class InvalidEmailAndPhoneQuestion extends BaseConfig {

    public InvalidEmailAndPhoneQuestion() {
        super(InvalidEmailAndPhoneQuestion.class);
    }

    public static Question<String> messageInvalidEmailField() {
        log.info("Message validation email fields [" + InvalidEmailAndPhoneQuestion.class.getName() + "]");
        return actor -> TextContent.of(ValidateFieldsPage.ALERT_VALIDATION_EMAIL).
                viewedBy(actor).asString().toString().trim();
    }
}