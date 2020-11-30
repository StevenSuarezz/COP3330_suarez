import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    public ContactApp(Scanner scan) {
        this.contactList(scan);
    }

    private void contactList(Scanner scan) {
        listMenuPrints();

        int choice = -1;

        while (choice != 3) {
            try {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        createNewContactListMenu(scan);
                        listMenuPrints();
                        break;
                    case 2:
                        loadExistingContactList(scan);
                        listMenuPrints();
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

    private void loadExistingContactList(Scanner scan) {
    }

    private void createNewContactListMenu(Scanner scan) {
    }

    private void newContactListMenuPrints() {
        System.out.println("List Operation Menu");
        System.out.println("-------------------\n");
        System.out.println("1) View the list");
        System.out.println("2) Add an item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to the main menu");
    }

    private void listMenuPrints() {
        System.out.println("Main Menu");
        System.out.println("----------\n");
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Quit");
    }
}
