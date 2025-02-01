import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Todolist {
    private int count;
    private List<Todo> list;
    private String filePath;


    public Todolist() {
        this.count = 0;
        this.list = new ArrayList<>();
        this.filePath = "data/ekko.txt";
        File file = new File(filePath);
    }


    public String add(Todo task) {
        this.count += 1;
        list.add(task);
        updateFile();
        return String.format("Got it! I've added this task: \n%s\nNow you have %d task(s) in the list.", task.toString(), count);
    }

    public void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= count; i++) {
            System.out.printf("%d. %s \n", i, this.list.get(i - 1).toString());
        }
    }

    public String unmark(int index) {
        Todo target = list.get(index - 1);
        target.unDo();
        updateFile();
        return String.format("Meow, please remember to do it still...\n%s", target.toString());
    }

    public String mark(int index) {
        Todo target = list.get(index - 1);
        target.markDone();
        updateFile();
        return String.format("Yippee! One task off the list: \n%s", target.toString());
    }

    public String delete(int index) {
        Todo target = list.get(index - 1);
        list.remove(index - 1);
        count -= 1;
        updateFile();
        return String.format("Ekko has eaten your task!\n%s\nOnly %d tasks left! Jiayouu",
            target.toString(), count);
    }

    public void updateFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < count; i++) {
                bw.write(list.get(i).toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Uh oh, something went wrong when trying to create a file.");
        }
    }

}
