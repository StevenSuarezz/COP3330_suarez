import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<TaskList> taskLists = new ArrayList<TaskList>();

    private TaskItem CreateTask(String title, String description, String dueDate) {
        TaskItem TI = new TaskItem();

        try {
            TI.SetTitle(title);
        }
        catch (IllegalArgumentException e){
            // Do something if title is > 1 char
            System.out.println("Title must be longer than 1 character");
        }

        TI.SetDescription(description);

        try {
            TI.SetDueDate(dueDate);
        } catch (DateTimeParseException e) {
            // Do something if due date isn't parsable
            System.out.println("Please enter a date in the form YYYY-MM-DD");
        }

        return TI;
    }

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        Scanner scan = new Scanner(System.in);
        MainMenuPrints();

        int choice = -1;

        while (choice != 3) {
            choice = scan.nextInt();

            if (choice == 3) {
                break;
            }

            switch (choice) {
                case 1:
                    CreateNewListMenu(scan);
                    MainMenuPrints();
                    break;
                case 2:
                    LoadExistingList(scan);
                    MainMenuPrints();
                    break;
                default:
                    System.out.println("Please choose a valid option");
            }
        }
    }



    private static void CreateNewListMenu (Scanner scan) {
        TaskList taskList= new TaskList();
        System.out.println("A new list has been created\n");
        NewListMenuPrints();

        int choice = -1;

        while (choice != 8) {
            choice = scan.nextInt();

            if (choice == 8){
                break;
            }

            switch (choice) {
                case 1:
                    ViewTaskList(taskList);
                    NewListMenuPrints();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

    private static void ViewTaskList(TaskList taskList) {
        System.out.println("Current tasks");
        System.out.println("-------------");
        for (TaskItem ti: taskList.GetTaskItems()) {
            ti.toString();
        }
        System.out.printf("\n\n");
    }

    private static void LoadExistingList(Scanner scan) {
        System.out.println("Enter the filename to load: ");
        // Perform some file IO
        String fileName = scan.nextLine();
        System.out.println(fileName + " was successfuly loaded");
    }


    // Print helper methods
    private static void NewListMenuPrints() {
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

    private static void MainMenuPrints() {
        System.out.println("Main Menu");
        System.out.println("----------\n");
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Quit");
    }

}
