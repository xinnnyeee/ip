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
            System.out.printf("%d. %s %s", i, this.list.get(i - 1).printDone(), 
            this.list.get(i - 1).toString());
        }
    }

}
