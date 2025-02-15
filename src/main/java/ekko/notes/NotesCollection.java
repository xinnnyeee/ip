package ekko.notes;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * A collection of Notes
 */
public class NotesCollection {
    HashMap<String, String> notes;

    /**
     * HashMap used for easy look up
     */
    public NotesCollection() {
        notes = new HashMap<>();
    }

    /**
     * Adding a Note to a collection of notes
     * @param title the note's title
     * @param content the note's content
     * @return response message for adding a Note to the collection
     */
    public String addNote(String title, String content) {
        notes.put(title, content);
        return "Ekko has helped you remember it!\n " + title + ": " + content;
    }

    /**
     * Adding a Note to a collection of notes
     * @param note the note being added
     * @return response message for adding a Note to the collection
     */
    public String addNote(Note note) {
        notes.put(note.getTitle(), note.getDescription());
        return "Ekko has helped you remember it!\n" + note.getTitle() + ": " + note.getDescription();
    }

    /**
     * Remove a Note from the collection
     * @param title title of the note
     * @return response message for deleting the Note from the collection
     */
    public String removeNote(String title) {
        notes.remove(title);
        return "Ekko has helped you removed: " + title;
    }

    /**
     * Convert the note collection to a string.
     * @return string representation of the note collection.
     */
    public String toString() {
        return notes.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue())
                    .collect(Collectors.joining("\n"));

    }


}
