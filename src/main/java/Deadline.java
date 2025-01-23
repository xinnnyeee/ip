public class Deadline extends Todo {
    private String dueDate;

    public Deadline(String description, String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    public String toString() {
        return String.format("[D] %s (by: %s)", super.printFull(), this.dueDate);
    }
}
