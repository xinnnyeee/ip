import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Handle the parsing of user's input.
 */
public class Parser {

    private static final List<DateTimeFormatter> DATE_TIME_FORMATTERS = List.of(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy HH"),
            DateTimeFormatter.ofPattern("MMM dd, yyyy HH")
    );

    /**
     * Extract the command word of an input
     * @param input String user input
     * @return String command word
     */
    public static Commands parseCommand(String input) {
        return Commands.valueOf(input.split(" ")[0].toUpperCase());
    }

    /**
     * Parse the String date and time input to a LocalDateTime object
     * @param input String date and time
     * @return LocalDateTime
     */
    public static LocalDateTime parseDateTime(String input) {
        String trimmedInput = input.trim();
        for (DateTimeFormatter formatter : DATE_TIME_FORMATTERS) {
            try {
                return LocalDateTime.parse(trimmedInput, formatter);
            } catch (DateTimeParseException ignored) {}
        }
        throw new IllegalArgumentException("Invalid date or date-time format: " + trimmedInput);
    }

    /**
     * Parse input with command EVENT
     * @param input String user input
     * @return new Event created
     */
    public static Event parseEvent(String input) {
        String des = input.split(" ",2)[1];
        String start = des.split("/from ")[1].split(" /to")[0];
        LocalDateTime startTime = Parser.parseDateTime(start);
        String end = des.split("/to ")[1];
        LocalDateTime endTime = Parser.parseDateTime(end);
        des = des.split("/from")[0];
        return new Event(des, startTime, endTime);
    }

    /**
     * Parse input with command TODO to create a Todo object
     * @param input String user input
     * @return new Todo created
     */
    public static Todo parseTodo(String input) {
        String des = input.split(" ",2)[1];
        return new Todo(des);
    }

    /**
     * Parse input with command DEADLINE to create a Deadline Object
     * @param input String user input
     * @return new Deadline created
     */
    public static Deadline parseDeadline(String input) {
        String des = input.split(" ",2)[1].split("/by")[0];
        String stringDate = input.split("/by ")[1];
        LocalDateTime dueDateTime = Parser.parseDateTime(stringDate);
        return new Deadline(des, dueDateTime);
    }

    /**
     * Output words of love
     * @param input user input
     * @return String easter egg
     */
    public static String parseMeow(String input) {
        return "Meow, I love you too.";
    }

    /**
     * Parse input with Find command.
     * @param input String user input
     * @return search keyword
     */
    public static String parseFind(String input) {
        return input.split(" ",2)[1];
    }
}