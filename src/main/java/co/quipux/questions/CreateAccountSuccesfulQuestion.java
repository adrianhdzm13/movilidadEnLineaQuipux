package co.quipux.questions;


import co.quipux.ui.HomePage;
import co.quipux.utils.BaseConfig;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class CreateAccountSuccesfulQuestion extends BaseConfig {

    public CreateAccountSuccesfulQuestion() {
        super(CreateAccountSuccesfulQuestion.class);
    }

    public static Question<String> titleOfRegistrationSuccesful() {
        log.info("Title registration succesful ["+ CreateAccountSuccesfulQuestion.class.getName()+"]");
        return actor -> TextContent.of(HomePage.TEXT_REGISTRATION).
                viewedBy(actor).asString().toString().trim();
    }

    
}

