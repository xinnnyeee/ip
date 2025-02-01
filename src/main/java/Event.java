import java.time.LocalDateTime;

public class Event extends Todo {
    private LocalDateTime start;
    private LocalDateTime end;

    public Event(String description, LocalDateTime start, LocalDateTime end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[E] %s %s (from: %s to: %s)", 
            super.printDone(), super.printDes(), this.start.toString(), this.end.toString());
    }
}
