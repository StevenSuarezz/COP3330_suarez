import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "description", "2020-11-16"));
        assertEquals(1, tl.getTaskItems().size());
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16"));
        tl.editItemComplete(0, true);
        assertEquals(true, tl.getTaskItemByIndex(0).isCompleted());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16"));
        assertThrows(IndexOutOfBoundsException.class,() -> tl.editItemComplete(1, true));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16"));
        tl.editItemDescription(0, "New Description");
        assertEquals("New Description", tl.getTaskItemByIndex(0).getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16"));
        assertThrows(IndexOutOfBoundsException.class,() -> tl.editItemDescription(1, "New Description"));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16"));
        tl.editItemDueDate(0, "2020-11-17");
        assertEquals(LocalDate.parse("2020-11-17"), tl.getTaskItemByIndex(0).getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16"));
        assertThrows(IndexOutOfBoundsException.class,() -> tl.editItemDueDate(1, "2020-11-17"));
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16"));
        tl.editItemTitle(0, "New Title");
        assertEquals("New Title", tl.getTaskItemByIndex(0).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16"));
        assertThrows(IndexOutOfBoundsException.class,() -> tl.editItemTitle(1, "New Title"));
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList tl = new TaskList();
        assertEquals(0, tl.getTaskItems().size());
    }


    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("Title", "Description", "2020-11-16"));
        tl.removeTask(0);
        assertEquals(0, tl.getTaskItems().size());
    }


    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("Title", "Description", "2020-11-16"));
        assertThrows(IndexOutOfBoundsException.class, () -> tl.removeTask(1));
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16", true));
        tl.editItemComplete(0, false);
        assertEquals(false, tl.getTaskItemByIndex(0).isCompleted());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList tl = new TaskList();
        tl.addTask(new TaskItem("title", "desc", "2020-11-16", true));
        assertThrows(IndexOutOfBoundsException.class,() -> tl.editItemComplete(1, false));
    }

}