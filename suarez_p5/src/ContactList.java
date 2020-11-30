import java.util.ArrayList;

public class ContactList {
    private ArrayList<ContactItem> contactItems;

    public ContactList(){
        this.contactItems = new ArrayList<>();
    }

    public void addTask(ContactItem contactItem) {
        contactItems.add(contactItem);
    }

    public void removeTask(int index) {
        contactItems.remove(index);
    }

    public ArrayList<ContactItem> getContactItems() {
        return contactItems;
    }

}
