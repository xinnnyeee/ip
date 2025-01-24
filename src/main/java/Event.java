public class Event extends Todo {
    private String start;
    private String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[E] %s %s (from: %s to: %s)", 
            super.printDone(), super.printDes(), this.start, this.end);
    }
}
