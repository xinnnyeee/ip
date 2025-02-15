package ekko.task;
/**
 * A task to be completed, the most generic item on the Todolist.
 */
public class Todo {
    private String description;
    private boolean done;

    /**
     * Instantiate a task
     * @param description description of the task
     */
    public Todo(String description) {
        this.description = description;
        this.done = false;
    }

    /**
     * Mark the task as done.
     */
    public void markDone() {
        this.done = true;
    }

    /**
     * Check whether the task is done.
     * @return boolean
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Make the task undone.
     */
    public void unDo() {
        this.done = false;
    }

    /**
     * Return the description String of the task.
     * @return description
     */
    public String printDes() {
        return description;
    }

    /**
     * Return the String representation of the checkbox.
     * @return String checkbox
     */
    public String printDone() {
        if (done) {
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    /**
     * Return the String representation of the entire task.
     * @return the task type, the checkbox and the task description
     */
    public String toString() {
        return String.format("[T] %s %s", printDone(), printDes());
    }
}
