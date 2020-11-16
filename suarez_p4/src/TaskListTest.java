import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(DateTimeParseException.class, () -> new TaskItem("Valid Title", "Valid Description", "Invalid Date"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("", "Valid Description", "2020-11-16"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(() ->  new TaskItem("Title", "Description", "2020-11-16"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(() ->  new TaskItem("Valid Title", "Description", "2020-11-16"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem ti = new TaskItem("Title", "Description", "2020-11-16");
        assertThrows(DateTimeParseException.class, () -> ti.SetDueDate("Invalid due date"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem ti = new TaskItem("Title", "Description", "2020-11-16");
        assertDoesNotThrow(() -> ti.SetDueDate("2020-11-17"));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem ti = new TaskItem("Title", "Description", "2020-11-16");
        assertThrows(IllegalArgumentException.class, () -> ti.SetTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem ti = new TaskItem("Title", "Description", "2020-11-16");
        assertDoesNotThrow(() -> ti.SetTitle("Valid"));
    }
}