import java.util.regex.Pattern;

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
    public static final String MANUAL = "Here's how you can use me :3 \n"
            + "\tTODO description - adding a generic task into your todolist\n"
            + "\tDEADLINE description /by DD/MM/YYYY HH - adding a task with a due date and time\n"
            + "\tEVENT description /from DD/MM/YYYY HH /to DD/MM/YYYY HH - adding an activity with start and end time\n"
            + "\tMARK index - mark the task with given index as done\n"
            + "\tUNMARKED index - mark the task with given index as not done\n"
            + "\tFIND keyword - search for tasks with relevant keywords\n"
            + "\tLIST - list all the task in the todolist\n"
            + "\tDELETE index - remove task from the todolist";

    /**
     * Greet the user when starting the program.
     */
    public static void greet() {
        System.out.println("Hello from\n" + LOGO);
        linebreak();
        System.out.println(MANUAL);
        linebreak();
        System.out.println("What can I do for you?\n(Input \"bye\" to exit)");
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
