import java.time.LocalDate;

public class Deadline extends Todo {
    private LocalDate dueDate;

    public Deadline(String description, LocalDate dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return String.format("[D] %s %s (by: %s)", super.printDone(), super.printDes(), this.dueDate.toString());
    }
}
