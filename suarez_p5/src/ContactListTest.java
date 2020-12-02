import org.junit.jupiter.api.Test;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingContactItemsIncreasesSize() {
        ContactList cl = new ContactList();
        try {
            cl.addContact(new ContactItem("first", "last", "", ""));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        assertEquals(1, cl.getContactItems().size());
    }

    @Test
    public void creatingItemsFailsWithAllBlankValues() {
        ContactList cl = new ContactList();
        assertThrows(IllegalArgumentException.class,() -> cl.addContact(new ContactItem("", "", "", "")));
    }

    @Test
    public void editingContactItemFailsWithInvalidIndex() {
        ContactList cl = new ContactList();
        try {
            cl.addContact(new ContactItem("First", "", "", ""));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        assertThrows(IndexOutOfBoundsException.class,() -> cl.editItemName(1, "New First", "New Last"));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList cl = new ContactList();
        try {
            cl.addContact(new ContactItem("first", "last", "000-000-0000", "x@y.z"));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        cl.editItemName(0,"", "");
        assertEquals("", cl.getContactItemByIndex(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList cl = new ContactList();
        try {
            cl.addContact(new ContactItem("first", "last", "000-000-0000", "x@y.z"));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        cl.editItemName(0,"", "");
        assertEquals("", cl.getContactItemByIndex(0).getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList cl = new ContactList();
        try {
            cl.addContact(new ContactItem("first", "last", "000-000-0000", "x@y.z"));
            cl.editItemPhoneNumber(0,"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("", cl.getContactItemByIndex(0).getPhoneNumber());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactList cl = new ContactList();
        try {
            cl.addContact(new ContactItem("first", "last", "000-000-0000", "x@y.z"));
            cl.editItemEmail(0,"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("", cl.getContactItemByIndex(0).getEmail());
    }
}