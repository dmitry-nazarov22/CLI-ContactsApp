import java.io.Console;

/**
 * Contact class is a Contact object and stores various methods to create a
 * contact.
 *
 * Containing create() method which simply goes through every variable that
 * could be set for a contact and calling their respective setters for
 * validation and returning an array of all in all for the contact to be
 * written.
 *
 * @author dmitry-nazarov22
 */
public class Contact {
    /**
     * Finnish Identification Number [mandatory].
     */
    private String id;
    /**
     * First name of a contact [mandatory].
     */
    private String firstName;
    /**
     * Last name of a contact [mandatory].
     */
    private String lastName;
    /**
     * Phone number of a contact [mandatory].
     */
    private String phone;
    /**
     * Finnish street address of a contact [optional].
     */
    private String address; // optional
    /**
     * E-mail address of a contact [optional].
     */
    private String email; // optional
    /**
     * Contains the creation process of a new Contact object.
     *
     * Method goes through every variable that Contact can have and asks to
     * enter values for the respective setter-methods to handle them on.
     *
     * Has four mandatory variables to fill and two optional variables. Before
     * setting the optionals asks if inputting them is wanted.
     *
     * @return New created contact.
     */
    public static Contact create() {
        Console c = System.console();

        String input;
        // Mandatory
        Contact newContact = new Contact();
        System.out.println("Enter ID: [DDMMYYCZZZQ]");
        input = c.readLine();
        newContact.setID(input);
        System.out.println("Enter first name:");
        input = c.readLine();
        newContact.setFirstName(input);
        System.out.println("Enter last name:");
        input = c.readLine();
        newContact.setLastName(input);
        System.out.println("Enter phone number: [+358xxxxxxxxx]");
        input = c.readLine();
        newContact.setPhone(input);
        // Optional
        System.out.println("Do you want to enter address? [y, n]");
        if (Validation.choiceYesOrNo()) {
            System.out.println(
                               "Enter address: [Esimerkkikatu 1 12345 Tampere]"
                               );
            input = c.readLine();
            newContact.setAddress(input);
        }
        System.out.println("Do you want to enter e-mail? [y, n]");
        if (Validation.choiceYesOrNo()) {
            System.out.println("Enter e-mail: [example@mail.com]");
            input = c.readLine();
            newContact.setEmail(input);
        }
         return newContact;
    }
    /**
     * Contains the process of setting every variable of a contact to a
     * String[] array.
     *
     * Handles every variable filling NULL values if data is missing.
     *
     * @return the array containing every variable of a contact.
     */
    public String[] toArray() {
        final int amountOfVariables = 6;
        final int placeID = 0;
        final int placeFirstName = 1;
        final int placeLastName = 2;
        final int placePhone = 3;
        final int placeAddress = 4;
        final int placeEmail = 5;
        String[] array = new String[amountOfVariables];
            array[placeID] = id;
            array[placeFirstName] = firstName;
            array[placeLastName] = lastName;
            array[placePhone] = phone;
            array[placeAddress] = address;
            array[placeEmail] = email;
            return array;
    }
    /**
     * Setter-method for the ID variable.
     *
     * Sets the given String to the ID variable if it passes the validation.
     * If not, then asks again and goes through validation as many times as
     * needed.
     *
     * Using while(true) loop, that breaks, when needed String is achieved.
     *
     * @param newID String representing contacts ID-number to be set.
     */
    public void setID(final String newID) {
        Console c = System.console();
        String input = newID;
        while (true) {
            if (Validation.isIDValid(input)) {
                this.id = input;
                break;
            } else {
                System.out.println("Enter valid ID [DDMMYYCZZZQ]");
                input = c.readLine();
            }
        }
    }
    /**
     * Setter-method for the firstName variable.
     *
     * Sets the given String to the firstName variable if it passes the
     * validation. If not, then asks again and goes through validation as many
     * times as needed.
     *
     * Using while(true) loop, that breaks, when needed String is achieved.
     *
     * @param newFirstName String representing contacts first name to be set.
     */
    public void setFirstName(final String newFirstName) {
        Console c = System.console();
        String input = newFirstName;
        while (true) {
            if (Validation.isNameValid(input)) {
                this.firstName = input;
                break;
            } else {
                System.out.println(
                "Enter valid first name [more than one character]"
                );
                input = c.readLine();
            }
        }
    }
    /**
     * Setter-method for the lastName variable.
     *
     * Sets the given String to the lastName variable if it passes the
     * validation. If not, then asks again and goes through validation as many
     * times as needed.
     *
     * Using while (true) loop, that breaks, when needed String is achieved.
     *
     * @param newLastName String representing contacts last name to be set.
     */
    public void setLastName(final String newLastName) {
        Console c = System.console();
        String input = newLastName;
        while (true) {
            if (Validation.isNameValid(input)) {
                this.lastName = input;
                break;
            } else {
                System.out.println(
                "Enter valid last name [more than one character]"
                );
                input = c.readLine();
            }
        }
    }
    /**
     * Setter-method for the phone variable.
     *
     * Sets the given String to the phone variable if it passes the validation.
     * If not, then asks again and goes through validation as many times as
     * needed.
     *
     * Using while (true) loop, that breaks, when needed String is achieved.
     *
     * @param newPhone String representing contacts phone number to be set.
     */
    public void setPhone(final String newPhone) {
        Console c = System.console();
        String input = newPhone;
        while (true) {
            if (Validation.isPhoneValid(input)) {
                this.phone = input;
                break;
            } else {
                System.out.println("Enter valid phone [+358xxxxxxxxx]");
                input = c.readLine();
            }
        }
    }
    /**
     * Setter-method for the address variable.
     *
     * Sets the given String to the address variable if it passes the
     * validation. If not, then asks again and goes through validation as many
     * times as needed.
     *
     * Using while(true) loop, that breaks, when needed String is achieved.
     *
     * @param newAddress String representing contacts address to be set.
     */
    public void setAddress(final String newAddress) {
        Console c = System.console();
        String input = newAddress;
        while (true) {
            if (Validation.isAddressValid(input)) {
                this.address = input;
                break;
            } else {
                System.out.println(
                "Enter valid address [Esimerkkikatu 1 12345 Tampere]"
                );
                input = c.readLine();
            }
        }
    }
    /**
     * Setter-method for the email variable.
     *
     * Sets the given String to the email variable if it passes the validation.
     * If not, then asks again and goes through validation as many times as
     * needed.
     *
     * Using while(true) loop, that breaks, when needed String is achieved.
     *
     * @param newEmail String representing contacts e-mail to be set.
     */
    public void setEmail(final String newEmail) {
        Console c = System.console();
        String input = newEmail;
        while (true) {
            if (Validation.isEmailValid(input)) {
                this.email = input;
                break;
            } else {
                System.out.println("Enter valid e-mail [example@email.fi]");
                input = c.readLine();
            }
        }
    }
}
