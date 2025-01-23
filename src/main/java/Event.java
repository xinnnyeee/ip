public class Event extends Todo {
    private String start;
    private String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return String.format("[E] %s (from: %s to: %s)", 
            super.printFull(), this.start, this.end);
    }
}
