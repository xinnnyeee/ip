/**
 * Handle user interface functionalities.
 */
public class Ekko {
    public static final String NAME = "EKKO";
    public static final String LOGO =
            " _____   _   __  _   __  ______\n"
                    + "|  ___| | | / / | | / / |  __  | \n"
                    + "| |___  | '/ /  | '/ /  | |  | | \n"
                    + "|  ___| | |\\ \\  | |\\ \\  | |  | |\n"
                    + "| |___  | | \\ \\ | | \\ \\ | |__| | \n"
                    + "|_____| |_|  \\_\\|_|  \\_\\|______|";

    /**
     * Greet the user when starting the program.
     */
    public static void greet() {
        System.out.println("Hello from\n" + LOGO);
        System.out.printf("Hello! I'm %s \nWhat can I do for you?\n(Input 'bye' to exit)\n", NAME);
        linebreak();
    }

    /**
     * Exit the program.
     */
    public static void exit() {
        reply("Bye. Hope to see you again soon! ");
        System.exit(0);
    }

    /**
     * Repeat whatever that was said by the user.
     * @param text String to repeat
     */
    public static void echo(String text) {
        reply(text);
    }

    /**
     * Print a linebreak for aesthetic reasons.
     */
    public static void linebreak() {
        System.out.println("=============================================");
    }

    /**
     * Respond to the user.
     * @param text String to respond
     */
    public static void reply(String text) {
        System.out.printf("Ekko: %s \n",text);
        linebreak();
    }

    


}
