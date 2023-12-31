package co.quipux.iteractions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class PerformWait implements Interaction {
    private int time;
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformWait.class);

    public PerformWait(int time) {
        this.time = time;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            LOGGER.error("Error running time",e);
            Thread.currentThread().interrupt();
        }

    }
    public static PerformWait wait(int time){
        return Tasks.instrumented(PerformWait.class,time);
    }
}