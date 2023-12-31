package co.quipux.iteractions;


import co.quipux.utils.Keyboard;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;



public class Write implements Interaction {

    private  String text;
    private Target target;

    public Write(String text) {
        this.text = text;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        char letter;


        for (int i = 0; i < text.length(); i++) {

            letter = text.charAt(i);
            actor.attemptsTo(Enter.theValue(letter(letter)).into(target));

        }

    }
    public Write in(Target target) {
        this.target = target;
        return this;
    }

    public static Write theText(String text) {
        return Tasks.instrumented(Write.class, text);
    }

    private String letter(char a) {

        String letter = "KEY_";


        if (a == ' ') {
            letter += "SPACE";
        } else {
            letter += String.valueOf(a).toUpperCase();

        }

        return  Keyboard.valueOf(letter).getLetter();
    }

}