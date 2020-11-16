import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> taskItems;

    public TaskList() {
        this.taskItems = new ArrayList<TaskItem>();
    }

    public void addTask(TaskItem taskItem) {
        taskItems.add(taskItem);
    }

    public void removeTask(int index) {
        taskItems.remove(index);
    }

    public void editItemTitle (int index, String newTitle) {
        taskItems.get(index).setTitle(newTitle);
    }

    public void editItemDescription (int index, String newDesc) {
        taskItems.get(index).setDescription(newDesc);
    }

    public void editItemDueDate (int index, String newDate) {
        taskItems.get(index).setDueDate(newDate);
    }

    public void editItemComplete(int index, boolean completed) {
        taskItems.get(index).setCompleted(completed);
    }

    public ArrayList<TaskItem> getTaskItems() {
        return taskItems;
    }

    public ArrayList<TaskItem> getTaskItemsByCompletion(boolean completed) {
        ArrayList<TaskItem> items = new ArrayList<TaskItem>();
        for (TaskItem ti : taskItems){
            if (ti.isCompleted() == completed)
                items.add(ti);
        }
        return items;
    }

    public TaskItem getTaskItemByIndex(int index) {
        return taskItems.get(index);
    }

}
