import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItem {
    private String title; // 1 or more chars in length
    private String description; // 0 or more chars in length
    private LocalDate dueDate; // YYYY-MM-DD format
    private boolean completed;

    public TaskItem (String title, String description, String dueDate) throws IllegalArgumentException, DateTimeParseException {
        setTitle(title);
        this.description = description;
        setDueDate(dueDate);
        completed = false;
    }

    public TaskItem (String title, String description, String dueDate, boolean completed) throws IllegalArgumentException, DateTimeParseException {
        setTitle(title);
        this.description = description;
        setDueDate(dueDate);
        this.completed = completed;
    }

    // Setters -------------------
    public void setTitle(String title) throws IllegalArgumentException {
        if(title.length() < 1)
            throw new IllegalArgumentException("Invalid Title");
        this.title = title;
    }

    public void setDueDate(String dueDate) throws DateTimeParseException {
        this.dueDate = LocalDate.parse(dueDate);
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters -----------------
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        String item = "[" + dueDate.toString() + "] " + title + ": " + description;
        return completed ? "✓ " + item : item;
    }
}
