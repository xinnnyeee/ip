public class Deadline extends Todo {
    private String dueDate;

    public Deadline(String description, String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return String.format("[D] %s %s (by: %s)", super.printDone(), super.printDes(), this.dueDate);
    }
}
