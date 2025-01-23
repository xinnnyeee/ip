import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String logo = 
              " _____   _   __  _   __  ______\n"
            + "|  ___| | | / / | | / / |  __  | \n"
            + "| |___  | '/ /  | '/ /  | |  | | \n"
            + "|  ___| | |\\ \\  | |\\ \\  | |  | |\n"
            + "| |___  | | \\ \\ | | \\ \\ | |__| | \n"
            + "|_____| |_|  \\_\\|_|  \\_\\|______|";

        System.out.println("Hello from\n" + logo);
        Ekko.greet();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                Ekko.exit();
            } else {
                Ekko.echo(input);
            }
        }

    }
}
