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

    public boolean isDone() {
        return done;
    }

    public void unDo() {
        this.done = false;
    }

    public String printDes() {
        return description; 
    }

    public String printDone() {
        if (done) {
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    public String toString() {
        return String.format("%s %s", printDone(), printDes());
    }
}
