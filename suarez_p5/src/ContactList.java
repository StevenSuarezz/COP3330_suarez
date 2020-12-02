import java.text.ParseException;
import java.util.ArrayList;

public class ContactList {
    private ArrayList<ContactItem> contactItems;

    public ContactList(){
        this.contactItems = new ArrayList<>();
    }

    public void addContact(ContactItem contactItem) {
        contactItems.add(contactItem);
    }

    public void removeContact(int index) {
        contactItems.remove(index);
    }

    public ArrayList<ContactItem> getContactItems() {
        return contactItems;
    }

    public ContactItem getContactItemByIndex(int index) {
        return contactItems.get(index);
    }

    public void editItemName(int index, String newFirstName, String newLastName) {
        contactItems.get(index).setName(newFirstName, newLastName);
    }

    public void editItemPhoneNumber(int index, String newPhoneNumber) throws ParseException {
        contactItems.get(index).setPhoneNumber(newPhoneNumber);
    }

    public void editItemEmail(int index, String newEmail) throws ParseException {
        contactItems.get(index).setEmail(newEmail);
    }
}
