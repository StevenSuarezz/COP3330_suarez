import java.text.ParseException;

public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email) throws ParseException, IllegalArgumentException {
        setName(firstName, lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        validateContact();
    }


    public void validateContact() throws IllegalArgumentException {
        if(firstName.equals("") && lastName.equals("") && phoneNumber.equals("") && email.equals(""))
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        String contact = "Name: " + firstName + " " + lastName + "\n";
        contact += "Phone: " + phoneNumber + "\n";
        contact += "Email: " + email;

        return contact;
    }

    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) throws ParseException {
        if(!phoneNumber.equals(""))
        {
            if (phoneNumber.length() < 7 || phoneNumber.charAt(3) != '-' || phoneNumber.charAt(7) != '-') {
                throw new ParseException("Please enter a valid phone number", 0);
            }
        }

        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) throws ParseException {
        int atIndex = email.lastIndexOf("@");
        int dotIndex = email.lastIndexOf(".");
        if (!email.equals("") && atIndex == -1 || dotIndex == -1 || dotIndex < atIndex){
            throw new ParseException("Please enter a valid email", 0);
        }

        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
