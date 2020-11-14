import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    ArrayList<TaskList> taskLists = new ArrayList<TaskList>();



    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        Scanner scan = new Scanner(System.in);
        mainMenuPrints();

        int choice = -1;

        while (choice != 3) {
            choice = scan.nextInt();

            if (choice == 3) {
                break;
            }

            switch (choice) {
                case 1:
                    CreateNewListMenu(scan);
                    mainMenuPrints();
                    break;
                case 2:
                    loadExistingList(scan);
                    mainMenuPrints();
                    break;
                default:
                    System.out.println("Please choose a valid option");
            }
        }
    }



    private static void CreateNewListMenu (Scanner scan) {
        TaskList taskList= new TaskList();
        System.out.println("A new list has been created\n");
        newListMenuPrints();

        int choice = -1;

        while (choice != 8) {
            choice = scan.nextInt();

            if (choice == 8){
                break;
            }

            switch (choice) {
                case 1:
                    viewTaskList(taskList);
                    newListMenuPrints();
                    break;
                case 2:
                    addItemToList(scan, taskList);
                    newListMenuPrints();
                    break;
                case 3:
                    editItem(scan, taskList);
                    newListMenuPrints();
                    break;
                case 4:
                    removeItem(scan, taskList);
                    newListMenuPrints();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please choose a valid option");
            }
        }
    }

    private static void removeItem(Scanner scan, TaskList taskList) {
        viewTaskList(taskList);

        System.out.print("Which task would you like to remove? ");
        int choice = scan.nextInt();
        taskList.RemoveTask(choice);
        System.out.print("\n");
    }

    private static void editItem(Scanner scan, TaskList taskList) {
        viewTaskList(taskList);

        System.out.print("Which task would you like to edit? ");
        int choice = scan.nextInt();
        if (true) { // Need to implement error handling here --------------------------------------
            scan.nextLine(); // Clear buffer

            System.out.print("Enter a new title for task " + choice + ": ");
            String newTitle = scan.nextLine();

            System.out.print("Enter a new description for task " + choice + ": ");
            String newDescription = scan.nextLine();

            System.out.print("Enter a new due date (YYYY-MM-DD) for task " + choice + ": ");
            String newDueDate = scan.nextLine();

            try {
                taskList.GetTaskItems().get(choice).SetTitle(newTitle);
                taskList.GetTaskItems().get(choice).SetDescription(newDescription);
                taskList.GetTaskItems().get(choice).SetDueDate(newDueDate);
            } catch (IllegalArgumentException titleException) {
                System.out.println("WARNING: title must be at least 1 character long; task not edited");
            } catch (DateTimeParseException dueDateException) {
                System.out.println("WARNING: invalid due date; task not edited");
            }
            System.out.print("\n");
        }
    }

    private static void addItemToList(Scanner scan, TaskList taskList) {
        TaskItem taskItem = null;
        scan.nextLine(); // Clear buffer

        System.out.print("Task title: ");
        String title = scan.nextLine();

        System.out.print("Task description: ");
        String description = scan.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        String dueDate = scan.nextLine();

        try {
            taskItem = new TaskItem(title, description, dueDate);
            taskList.AddTask(taskItem);
        } catch (IllegalArgumentException titleException) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        } catch (DateTimeParseException dueDateException) {
            System.out.println("WARNING: invalid due date; task not created");
        }
        System.out.print("\n");
    }

    private static void viewTaskList(TaskList taskList) {
        System.out.print("\n");
        System.out.println("Current tasks");
        System.out.println("-------------");

        for (int i = 0; i < taskList.GetTaskItems().size(); i++) {
            System.out.println(i + ") " + taskList.GetTaskItems().get(i).toString());
        }

        System.out.print("\n\n");
    }

    private static void loadExistingList(Scanner scan) {
        System.out.println("Enter the filename to load: ");
        // Perform some file IO
        String fileName = scan.nextLine();
        System.out.println(fileName + " was successfuly loaded");
    }


    // Print helper methods
    private static void newListMenuPrints() {
        System.out.println("List Operation Menu");
        System.out.println("-------------------\n");
        System.out.println("1) View the list");
        System.out.println("2) Add an item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Mark an item as completed");
        System.out.println("6) Unmark an item as completed");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to the main menu");
    }

    private static void mainMenuPrints() {
        System.out.println("Main Menu");
        System.out.println("----------\n");
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Quit");
    }

}
