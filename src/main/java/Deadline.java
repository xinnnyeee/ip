public class Deadline extends Todo {
    private String dueDate;

    public Deadline(String description, String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return String.format("[D] %s (by: %s)", super.toString(), this.dueDate);
    }
}
