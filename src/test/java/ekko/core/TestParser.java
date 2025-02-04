package ekko.core;  //same package as the class being tested
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static ekko.core.Parser.parseCommand;
import static ekko.core.Parser.parseDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParser {
    @Test
    public void parseCommandTest(){
        assertEquals(parseCommand("todo running"), Commands.TODO);
        assertEquals(parseCommand("deadline /by 02/03/2025 12"), Commands.DEADLINE);
        assertEquals(parseCommand("event /from 02/03/2025 13 /to 03/03/2025 15"), Commands.EVENT);
        assertEquals(parseCommand(" todo kjhgjh"), Commands.TODO);
        assertEquals(parseCommand("list"), Commands.LIST);
        assertEquals(parseCommand("delete jhgjdfs"), Commands.DELETE);
    }

    @Test
    public void parseDateTimeTest(){
        assertEquals(parseDateTime("12 Jan 2025"),
                LocalDateTime.of(2025, 1, 12, 23, 59, 59));
        assertEquals(parseDateTime("02/03/2025"),
                LocalDateTime.of(2025, 3, 2, 23, 59, 59));
        assertEquals(parseDateTime("2025-03-02"),
                LocalDateTime.of(2025, 3, 2, 23, 59, 59));
        assertEquals(parseDateTime("Jan 12 2025"),
                LocalDateTime.of(2025, 1, 12, 23, 59, 59));
        assertEquals(parseDateTime("12 Jan 2025 12"),
                LocalDateTime.of(2025, 1, 12, 12, 0, 0));
        assertEquals(parseDateTime("02/03/2025 12:30"),
                LocalDateTime.of(2025, 3, 2, 12, 30, 0));
        assertEquals(parseDateTime("2025-03-02 19:24"),
                LocalDateTime.of(2025, 3, 2, 19, 24, 0));
        assertEquals(parseDateTime("Jan 12 2025 01:01"),
                LocalDateTime.of(2025, 1, 12, 1, 1, 0));

    }
}
