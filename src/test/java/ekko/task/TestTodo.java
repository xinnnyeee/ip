package ekko.task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTodo {
    @Test
    public void markDoneTest() {
        Todo task = new Todo("running");
        task.markDone();
        assertEquals(task.isDone(), true);
        task.markDone();
        assertEquals(task.isDone(), true);
    }

    @Test
    public void toStringTest() {
        Todo task = new Todo("running");
        assertEquals("[T] [ ] running", task.toString());
        task.markDone();
        assertEquals("[T] [X] running", task.toString());
    }

}