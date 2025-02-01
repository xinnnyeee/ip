import java.time.LocalDateTime;

/**
 * A deadline.
 */
public class Deadline extends Todo {
    private LocalDateTime dueDate;

    /**
     * Create a deadline.
     * @param description
     * @param dueDate
     */
    public Deadline(String description, LocalDateTime dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    /**
     * String representation of the deadline.
     * @return
     */
    @Override
    public String toString() {
        return String.format("[D] %s %s (by: %s)", super.printDone(), super.printDes(), this.dueDate.toString());
    }
}
