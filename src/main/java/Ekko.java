
public class Ekko {
    public static final String NAME = "EKKO";
    public static final String LOGO =
            " _____   _   __  _   __  ______\n"
                    + "|  ___| | | / / | | / / |  __  | \n"
                    + "| |___  | '/ /  | '/ /  | |  | | \n"
                    + "|  ___| | |\\ \\  | |\\ \\  | |  | |\n"
                    + "| |___  | | \\ \\ | | \\ \\ | |__| | \n"
                    + "|_____| |_|  \\_\\|_|  \\_\\|______|";

    public static void greet() {
        System.out.println("Hello from\n" + LOGO);
        System.out.printf("Hello! I'm %s \nWhat can I do for you?\n(Input 'bye' to exit)\n", NAME);
        linebreak();
    }

    public static void exit() {
        reply("Bye. Hope to see you again soon! ");
        System.exit(0);
    }

    public static void echo(String text) {
        reply(text);
    }

    public static void linebreak() {
        System.out.println("=============================================");
    }

    public static void reply(String text) {
        System.out.printf("Ekko: %s \n",text);
        linebreak();
    }

    


}
