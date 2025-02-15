package ekko.notes;

/**
 * A Note constitute a title and a description
 */
public class Note {
    private String title;
    private String description;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Get title of a Note
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get description of a Note
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Print a Note
     * @return string format of a note
     */
    public String toString() {
        return title + ": " + description;
    }
}

