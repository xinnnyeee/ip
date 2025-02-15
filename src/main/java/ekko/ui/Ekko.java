package ekko.ui;

import ekko.core.Commands;
import ekko.core.Parser;
import ekko.notes.NotesCollection;
import ekko.storage.Storage;
import ekko.task.Todolist;

/**
 * Handle user interface functionalities.
 */
public class Ekko {
    private Storage storage;
    private Todolist todolist;
    private NotesCollection notelist;

    /**
     * Brief intro from Ekko and guide to use the chatbot
     */
    private static final String MANUAL = "Here's how you can use me :3 \n\n"
            + "TODO description - adding a generic task into your todolist\n"
            + "DEADLINE description /by DD/MM/YYYY HH - adding a task with a due date and time\n"
            + "EVENT description /from DD/MM/YYYY HH /to DD/MM/YYYY HH - adding an activity with start and end time\n"
            + "MARK index - mark the task with given index as done\n"
            + "UNMARKED index - mark the task with given index as not done\n"
            + "FIND keyword - search for tasks with relevant keywords\n"
            + "LIST - list all the task in the todolist\n"
            + "DELETE index - remove task from the todolist";

    /**
     * Initialise the todolist and storage file for an Ekko instance
     */
    public Ekko() {
        this.storage = new Storage();
        this.todolist = new Todolist();
        this.notelist = new NotesCollection();
    }

    /**
     * Get the String output for any user input, and print greeting upon empty input
     * @param input user input
     * @return response from ekko
     */
    public String getResponse(String input) {
        // Check if the input is empty or null, and return the greeting
        if (input == null || input.trim().isEmpty()) {
            return greet();
        }
        try {
            Commands command = Parser.parseCommand(input);
            switch (command) {
                case TODO:
                    return Parser.parseTodo(todolist, storage, input);
                case BYE:
                    Ekko.exit();
                case MARK:
                    return Parser.parseMark(todolist, storage, input);
                case UNMARK:
                    return Parser.parseUnmark(todolist, storage, input);
                case LIST:
                    return Parser.parseList(notelist, todolist);
                case DEADLINE:
                    return Parser.parseDeadline(todolist, storage, input);
                case EVENT:
                    return Parser.parseEvent(todolist, storage, input);
                case DELETE:
                    return Parser.parseDelete(todolist, storage, input);
                case MEOW:
                    return Parser.parseMeow();
                case FIND:
                    return Parser.parseFind(todolist, storage, input);
                case NOTE:
                    return Parser.parseNote(notelist, storage, input);
                case RMNOTE:
                    return Parser.parseRMNote(notelist, storage, input);

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
            return("Hello from Ekko <3\n" + "\n" + MANUAL + "\nWhat can I do for you?\n(Input \"bye\" to exit)");
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

