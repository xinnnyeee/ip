import java.util.Scanner;

public class Ekko {
    public static final String NAME = "EKKO";

    private static void greet() {
        System.out.printf("Hello! I'm %s \nWhat can I do for you?\n(Input 'bye' to exit)\n", NAME);
        linebreak();
    }

    private static void exit() {
        System.out.println("Bye. Hope to see you again soon! ");
        linebreak();
    }

    private static void echo(String text) {
        reply(text);
    }

    private static void linebreak() {
        System.out.println("=============================================");
    }

    private static void reply(String text) {
        System.out.printf("Ekko: %s \n",text);
        linebreak();
    }

    public static void main(String[] args) {
        String logo = 
              " _____   _   __  _   __  ______\n"
            + "|  ___| | | / / | | / / |  __  | \n"
            + "| |___  | '/ /  | '/ /  | |  | | \n"
            + "|  ___| | |\\ \\  | |\\ \\  | |  | |\n"
            + "| |___  | | \\ \\ | | \\ \\ | |__| | \n"
            + "|_____| |_|  \\_\\|_|  \\_\\|______|";

        System.out.println("Hello from\n" + logo);
        greet();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                exit();
            } else {
                echo(input);
            }
        }

    }


}
