package co.quipux.questions;

import co.quipux.ui.HomePage;
import co.quipux.ui.ValidateFieldsPage;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class ValidateFieldsQuestions extends BaseConfig {

    public ValidateFieldsQuestions() {
        super(ValidateFieldsQuestions.class);
    }

    public static Question<String> messageValidationFields() {
        log.info("Message validation fields ["+ ValidateFieldsQuestions.class.getName()+"]");
        return actor -> TextContent.of(ValidateFieldsPage.ALERT_VALIDATION).
                viewedBy(actor).asString().toString().trim();
    }

}
