import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Ekko.greet();
        String dirPath = Storage.makeDir();
        Todolist todolist = new Todolist();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            try {
                Commands command = Parser.parseCommand(input);
                int index;
                String des;
                String resp;
                switch(command) {
                    case TODO:
                        resp = todolist.add(Parser.parseTodo(input));
                        Ekko.reply(resp);
                        break;
                    case BYE:
                        Ekko.exit();
                        break;
                    case MARK:
                        index = Integer.parseInt(parts[1]);
                        resp = todolist.mark(index);
                        Ekko.reply(resp);
                        break;
                    case UNMARK:
                        index = Integer.parseInt(parts[1]);
                        resp = todolist.unmark(index);
                        Ekko.reply(resp);
                        break;
                    case LIST:
                        todolist.printList();
                        Ekko.linebreak();
                        break;
                    case DEADLINE:
                        resp = todolist.add(Parser.parseDeadline(input));
                        Ekko.reply(resp);
                        break;
                    case EVENT:
                        resp = todolist.add(Parser.parseEvent(input));
                        Ekko.reply(resp);
                        break;
                    case DELETE:
                        index = Integer.parseInt(parts[1]);
                        resp = todolist.delete(index);
                        Ekko.reply(resp);
                        break;
                    case MEOW:
                        resp = Parser.parseMeow(input);
                        Ekko.reply(resp);
                        break;
                }
            } catch (IllegalArgumentException e) {
                // error message
                Ekko.reply("Meow, sorry I am just a little Ekko. ");

            } catch (ArrayIndexOutOfBoundsException e) {
                Ekko.reply("Meow, please complete your command!");
            }
            
        }

    }
}
