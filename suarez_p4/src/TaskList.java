import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> taskItems;

    public TaskList() {
        this.taskItems = new ArrayList<TaskItem>();
    }

    public void AddTask(TaskItem taskItem) {
        taskItems.add(taskItem);
    }

    public void RemoveTask (int index) {
        taskItems.remove(index);
        // Will probably need some error handling here as well
    }

    public void MarkItemComplete (int index, boolean completed) {
        taskItems.get(index).SetCompleted(completed);
    }

    public ArrayList<TaskItem> GetTaskItems() {
        return taskItems;
    }

    public ArrayList<TaskItem> GetTaskItems(boolean completed) {
        ArrayList<TaskItem> items = new ArrayList<TaskItem>();
        for (TaskItem ti : taskItems){
            if (ti.isCompleted() == completed)
                items.add(ti);
        }
        return items;
    }

}
