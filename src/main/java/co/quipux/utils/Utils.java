package co.quipux.utils;

import co.quipux.ui.HomePage;

import static java.nio.charset.StandardCharsets.UTF_8;


public class Utils {

    public static String convertUtf8(String text) {
        return new String(text.getBytes(), UTF_8);
    }

    public static final String ACTOR = "Utest user";
    HomePage homePage = new HomePage();
    public static final String URL = "https://digital.quipux.com/portal-movilidad/#/inicio-login";

}
