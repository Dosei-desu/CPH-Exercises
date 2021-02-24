/**
 * @Author August (modified by Kris)
 */
public class ConsoleColour {
    //Reset
    public static final String reset = "\033[0m";  // Text Reset

    //Regular colours
    public static final String black = "\033[0;30m";   // BLACK
    public static final String red = "\033[0;31m";     // RED
    public static final String green = "\033[0;32m";   // GREEN
    public static final String yellow = "\033[0;33m";  // YELLOW
    public static final String blue = "\033[0;34m";    // BLUE
    public static final String purple = "\033[0;35m";  // PURPLE
    public static final String cyan = "\033[0;36m";    // CYAN
    public static final String white = "\033[0;37m";   // WHITE

    //Bold
    public static final String blackB = "\033[1;30m";  // BLACK Bold
    public static final String redB = "\033[1;31m";    // RED Bold
    public static final String greenB = "\033[1;32m";  // GREEN Bold
    public static final String yellowB = "\033[1;33m"; // YELLOW Bold
    public static final String blueB = "\033[1;34m";   // BLUE Bold
    public static final String purpleB = "\033[1;35m"; // PURPLE Bold
    public static final String cyanB = "\033[1;36m";   // CYAN Bold
    public static final String whiteB = "\033[1;37m";  // WHITE Bold

    //Underline
    public static final String blackU = "\033[4;30m";  // BLACK Underline
    public static final String redU = "\033[4;31m";    // RED Underline
    public static final String greenU = "\033[4;32m";  // GREEN Underline
    public static final String yellowU = "\033[4;33m"; // YELLOW Underline
    public static final String blueU = "\033[4;34m";   // BLUE Underline
    public static final String purpleU = "\033[4;35m"; // PURPLE Underline
    public static final String cyanU = "\033[4;36m";   // CYAN Underline
    public static final String whiteU = "\033[4;37m";  // WHITE Underline

    //Background colours
    public static final String blackBG = "\u001B[40m";  // BLACK Background
    public static final String redBG = "\u001B[41m";    // RED Background
    public static final String greenBG = "\u001B[42m";  // GREEN Background
    public static final String yellowBG = "\u001B[43m"; // YELLOW Background
    public static final String blueBG = "\u001B[44m";   // BLUE Background
    public static final String purpleBG = "\u001B[45m"; // PURPLE Background
    public static final String cyanBG = "\u001B[46m";   // CYAN Background
    public static final String whiteBG = "\u001B[47m";  // WHITE Background
}

//link to ANSI colour code table:
//https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
