package co.quipux.utils;

public enum Keyboard {

    KEY_0("0"),
    KEY_1("1"),
    KEY_2("2"),
    KEY_3("3"),
    KEY_4("4"),
    KEY_5("5"),
    KEY_6("6"),
    KEY_7("7"),
    KEY_8("8"),
    KEY_9("9"),


    KEY_Q("q"),
    KEY_W("w"),
    KEY_E("e"),
    KEY_R("r"),
    KEY_T("t"),
    KEY_Y("y"),
    KEY_U("u"),
    KEY_I("i"),
    KEY_O("o"),
    KEY_P("p"),
    KEY_A("a"),
    KEY_S("s"),
    KEY_D("d"),
    KEY_F("f"),
    KEY_G("g"),
    KEY_H("h"),
    KEY_J("j"),
    KEY_K("k"),
    KEY_L("l"),
    KEY_Z("z"),
    KEY_X("x"),
    KEY_C("c"),
    KEY_V("v"),
    KEY_B("b"),
    KEY_N("n"),
    KEY_M("m"),
    KEY_SPACE("Espacio");

    private final String letter;

    private Keyboard(String letter) {
        this.letter = letter;
    }


    public String getLetter() {
        return this.letter;
    }

}