import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creatingItemsFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class,() -> new ContactItem("", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        try {
            ContactItem ci = new ContactItem("first", "last", "000-000-0000", "x@y.z");
            assertDoesNotThrow(() -> ci.setName("",""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        try {
            ContactItem ci = new ContactItem("first", "last", "000-000-0000", "x@y.z");
            assertDoesNotThrow(() -> ci.setName("",""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        try {
            ContactItem ci = new ContactItem("first", "last", "000-000-0000", "x@y.z");
            assertDoesNotThrow(() -> ci.setPhoneNumber(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        try {
            ContactItem ci = new ContactItem("first", "last", "000-000-0000", "x@y.z");
            assertDoesNotThrow(() -> ci.setEmail(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}