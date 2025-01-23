
public class Ekko {
    public static final String NAME = "EKKO";

    public static void greet() {
        System.out.printf("Hello! I'm %s \nWhat can I do for you?\n(Input 'bye' to exit)\n", NAME);
        linebreak();
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again soon! ");
        linebreak();
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
