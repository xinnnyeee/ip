import java.util.Scanner;
import java.io.File;


public class Main {
    public enum Commands {
        TODO, MARK, UNMARK, LIST, BYE, DEADLINE, EVENT, DELETE
    }
    public static void main(String[] args) {
        // create a new directory called data if not existing already
        String projPath = System.getProperty("user.dir");
        String dirPath = projPath + File.separator + "data";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }

        Todolist todolist = new Todolist();
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
            // split the input
            String[] parts = input.split(" ");

            // match command to listed ones enum
            try {
                Commands command = Commands.valueOf(parts[0].toUpperCase());
                int index;
                String des;
                String resp;
                switch(command) {
                    case Commands.TODO: 
                        des = input.split(" ",2)[1];
                        resp = todolist.add(new Todo(des));
                        Ekko.reply(resp);
                        break;
                    case Commands.BYE:
                        Ekko.exit();
                        break;
                    case Commands.MARK:
                        // Convert the second part to an integer
                        index = Integer.parseInt(parts[1]); 
                        resp = todolist.mark(index);
                        Ekko.reply(resp);
                        break;
                    case Commands.UNMARK: 
                        index = Integer.parseInt(parts[1]); 
                        resp = todolist.unmark(index);
                        Ekko.reply(resp);
                        break;
                    case Commands.LIST: 
                        todolist.printList();
                        // reply(String) not used bcz printList() uses System.out directly
                        Ekko.linebreak();
                        break;
                    case Commands.DEADLINE: 
                        des = input.split(" ",2)[1].split("/by")[0];
                        String dueDate = input.split("/by")[1];
                        resp = todolist.add(new Deadline(des, dueDate));
                        Ekko.reply(resp);
                        break;
                    case Commands.EVENT:
                        des = input.split(" ",2)[1];
                        String start = des.split("/from")[1].split("/to")[0];
                        String end = des.split("/to")[1];
                        des = des.split("/from")[0];
                        resp = todolist.add(new Event(des, start, end));
                        Ekko.reply(resp);
                        break;
                    case Commands.DELETE:
                        index = Integer.parseInt(parts[1]);
                        resp = todolist.delete(index);
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
