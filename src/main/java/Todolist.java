import java.util.ArrayList;
import java.util.List;

public class Todolist {
    private int count;
    private List<Todo> list;

    public Todolist() {
        this.count = 0;
        this.list = new ArrayList<>();
    }

    public String add(Todo task) {
        this.count += 1;
        list.add(task);
        return String.format("added: %s", task.toString());
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
        return String.format("Meow, please remember to do it still...\n%s", target.toString());
    }

    public String mark(int index) {
        Todo target = list.get(index - 1);
        target.markDone();
        return String.format("Yippee! One task off the list: \n%s", target.toString());
    }

    public String delete(int index) {
        Todo target = list.get(index - 1);
        list.remove(index - 1);
        count -= 1;
        return String.format("Ekko has eaten your task!\n\t%s\nOnly %d tasks left! Jiayouu", 
            target.toString(), count);
    }

}
