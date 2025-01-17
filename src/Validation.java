import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Console;

/**
 * Validation class
 *
 * Class has methods for validating different user-given inputs to match the
 * correct form.
 * Also two methods for different choices between simple Yes or No and more
 * complex menu variant with different number of choices.
 *
 * @author dmitry-nazarov22
 */
public final class Validation {
    private Validation() {
        // not called
    }
    /**
     * Method contains validation of the Finnish ID process.
     *
     * Method validates given String containing Finnish ID number by using
     * regex pattern that contains
     *      - 6 digits (DDMMYY of birth)
     *      - separator a-zA-Z- (century of birth)
     *      - 3 digits (individual number; even for women, odd for men)
     *      - control character a-zA-Z0-9
     * and tested after using various IDs.
     * @param id String to be validated using regex. Represents ID.
     * @return isValid boolean, which tells if the inputted ID has passed
     *         or not.
     */
    public static boolean isIDValid(final String id) {
        Pattern pattern = Pattern.compile(
        "^\\d{6}[a-zA-Z-]\\d{3}[a-zA-Z0-9]{1}$"
        );
        Matcher matcher = pattern.matcher(id);
        boolean isValid = matcher.find();
        return isValid;
    }
    /**
     * Method contains validation of the name process.
     *
     * Method validates given String containing name by using
     * regex pattern that has only latin-letters and scandinavic characters.
     * Doesn't pass any special characters, numbers etc.
     * Also name must contain more than one character but isn't case sensitive.
     * @param name String to be validated using regex. Represents name.
     * @return isValid boolean, which tells if the inputted name has passed
     *         or not.
     */
    public static boolean isNameValid(final String name) {
        Pattern pattern = Pattern.compile("^[\\sa-zA-ZåäöÅÄÖ]*$");
        Matcher matcher = pattern.matcher(name);
        boolean containsChars = matcher.find();

        if (name.length() > 1 && containsChars) {
            return true;
        }
        return false;
    }
    /**
     * Method contains validation of the phone number process.
     *
     * Method validates given String containing phone number by using
     * regex pattern that contains finnish phone code "+358" or "0" and the
     * unique number starting with one digit from 1-9 and 8 digits after.
     * Tested by multiple example variants.
     * @param phone String to be validated using regex. Represents phone number.
     * @return isValid boolean, which tells if the inputted phone number
     *         has passed or not.
     */
    public static boolean isPhoneValid(final String phone) {
        Pattern pattern = Pattern.compile(
        "^\\+358[1-9][0-9]{8}|0[1-9][0-9]{4,11}$"
        );
        Matcher matcher = pattern.matcher(phone);
        boolean isValid = matcher.find();
        return isValid;
    }
    /**
     * Method contains validation of the Finnish street address process.
     *
     * Method validates given String containing street address by using
     * regex pattern that contains:
     *      - the street name with possible spaces and multiple words.
     *      - the number of the building with optionally followed with the
     *        entrance letter and apartment number (spaces allowed).
     *      - postal code (5 numbers in Finland).
     *      - town with any amount of letters but without spaces and special
     *        characters (Finland has only towns without spaces).
     *
     * Also has an option to input empty string.
     *
     * @param address String to be validated using regex. Represents address.
     * @return isValid boolean, which tells if the inputted address has passed
     *         or not.
     */
    public static boolean isAddressValid(final String address) {
        Pattern pattern =
        Pattern.compile(
        "^$|^[\\sa-zA-ZåäöÅÄÖ]+ \\d+[A-Za-z\\s\\d]*? \\d{5} [\\sa-zA-ZåäöÅÄÖ]+$"
        );
        Matcher matcher = pattern.matcher(address);
        boolean isValid = matcher.find();
        return isValid;
    }
    /**
     * Method contains validation of the e-mail process.
     *
     * Method validates given String containing e-mail by using
     * regex pattern that contains the emails structure by using pattern that
     * contains
     *      - at least one word character (which means any letter, digit or
     *        underscore) or dot or dash
     *      - '@' sign
     *      - at least one letter or dash
     *      - '.' and the last part of 2 to 3 letters
     * and tested after by multiple example variants.
     *
     * Also has an option to input empty string.
     *
     * @param email String to be validated using regex. Represents e-mail.
     * @return isValid boolean, which tells if the inputted email has passed
     *         or not.
     */
    public static boolean isEmailValid(final String email) {
        Pattern pattern = Pattern.compile(
        "^$|^[\\w-.]+@[a-zA-Z-]+\\.[a-zA-Z]{2,3}$"
        );
        Matcher matcher = pattern.matcher(email);
        boolean isValid = matcher.find();
        return isValid;
    }
    /**
     * Method contains a menu choice validation between given values.
     *
     * Method takes users input and checks if it is between the given min and
     * max. If it is, returns that input, if not, asks for it again and
     * specifies between which numbers the choice must be (if not understood)
     * from the menu UI.
     * Min and max are given when calling the method.
     *
     * @param min minimum value for the menu choice.
     * @param max maximum value for the menu choice.
     * @return user given input value that has gone through validation.
     */
    public static int validMenuChoice(final int min, final int max) {
        Console c = System.console();

        boolean valid = false;
        int input = 0;
        String errMsg =
        "Please input a valid integer [" + min + " <--> " + max + "].";
        do {
            try {
                input = Integer.parseInt(c.readLine());

                if (input >= min && input <= max) {
                    valid = true;
                } else {
                    System.out.println(errMsg);
                }
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        } while (!valid);
        return input;
    }
    /**
     * Method contains the simple choice between Yes or No.
     *
     * Method asks for user input as long as it is either "y" or "n" and returns
     * that as true or false for the simple Yes or No -menu question.
     *
     * @return boolean value of the choice between Yes or No.
     *         "y" = true, "n" = false.
     */
    public static boolean choiceYesOrNo() {
        Console c = System.console();
        String input = "";
        do {
            input = c.readLine();
            if (input.equals("y")) {
                return true;
            } else if (!(input.equals("n"))) {
                System.out.println("Please enter one of the following [y, n]");
            }
        } while (!(input.equals("y") || input.equals("n")));
        return false;
    }
}
