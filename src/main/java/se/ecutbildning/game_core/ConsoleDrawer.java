package se.ecutbildning.game_core;

public class ConsoleDrawer {


    //msgs to users
    public static String wlcomMsg = "Welcome to Hangman game! A word will be picked randomly, you need to try to guess it\n a character by character.\n" +
            "If you guess wrong 6 times, you lose. if you guess the whole word in less than 6 tries, you win.";


    public static String noPersonDrawn =
            " ____\n" +
            "\n" +
            " |    \n" +
            "\n" +
            " |   \n" +
            "\n" +
            " |   \n" +
            "\n" +
            " |   \n" +
            "\n" +
            " |\n" +
            "\n" +
            "/|\\";

    public static String headDrawn =
            " ____\n" +
            "\n" +
            " |    |\n" +
            "\n" +
            " |    o\n" +
            "\n" +
            " |    \n" +
            "\n" +
            " |    \n" +
            "\n" +
            " |\n" +
            "\n" +
            "/|\\";


    public static String bodyDrawn =
            " ____\n" +
                    "\n" +
                    " |    |\n" +
                    "\n" +
                    " |    o\n" +
                    "\n" +
                    " |    | \n" +
                    "\n" +
                    " |    \n" +
                    "\n" +
                    " |\n" +
                    "\n" +
                    "/|\\";


    public static String leftArmDrawn =
            " ____\n" +
                    "\n" +
                    " |    |\n" +
                    "\n" +
                    " |    o\n" +
                    "\n" +
                    " |    |\\\n" +
                    "\n" +
                    " |     \n" +
                    "\n" +
                    " |\n" +
                    "\n" +
                    "/|\\";



    public static String rightArmDrawn =
            " ____\n" +
                    "\n" +
                    " |    |\n" +
                    "\n" +
                    " |    o\n" +
                    "\n" +
                    " |   /|\\\n" +
                    "\n" +
                    " |    \n" +
                    "\n" +
                    " |\n" +
                    "\n" +
                    "/|\\";








    public static String leftLegDrawn =
            " ____\n" +
                    "\n" +
                    " |    |\n" +
                    "\n" +
                    " |    o\n" +
                    "\n" +
                    " |   /|\\\n" +
                    "\n" +
                    " |    \\\n" +
                    "\n" +
                    " |\n" +
                    "\n" +
                    "/|\\";




    public static String fullPersonDrawn =
            " ____\n" +
                    "\n" +
                    " |    |\n" +
                    "\n" +
                    " |    o\n" +
                    "\n" +
                    " |   /|\\\n" +
                    "\n" +
                    " |    | \n" +
                    " |   / \\\n"+
                    "\n" +
                    " |\n" +
                    "\n" +
                    "/|\\\n";




    public static String fullPersonDrawn() {
        return ConsoleDrawer.fullPersonDrawn;
    }

    public static String leftLegDrawn() {
        return ConsoleDrawer.leftLegDrawn;
    }

    public static String rightArmDrawn() {
        return ConsoleDrawer.rightArmDrawn;
    }

    public static String leftArmDrawn() {
        return ConsoleDrawer.leftArmDrawn;
    }

    public static String bodyDrawn() {
        return ConsoleDrawer.bodyDrawn;
    }

    public static String headDrawn() {
        return ConsoleDrawer.headDrawn;
    }

    public static String noPersonDrawn() {
        return ConsoleDrawer.noPersonDrawn;
    }
}
