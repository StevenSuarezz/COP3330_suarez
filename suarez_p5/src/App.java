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
                        TaskApp taskApplication = new TaskApp(scan);
                        mainMenuPrints();
                        break;
                    case 2:
                        contactList(scan);
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

    private void mainMenuPrints(){
        System.out.println("Select your application");
        System.out.println("-----------------------\n");
        System.out.println("1) Task list");
        System.out.println("2) Contact list");
        System.out.println("3) Quit");
    }



}
