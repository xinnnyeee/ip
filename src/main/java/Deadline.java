import java.time.LocalDateTime;

public class Deadline extends Todo {
    private LocalDateTime dueDate;

    public Deadline(String description, LocalDateTime dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return String.format("[D] %s %s (by: %s)", super.printDone(), super.printDes(), this.dueDate.toString());
    }
}
