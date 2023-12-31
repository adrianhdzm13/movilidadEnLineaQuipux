package co.quipux.questions;

import co.quipux.ui.LoginPage;
import co.quipux.ui.ValidateFieldsPage;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class LoginQuestion extends BaseConfig {

    public LoginQuestion() {
        super(LoginQuestion.class);
    }

    public static Question<String> messageLogin() {
        log.info("Message login [" + LoginQuestion.class.getName() + "]");
        return actor -> TextContent.of(LoginPage.MESSAGE_LOGIN).
                viewedBy(actor).asString().toString().trim();
    }
}

