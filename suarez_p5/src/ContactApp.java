import java.io.*;
import java.text.ParseException;
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
        System.out.print("Enter the filename to load: ");
        scan.nextLine();
        String filePath = System.getProperty("user.dir") + "\\" + scan.nextLine();
        String line;

        ContactList contactList = new ContactList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                contactList.addContact(new ContactItem(values[0], values[1], values[2], values[3]));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Make sure your spelling is correct and/or that the file exists and try again.");
        } catch (Exception e) {
            System.out.println("Error loading file. Load aborted.");
        }

        System.out.println("Contact list was successfully loaded\n");

        contactListOperationMenu(scan, contactList);
    }

    private void createNewContactListMenu(Scanner scan) {
        ContactList contactList = new ContactList();
        System.out.println("A new list has been created\n");
        contactListOperationMenu(scan, contactList);
    }

    private void contactListOperationMenu(Scanner scan, ContactList contactList) {
        newContactListMenuPrints();

        int choice = -1;

        while (choice != 8) {

            try {
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        viewContactList(contactList);
                        newContactListMenuPrints();
                        break;
                    case 2:
                        addItemToList(scan, contactList);
                        newContactListMenuPrints();
                        break;
                    case 3:
                        editItem(scan, contactList);
                        newContactListMenuPrints();
                        break;
                    case 4:
                        removeItem(scan, contactList);
                        newContactListMenuPrints();
                        break;
                    case 7:
                        saveListToTxtFile(scan, contactList);
                        newContactListMenuPrints();
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Please choose a valid option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option\n");
                scan.nextLine();
                newContactListMenuPrints();
            }
        }
    }

    private void saveListToTxtFile(Scanner scan, ContactList contactList) {
        if(contactList.getContactItems().size() == 0)
        {
            System.out.print("There are no contacts in your list. Please create one.\n");
            return;
        }

        System.out.print("Enter a file name: ");
        scan.nextLine();
        String fileName = System.getProperty("user.dir") + "\\" + scan.nextLine();

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for(ContactItem ci : contactList.getContactItems()) {
                writer.write(ci.getFirstName() + "," + ci.getLastName() + "," + ci.getPhoneNumber() + "," + ci.getEmail() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving to file, save aborted");
            return;
        }

        System.out.println("The contact list has been saved to: " + fileName + "\n");
    }

    private void removeItem(Scanner scan, ContactList contactList) {
        if(contactList.getContactItems().size() == 0)
        {
            System.out.print("There are no contacts in your list. Please create one.\n");
            return;
        }

        viewContactList(contactList);

        System.out.print("Which task would you like to remove? ");
        try{
            int choice = scan.nextInt();
            contactList.removeContact(choice);
            System.out.print("\n");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Please select a valid contact to remove\n");
        }

    }

    private void addItemToList(Scanner scan, ContactList contactList) {
        ContactItem contactItem;
        scan.nextLine(); // Clear buffer

        System.out.print("First name: ");
        String firstName = scan.nextLine();

        System.out.print("Last name: ");
        String lastName = scan.nextLine();

        System.out.print("Phone number (xxx-xxx-xxxx): ");
        String phone = scan.nextLine();

        System.out.print("Email address (x@y.z): ");
        String email = scan.nextLine();

        try {
            contactItem = new ContactItem(firstName, lastName, phone, email);
            contactList.addContact(contactItem);
        } catch (IllegalArgumentException titleException) {
            System.out.println("WARNING: Contact must have a first or last name, a phone number, or an email.");
        } catch (ParseException parseException) {
            System.out.println("WARNING: " + parseException.getMessage());
        }
        System.out.print("\n");
    }

    private void viewContactList(ContactList contactList) {
        if(contactList.getContactItems().size() == 0)
        {
            System.out.print("There are no contacts in your list. Please create one.\n");
            return;
        }

        System.out.print("\n");
        System.out.println("Current contacts");
        System.out.println("-------------");


        for (int i = 0; i < contactList.getContactItems().size(); i++) {
            System.out.println(i + ") " + contactList.getContactItemByIndex(i).toString());
        }

        System.out.print("\n\n");
    }

    private void editItem(Scanner scan, ContactList contactList) {
        if(contactList.getContactItems().size() == 0)
        {
            System.out.print("There are no contacts in your list. Please create one.\n");
            return;
        }

        viewContactList(contactList);

        System.out.print("Which contact would you like to edit? ");
        try {
            int choice = scan.nextInt();
            contactList.getContactItemByIndex(choice); // Check for an index out of bounds error before continuing
            scan.nextLine(); // Clear buffer

            System.out.print("Enter a new first name for contact " + choice + ": ");
            String newFirstName = scan.nextLine();

            System.out.print("Enter a new last name for contact " + choice + ": ");
            String newLastName = scan.nextLine();

            System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact  " + choice + ": ");
            String newPhoneNumber = scan.nextLine();

            System.out.print("Enter a new email address (x@y.z) for contact " + choice + ": ");
            String newEmail = scan.nextLine();

            contactList.editItemName(choice, newFirstName, newLastName);
            contactList.editItemPhoneNumber(choice, newPhoneNumber);
            contactList.editItemEmail(choice, newEmail);
            contactList.getContactItemByIndex(choice).validateContact();

        } catch (IllegalArgumentException argException) {
            System.out.println("WARNING: Contact must contain at least a name, phone, or email; contact not edited");
        } catch (ParseException parseException) {
            System.out.println("WARNING: " + parseException.getMessage() + "; Contact not edited");
        } catch (IndexOutOfBoundsException indexException) {
            System.out.println("Please select a valid task to edit\n");
        }
        System.out.print("\n");
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
