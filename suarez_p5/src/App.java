import java.io.*;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.mainMenu();
    }

    private void mainMenu() {
        Scanner scan = new Scanner(System.in);
        mainMenuPrints();

        int choice = -1;

        while (choice != 3) {
            try {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        CreateNewListMenu(scan);
                        mainMenuPrints();
                        break;
                    case 2:
                        loadExistingList(scan);
                        mainMenuPrints();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Please choose a valid option");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option");
                scan.nextLine();
            }
        }
    }

    private void CreateNewListMenu (Scanner scan) {
        TaskList taskList = new TaskList();
        System.out.println("A new list has been created\n");
        listOperationMenu(scan, taskList);
    }

    private void listOperationMenu(Scanner scan, TaskList taskList) {
        newListMenuPrints();

        int choice = -1;

        while (choice != 8) {

            try {
                choice = scan.nextInt();

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
                        markItemComplete(scan, taskList, true);
                        newListMenuPrints();
                        break;
                    case 6:
                        markItemComplete(scan, taskList, false);
                        newListMenuPrints();
                        break;
                    case 7:
                        saveListToTxtFile(scan, taskList);
                        newListMenuPrints();
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Please choose a valid option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option\n");
                scan.nextLine();
                newListMenuPrints();
            }
        }

    }

    private void saveListToTxtFile(Scanner scan, TaskList taskList) {
        System.out.print("Enter a file name: ");
        scan.nextLine();
        String fileName = System.getProperty("user.dir") + "\\" + scan.nextLine();

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for(TaskItem ti : taskList.getTaskItems()) {
                writer.write(ti.getTitle() + "," + ti.getDescription() + "," + ti.getDueDate() + "," + ti.isCompleted() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving to file, save aborted");
            return;
        }

        System.out.println("The task list has been saved to: " + fileName + "\n");
    }

    private void markItemComplete(Scanner scan, TaskList taskList, boolean markComplete) {
        System.out.print("\n");

        if(markComplete) {
            System.out.println("Uncompleted Tasks");
        } else {
            System.out.println("Completed Tasks");
        }

        System.out.println("-----------------");

        for (int i = 0; i < taskList.getTaskItemsByCompletion(!markComplete).size(); i++) {
            System.out.println(i + ") " + taskList.getTaskItemsByCompletion(!markComplete).get(i).toString());
        }

        System.out.print("\n");

        if (markComplete) {
            System.out.print("Which task will you mark as completed? ");
        } else {
            System.out.print("Which task will you mark as uncompleted? ");
        }

        try {
            int choice = scan.nextInt();
            taskList.editItemComplete(choice, markComplete);
            System.out.print("\n");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Please select a valid task to edit\n");
        }
    }

    private void removeItem(Scanner scan, TaskList taskList) {
        viewTaskList(taskList);

        System.out.print("Which task would you like to remove? ");
        try{
            int choice = scan.nextInt();
            taskList.removeTask(choice);
            System.out.print("\n");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Please select a valid task to remove\n");
        }
    }

    private void editItem(Scanner scan, TaskList taskList) {
        viewTaskList(taskList);

        System.out.print("Which task would you like to edit? ");
        try {
            int choice = scan.nextInt();
            taskList.getTaskItemByIndex(choice); // Check for an index out of bounds error before continuing
            scan.nextLine(); // Clear buffer

            System.out.print("Enter a new title for task " + choice + ": ");
            String newTitle = scan.nextLine();

            System.out.print("Enter a new description for task " + choice + ": ");
            String newDescription = scan.nextLine();

            System.out.print("Enter a new due date (YYYY-MM-DD) for task " + choice + ": ");
            String newDueDate = scan.nextLine();

            taskList.editItemTitle(choice, newTitle);
            taskList.editItemDescription(choice, newDescription);
            taskList.editItemDueDate(choice, newDueDate);

        } catch (IllegalArgumentException titleException) {
            System.out.println("WARNING: title must be at least 1 character long; task not edited");
        } catch (DateTimeParseException dueDateException) {
            System.out.println("WARNING: invalid due date; task not edited");
        } catch (IndexOutOfBoundsException indexException) {
            System.out.println("Please select a valid task to edit\n");
        }
        System.out.print("\n");
    }

    private void addItemToList(Scanner scan, TaskList taskList) {
        TaskItem taskItem;
        scan.nextLine(); // Clear buffer

        System.out.print("Task title: ");
        String title = scan.nextLine();

        System.out.print("Task description: ");
        String description = scan.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        String dueDate = scan.nextLine();

        try {
            taskItem = new TaskItem(title, description, dueDate);
            taskList.addTask(taskItem);
        } catch (IllegalArgumentException titleException) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        } catch (DateTimeParseException dueDateException) {
            System.out.println("WARNING: invalid due date; task not created");
        }
        System.out.print("\n");
    }

    private void viewTaskList(TaskList taskList) {
        System.out.print("\n");
        System.out.println("Current tasks");
        System.out.println("-------------");

        for (int i = 0; i < taskList.getTaskItems().size(); i++) {
            System.out.println(i + ") " + taskList.getTaskItemByIndex(i).toString());
        }

        System.out.print("\n\n");
    }

    private void loadExistingList(Scanner scan) {
        System.out.print("Enter the filename to load: ");
        scan.nextLine();
        String filePath = System.getProperty("user.dir") + "\\" + scan.nextLine();
        String line;

        TaskList taskList = new TaskList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                taskList.addTask(new TaskItem(values[0], values[1], values[2], Boolean.parseBoolean(values[3])));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Make sure your spelling is correct and/or that the file exists and try again.");
        } catch (Exception e) {
            System.out.println("Error loading file. Load aborted.");
        }

        System.out.println("Task list was successfully loaded\n");

        listOperationMenu(scan, taskList);
    }

    private void newListMenuPrints() {
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

    private void mainMenuPrints() {
        System.out.println("Main Menu");
        System.out.println("----------\n");
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Quit");
    }

}
