/**
 * ContactsUI class contains the CLI UI of the app.
 *
 * Class contains three methods to put everything pasted in the CLI inside the
 * more easy to look-at borders.
 *
 * @author dmitry-nazarov22
 */
public final class ContactsUI {
    /**
     * represents the quantity of data that a contact can have.
     * Containing: placeHolder, ID, firstName, lastName, phone, address, email
     */
    private static final int NO_AMOUNTOFDATA = 7;
    /**
     * position of placeHolder in the array.
     */
    private static final int NO_PLACEHOLDER = 0;
    /**
     * position of ID in the array.
     */
    private static final int NO_ID = 1;
    /**
     * position of firstName in the array.
     */
    private static final int NO_FIRSTNAME = 2;
    /**
     * position of lastName in the array.
     */
    private static final int NO_LASTNAME = 3;
    /**
     * position of phone number in the array.
     */
    private static final int NO_PHONE = 4;
    /**
     * position of address in the array.
     */
    private static final int NO_ADDRESS = 5;
    /**
     * position of email in the array.
     */
    private static final int NO_EMAIL = 6;
    /**
     * The message displayed when any process is started to have access, to
     * stop it without saving.
     */


    private ContactsUI() {
        // not called
    }
    /**
     * This method contains the basic UI of the Contacts App.
     *
     * Simply printing it to the CLI in the given form for the ContactsApp class
     * to use.
     */
    public static void mainUI() {
        System.out.println("""
                   Contacts
        ______________________________

        Options:
            --------------------------
            | 1 - Read contacts      |
            | 2 - Create new contact |
            | 3 - Update contact     |
            | 4 - Delete contact     |
            | 5 - Quit.              |
            --------------------------
        """);
    }
    /**
     * Method contains process of printing a list of all contacts.
     *
     * Method prints contacts placeholder and full name (last name + first name)
     * and does that in easy to look-at borders.
     *
     * First it defines the longest string that can be inside the borders.
     * Then prints the borders and needed data with using
     * pasteSpaces()-method to get enough
     * spaces afterwards.
     *
     */
    public static void contactVariants() {
        int contactCount = FileOperations.linesFromFile();
        String[][] contactList = FileOperations.csvToArray();
        // Defining longest String
        int longest = 0;
        for (int i = 0; i < contactCount; i++) {
            String toCompare = "    | "
                               + contactList[i][NO_PLACEHOLDER]
                               + "    "
                               + contactList[i][NO_LASTNAME]
                               + " "
                               + contactList[i][NO_FIRSTNAME];
            if (toCompare.length() > longest) {
                longest = toCompare.length();
            }
        }

        // Border
        System.out.print("    ");
        for (int i = 0; i < longest - 2; i++) {
            System.out.print("-");
        }
        System.out.println();
        // Contacts with borders
        for (int i = 0; i < contactCount; i++) {
            String toPrint = "    | "
                             // placeHolder
                             + contactList[i][NO_PLACEHOLDER]
                             + "    "
                             // lastName
                             + contactList[i][NO_LASTNAME]
                             + " "
                             //firstName
                             + contactList[i][NO_FIRSTNAME];
            System.out.print(toPrint);
            System.out.print(pasteSpaces(toPrint, longest));
            System.out.println("|");
        }
        // Border
        System.out.print("    ");
        for (int i = 0; i < longest - 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    /**
     * Method contains process of printing a list of all data of one contact.
     *
     * Method prints contacts data and does that in easy to look-at borders.
     *
     * First it defines the longest string that can be inside the borders.
     * The pattern has "x" corresponding the number of data it takes.
     * Also "longest" -int gets +10 to its value. That happens because
     * of the longest possible pattern, which is CASE 2 ("First name").
     *
     * Then prints the borders and needed data using for-loop and switch-case
     * and using pasteSpaces() -method to get enough spaces afterwards.
     *
     * @param choice1 choice1 made in the updateContact() method.
     */
    public static void dataVariants(final int choice1) {
        String[][] contactList = FileOperations.csvToArray();
        String[] array = new String[NO_AMOUNTOFDATA - 1];
        String toPrint = "";

        // Putting every string to array:
        for (int i = 1; i < NO_AMOUNTOFDATA; i++) {
            switch (i) {
                case NO_ID:
                    toPrint = "    | 1 – ID:            "
                              + contactList[choice1][i];
                    array[NO_ID - 1] = toPrint;
                    break;
                case NO_FIRSTNAME:
                    toPrint = "    | 2 – First name:    "
                              + contactList[choice1][i];
                    array[NO_FIRSTNAME - 1] = toPrint;
                    break;
                case NO_LASTNAME:
                    toPrint = "    | 3 – Last name:     "
                              + contactList[choice1][i];
                    array[NO_LASTNAME - 1] = toPrint;
                    break;
                case NO_PHONE:
                    toPrint = "    | 4 – Phone:         "
                              + contactList[choice1][i];
                    array[NO_PHONE - 1] = toPrint;
                    break;
                case NO_ADDRESS:
                    toPrint = "    | 5 – Address:       "
                              + contactList[choice1][i];
                    array[NO_ADDRESS - 1] = toPrint;
                    break;
                case NO_EMAIL:
                    toPrint = "    | 6 – E-mail:        "
                              + contactList[choice1][i];
                    array[NO_EMAIL - 1] = toPrint;
                    break;
                default:
                    //not called
            }
        }

        // Defining longest String
        int longest = 0;
        for (int i = 0; i < NO_AMOUNTOFDATA - 1; i++) {
            if (array[i].length() > longest) {
                longest = array[i].length();
            }
        }

        // Border
        System.out.print("    ");
        for (int i = 0; i < longest - 2; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Data in borders

        for (int i = 0; i < NO_AMOUNTOFDATA - 1; i++) {
            System.out.print(array[i]);
            System.out.print(pasteSpaces(array[i], longest));
            System.out.println("|");
        }

        // Border
        System.out.print("    ");
        for (int i = 0; i < longest - 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    /**
     * Method contains the process of giving String of spaces of needed
     * quantity.
     *
     * Method gives the maximum value of spaces in integer-longest and the
     * String-toCompare to define needed spaces for this particular String.
     * First it calculates needed spaces by substracting toCompare-length from
     * longest and then goes through simple for-loop inserting spaces to the
     * toReturn-String.
     *
     * @param toCompare String which length will be compared to the longest
     *                  to define the needed amount of spaces.
     * @param longest value of the maximum amount of spaces.
     * @return toReturn String containing of spaces.
     */
    public static String pasteSpaces(final String toCompare,
                                     final int longest) {
        int howManySpaces = longest - toCompare.length();
        String toReturn = "";
        for (int o = 0; o <= howManySpaces; o++) {
            toReturn += " ";
        }
        return toReturn;
    }
}
