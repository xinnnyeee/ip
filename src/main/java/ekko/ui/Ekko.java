package ekko.ui;

import ekko.core.Commands;
import ekko.core.Parser;
import ekko.storage.Storage;
import ekko.task.Todolist;

/**
 * Handle user interface functionalities.
 */
public class Ekko {
    private Storage storage;
    private Todolist todolist;
    private static final String LOGO =
            " _____   _   __  _   __  ______\n"
                    + "|  ___| | | / / | | / / |  __  | \n"
                    + "| |___  | '/ /  | '/ /  | |  | | \n"
                    + "|  ___| | |\\ \\  | |\\ \\  | |  | |\n"
                    + "| |___  | | \\ \\ | | \\ \\ | |__| | \n"
                    + "|_____| |_|  \\_\\|_|  \\_\\|______|";

    private static final String MANUAL = "Here's how you can use me :3 \n"
            + "\tTODO description - adding a generic task into your todolist\n"
            + "\tDEADLINE description /by DD/MM/YYYY HH - adding a task with a due date and time\n"
            + "\tEVENT description /from DD/MM/YYYY HH /to DD/MM/YYYY HH - adding an activity with start and end time\n"
            + "\tMARK index - mark the task with given index as done\n"
            + "\tUNMARKED index - mark the task with given index as not done\n"
            + "\tFIND keyword - search for tasks with relevant keywords\n"
            + "\tLIST - list all the task in the todolist\n"
            + "\tDELETE index - remove task from the todolist";

    public Ekko() {
        this.storage = new Storage();
        this.todolist = new Todolist();
    }

    public String getResponse(String input) {
        String[] parts = input.split(" ");
        try {
            Commands command = Parser.parseCommand(input);
            int index;
            String resp;
            switch (command) {
                case TODO:
                    resp = todolist.add(Parser.parseTodo(input));
                    storage.updateFile(todolist);
                    return resp;
                case BYE:
                    Ekko.exit();
                case MARK:
                    index = Integer.parseInt(parts[1]);
                    resp = todolist.mark(index);
                    storage.updateFile(todolist);
                    return resp;
                case UNMARK:
                    index = Integer.parseInt(parts[1]);
                    resp = todolist.unmark(index);
                    storage.updateFile(todolist);
                    return resp;
                case LIST:
                    return todolist.toString();
                case DEADLINE:
                    resp = todolist.add(Parser.parseDeadline(input));
                    storage.updateFile(todolist);
                    return resp;
                case EVENT:
                    resp = todolist.add(Parser.parseEvent(input));
                    storage.updateFile(todolist);
                    return resp;
                case DELETE:
                    index = Integer.parseInt(parts[1]);
                    resp = todolist.delete(index);
                    storage.updateFile(todolist);
                    return resp;
                case MEOW:
                    resp = Parser.parseMeow(input);
                    return resp;
                case FIND:
                    resp = todolist.filter(Parser.parseFind(input));
                    if (resp.isBlank()) {
                        return "Nothing found meow, maybe you can add that into your list? ";
                    }
                    return "Here are the relevant items on your list: \n" + resp;
            }
        } catch (IllegalArgumentException e) {
            return"Meow, sorry I am just a little Ekko. ";

        } catch (ArrayIndexOutOfBoundsException e) {
            return"Meow, please complete your command!";
        }
        return "Meow, sorry I am just a little Ekko. ";
    }

        /**
         * Greet the user when starting the program.
         */
        public static String greet () {
            return("Hello from\n" + LOGO + "\n" + MANUAL + "\nWhat can I do for you?\n(Input \"bye\" to exit)");
        }

        /**
         * Exit the program.
         */
        public static void exit () {
            System.exit(0);
        }

        /**
         * Repeat whatever that was said by the user.
         * @param text String to repeat
         */
        public static String echo (String text){
            return text;
        }

    }

