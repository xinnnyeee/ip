import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A collection of all the possible activities (todos).
 */
public class Todolist {
    private int count;
    private List<Todo> list;

    public Todolist() {
        this.count = 0;
        this.list = new ArrayList<>();
    }

    /**
     * Get the number of current items in the to-do list.
     * @return int
     */
    public int getCount() {
        return count;
    }

    /**
     * Adding a Todo to the list.
     * @param task a todo
     * @return String notation for completing the task
     */
    public String add(Todo task) {
        this.count += 1;
        list.add(task);
        return String.format("Got it! I've added this task: \n%s\nNow you have %d task(s) in the list.", task.toString(), count);
    }

    /**
     * Print out the todolist.
     */
    public void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= count; i++) {
            System.out.printf("%d. %s \n", i, this.list.get(i - 1).toString());
        }
    }

    /**
     * Convert the todolist to a long String, separated by new lines.
     * @return long String separated by new lines
     */
    public String toString() {
        return list.stream().map(Todo::toString).collect(Collectors.joining("\n"));
    }

    /**
     * Unmark a Todo on the list.
     * @param index the index number of the item
     * @return completion message
     */
    public String unmark(int index) {
        Todo target = list.get(index - 1);
        target.unDo();
        return String.format("Meow, please remember to do it still...\n%s", target);
    }

    /**
     * Mark a Todo as done.
     * @param index the index number of the item
     * @return completion message
     */
    public String mark(int index) {
        Todo target = list.get(index - 1);
        target.markDone();
        return String.format("Yippee! One task off the list: \n%s", target);
    }

    /**
     * Delete a Todo from the list.
     * @param index the index number of the item
     * @return completion message
     */
    public String delete(int index) {
        Todo target = list.get(index - 1);
        list.remove(index - 1);
        count -= 1;
        return String.format("Ekko has eaten your task!\n%s\nOnly %d tasks left! Jiayouu",
            target.toString(), count);
    }

    public String filter(String keyword) {
        List<Todo> filteredItems = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (list.get(i).printDes().contains(keyword)) {
                filteredItems.add(list.get(i));
            }
        }
        return filteredItems.stream().map(Todo::toString).collect(Collectors.joining("\n"));
    }
}
