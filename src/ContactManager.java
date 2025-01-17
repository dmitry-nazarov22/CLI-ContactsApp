import java.io.Console;

/**
 * ContactManager class contains three methods to manage the contact-data.
 *
 * Containing three methods to get data from user to CSV-file and other way:
 *      - addContact()
 *      - updateContact()
 *      - deleteContact()
 *
 * @author dmitry-nazarov22
 */
public final class ContactManager {
    /**
     * represents the quantity of data that a contact can have.
     * Containing: placeHolder, ID, firstName, lastName, phone, address, email
     */
    private static final int NO_AMOUNTOFDATA = 7;

    private ContactManager() {
        // not called
    }
    /**
     * Method to add a new contact to the CSV-file.
     *
     * Starts by creating the 2D-arrays and filling oldContacts with all the
     * contacts in the CSV-file, which will be copied to the  allContacts in the
     * for-loop.
     * Then creates a new Contact-object "tmp" and goes through
     * tmp.create()-method.
     * Next for-loop fills tempArray with all the data tmp contains after
     * creation. And after fills allContacts' last free space with the new
     * contact-data in the 2D-for-loop returning allContacts.
     *
     * @return allcontacts array.
     */
    public static String[][] addContact() {
        // contactCount = oldContacts.length
        int contactCount = FileOperations.linesFromFile();
        String[][] oldContacts = FileOperations.csvToArray();
        String[][] allContacts = new String[contactCount + 1][NO_AMOUNTOFDATA];

        for (int contact = 0; contact < contactCount; contact++) {
            for (int data = 0; data < NO_AMOUNTOFDATA; data++) {
                allContacts[contact][data] = oldContacts[contact][data];
            }
        }

        Contact tmp = new Contact();
        tmp = tmp.create();
        String[] tempArray = tmp.toArray();
        for (int o = 0; o < NO_AMOUNTOFDATA; o++) {
            if (o == 0) {
                //placeHolder
                allContacts[contactCount][o] = (contactCount + 1) + ".";
            } else {
                allContacts[contactCount][o] = tempArray[o - 1];
            }
        }
        return allContacts;
    }
    /**
     * Method to update specific contact information from the CSV-file.
     *
     * Starts by asking which contact does user want to update and listing every
     * accessible contact.
     * After user has made the choice1 method lists every data from the contact
     * in an easy-to-read format using ContactsUI.contactVariants() -method
     * and asking what data is to be updated.
     * After choice2 is made proceeds to the switch-case where corresponding to
     * the choice the update is made.
     * Every case has the same loop of inputting new data, validating it, and if
     * the data fails the validation the while(true) loop asks for it to be
     * corrected.
     * After the data passes validation it is inputted in the contactList-array
     * and the array is returned.
     *
     * @return contactList-array with the updated contact-data.
     */
    public static String[][] updateContact() {
        Console c = System.console();

        String[][] contactList = FileOperations.csvToArray();

        System.out.println(
        "Which contact do you want to update? [place integer]\n"
        );

        ContactsUI.contactVariants();
        int choice1 = Validation.validMenuChoice(1, contactList.length) - 1;

        System.out.println("What data do you want to update? [place integer]");
        ContactsUI.dataVariants(choice1);

        final int noID = 1;
        final int noFirstName = 2;
        final int noLastName = 3;
        final int noPhone = 4;
        final int noAddress = 5;
        final int noEmail = 6;

        int choice2 = Validation.validMenuChoice(noID, noEmail);
        String input;

        switch (choice2) {
            case noID:
                System.out.println("Input new ID.");
                input = c.readLine();
                while (true) {
                    if (Validation.isIDValid(input)) {
                        contactList[choice1][choice2] = input;
                        break;
                    } else {
                        System.out.println("Input valid ID [DDMMYYCZZZQ]");
                        input = c.readLine();
                    }
                }
                break;
            case noFirstName:
                System.out.println("Input new first name.");
                input = c.readLine();
                while (true) {
                    if (Validation.isNameValid(input)) {
                        contactList[choice1][choice2] = input;
                        break;
                    } else {
                        System.out.println(
                        "Input valid name [more than one character]"
                        );
                        input = c.readLine();
                    }
                }
                break;
            case noLastName:
                System.out.println("Input new last name.");
                input = c.readLine();
                while (true) {
                    if (Validation.isNameValid(input)) {
                        contactList[choice1][choice2] = input;
                        break;
                    } else {
                        System.out.println(
                        "Input valid name [more than one character]"
                        );
                        input = c.readLine();
                    }
                }
                break;
            case noPhone:
                System.out.println("Input new phone number [+358xxxxxxxxx]");
                input = c.readLine();
                while (true) {
                    if (Validation.isPhoneValid(input)) {
                        contactList[choice1][choice2] = input;
                        break;
                    } else {
                        System.out.println(
                        "Input valid phone number [+358xxxxxxxxx]"
                        );
                        input = c.readLine();
                    }
                }
                break;
            case noAddress:
                System.out.println(
                "Input new address [Esimerkkikatu 1 12345 Tampere]"
                );
                input = c.readLine();
                while (true) {
                    if (Validation.isAddressValid(input)) {
                        contactList[choice1][choice2] = input;
                        break;
                    } else {
                        System.out.println(
                        "Input valid address [Esimerkkikatu 1 12345 Tampere]"
                        );
                        input = c.readLine();
                    }
                }
                break;
            case noEmail:
                System.out.println("Input new e-mail [example@mail.com]");
                input = c.readLine();
                while (true) {
                    if (Validation.isEmailValid(input)) {
                        contactList[choice1][choice2] = input;
                        break;
                    } else {
                        System.out.println(
                        "Input valid e-mail [example@mail.com]"
                        );
                        input = c.readLine();
                    }
                }
                break;
            default:
                // not called
        }
        return contactList;
    }
    /**
     * Method to delete a contact from the CSV-file.
     *
     * Asks for a contact to be deleted and listing every accessible contacts
     * placeHolder and full name (last name + first name).
     *
     * After users choice is validated with Validation.validMenuChoice()-method
     * proceeds to the two-dimensional for-loop in which updated-array gets its
     * placeholders when "data" == 0, and fills with the contactList data when
     * "contact" isn't the one with the "choice".
     *
     * "Counter" -integer is to not mess up with the for-loops filling unwanted
     * contact-information to the updated-array.
     *
     * After the process returns the updated-array.
     *
     * @return updated 2D-array without the unwanted contact.
     */
    public static String[][] deleteContact() {
        Console c = System.console();

        String[][] contactList = FileOperations.csvToArray();
        String[][] updated =
        new String[contactList.length - 1][NO_AMOUNTOFDATA];

        System.out.println(
        "Which contact do you want to delete [place integer]?"
        );

        ContactsUI.contactVariants();

        int choice = Validation.validMenuChoice(1, contactList.length) - 1;
        int counter = 0;

        for (int contact = 0; contact < contactList.length; contact++) {
            for (int data = 0; data < NO_AMOUNTOFDATA; data++) {
                if (contact != choice && data == 0) {
                    updated[counter][data] = (counter + 1) + ".";
                }
                if (contact != choice && data != 0) {
                    updated[counter][data] = contactList[contact][data];
                }
            }
            if (contact != choice) {
                counter++;
            }
        }
        return updated;
    }
}
