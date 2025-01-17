import java.io.IOException;

/**
 * ContactsApp class provides a Contacts App
 *
 * This program manages user-given contact-information by saving it
 * into a CSV-file precisely without losing any information before quitting.
 *
 * Program provides four different use scenarios:
 *      - reading all saved contacts.
 *      - adding a new contact.
 *      - updating data to an already existing contact.
 *      - deleting a contact.
 *      - also of course quitting the program.
 *
 * @author dmitry-nazarov22
 * @version 1.0
 *
 */
public final class ContactsApp {
    private ContactsApp() {
        // not called
    }
    /**
     * Main method contains the core of the app calling the UI and user-asked
     * functions until is told to quit the app.
     *
     * The "menu" is implemented using user-input from the validation method and
     * switch-case to call every needed choice.
     *
     * @param args Not used in this method.
     * @throws IOException Handles
     */
    public static void main(final String[] args) throws IOException {
        final int read = 1;
        final int add = 2;
        final int update = 3;
        final int delete = 4;
        final int quit = 5;
        boolean isQuit = true;
        while (isQuit) {

            ContactsUI.mainUI();

            switch (Validation.validMenuChoice(read, quit)) {
                case read:
                    if (FileOperations.ifContacts()) {
                        FileOperations.read();
                    } else {
                        System.out.println("No contacts to read");
                        System.out.println();
                    }
                    break;
                case add:
                    String[][] afterAdd = ContactManager.addContact();
                    FileOperations.writeArray(afterAdd);
                    System.out.println("\nContact added succesfully!\n");
                    break;
                case update:
                    if (FileOperations.ifContacts()) {
                        String[][] afterUpd = ContactManager.updateContact();
                        FileOperations.writeArray(afterUpd);
                        System.out.println("\nContact updated succesfully!\n");
                    } else {
                        System.out.println("No contacts to update");
                        System.out.println();
                    }
                    break;
                case delete:
                    if (FileOperations.ifContacts()) {
                        String[][] afterDel = ContactManager.deleteContact();
                        FileOperations.writeArray(afterDel);
                        System.out.println("\nContact deleted succesfully!\n");
                    } else {
                        System.out.println("No contacts to delete");
                        System.out.println();
                    }
                    break;
                case quit:
                    isQuit = false;
                    System.out.println("\nQuitting.");
                    break;
                default:
                    // not called
            }
        }
    }
}
