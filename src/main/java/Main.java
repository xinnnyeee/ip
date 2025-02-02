import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Ekko.greet();
        Storage storage = new Storage();
        String filePath = storage.createFile("ekko.txt");
        Todolist todolist = new Todolist();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            try {
                Commands command = Parser.parseCommand(input);
                int index;
                String resp;
                switch(command) {
                    case TODO:
                        resp = todolist.add(Parser.parseTodo(input));
                        storage.updateFile(filePath, todolist);
                        Ekko.reply(resp);
                        break;
                    case BYE:
                        Ekko.exit();
                        break;
                    case MARK:
                        index = Integer.parseInt(parts[1]);
                        resp = todolist.mark(index);
                        storage.updateFile(filePath, todolist);
                        Ekko.reply(resp);
                        break;
                    case UNMARK:
                        index = Integer.parseInt(parts[1]);
                        resp = todolist.unmark(index);
                        storage.updateFile(filePath, todolist);
                        Ekko.reply(resp);
                        break;
                    case LIST:
                        todolist.printList();
                        Ekko.linebreak();
                        break;
                    case DEADLINE:
                        resp = todolist.add(Parser.parseDeadline(input));
                        storage.updateFile(filePath, todolist);
                        Ekko.reply(resp);
                        break;
                    case EVENT:
                        resp = todolist.add(Parser.parseEvent(input));
                        storage.updateFile(filePath, todolist);
                        Ekko.reply(resp);
                        break;
                    case DELETE:
                        index = Integer.parseInt(parts[1]);
                        resp = todolist.delete(index);
                        storage.updateFile(filePath, todolist);
                        Ekko.reply(resp);
                        break;
                    case MEOW:
                        resp = Parser.parseMeow(input);
                        Ekko.reply(resp);
                        break;
                    case FIND:
                        resp = todolist.filter(Parser.parseFind(input));
                        if (resp.isBlank()) {
                            Ekko.reply("Nothing found meow, maybe you can add that into your list? ");
                        } else {
                            Ekko.reply("Here are the relevant items on your list: \n" + resp);
                        }
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
