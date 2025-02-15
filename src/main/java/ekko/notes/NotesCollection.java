package ekko.notes;

import java.util.HashMap;
import java.util.stream.Collectors;

public class NotesCollection {
    HashMap<String, String> notes;

    public NotesCollection() {
        notes = new HashMap<>();
    }

    public String addNote(String title, String content) {
        notes.put(title, content);
        return "Ekko has helped you remember it!\n " + title + ": " + content;
    }

    public String addNote(Note note) {
        notes.put(note.getTitle(), note.getDescription());
        return "Ekko has helped you remember it!\n" + note.getTitle() + ": " + note.getDescription();
    }

    public String removeNote(String title) {
        notes.remove(title);
        return "Ekko has helped you removed: " + title;
    }

    public String toString() {
        return notes.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue())
                    .collect(Collectors.joining("\n"));

    }


}
