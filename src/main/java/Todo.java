public class Todo {
    private String description;
    private boolean done;

    public Todo(String description) {
        this.description = description;
        this.done = false;
    }

    public void markDone() {
        this.done = true;
    }

    public String toString() {
        if (done) {
            return String.format("[X] %s", description);
        } else {
            return String.format("[ ] %s", description);
        }
        
    }
}
