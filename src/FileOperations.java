import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * FileOperations class contains different methods for operating with the
 * CSV-file.
 *
 * Methods in the class proceed to:
 *      - get count of lines (contacts) in the file.
 *      - storing data from the csv to a String[][]-array.
 *      - writing the String[][] array into the CSV in correct form.
 *      - printing the CSV-files data (contacts) in a easy-to-read form.
 *      - tell if CSV-file already has contacts in it.
 *
 * @author dmitry-nazarov22
 */
public final class FileOperations {
    /**
     * represents the quantity of data that a contact can have.
     * Containing: placeHolder, ID, firstName, lastName, phone, address, email
     */
    private static final int NO_AMOUNTOFDATA = 7;

    private FileOperations() {
        //not called
    }
    /**
     * Method proceeds to give the count of every line (contact) in the CSV.
     *
     * Starting by creating BufferedReader and giving it access to the
     * contacts.csv it reads the file line by line and adds allLines counter by
     * one after. Proceeds this until the next line doesn't contain anything.
     *
     * @return allLines counter that displays the count of lines in a CSV.
     */
    public static int linesFromFile() {
        int allLines = 0;

        try {
                BufferedReader br =
                new BufferedReader(new FileReader("contacts.csv"));
                while ((br.readLine()) != null) {
                    allLines++;
                }
                br.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
        }
        return allLines;
    }
    /**
     * Method to store data from the CSV-file to an String[][] array.
     *
     * Adding all data from the CSV to a 2D-array in a correct form.
     *
     * Starts by creating BufferedReader and giving it access to the
     * contacts.csv defining every row with the corresponding int-value.
     * In a while(line != null) -loop splits all the data from given line to
     * the String[] value-array by finding "," -splitter and defining 7
     * different data-iterations.
     * After filling them into the allContacts[][] -array on the given row.
     *
     * @return allContacts-array, which contains all the contact-data.
     */
    public static String[][] csvToArray() {
        int linesSum = linesFromFile();
        String line = "";
        String[][] allContacts = new String[linesSum][NO_AMOUNTOFDATA];

        try {
            BufferedReader br =
            new BufferedReader(new FileReader("contacts.csv"));
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",", NO_AMOUNTOFDATA);
                allContacts[row] = value;
                row++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allContacts;
    }
    /**
     * Method to write an array to a CSV-file in the correct form.
     *
     * Starting by creating FileWriter and giving it access to the contacts.csv
     * proceeds to the 2D-for-loop to write every contact-data to the file.
     *
     * Goes through all places adding the data or "" to the file if the data is
     * missing and "," marker after every added data except the last for
     * dividing them from one another as in CSV. After every contacts adds "\n",
     * for the next contact to be added.
     *
     * @param input array to be written to the CSV-file.
     * @throws IOException throws this error, if the file cannot be found in the
     * src folder.
     */
    public static void writeArray(final String[][] input) throws IOException {

        FileWriter fw = new FileWriter("contacts.csv");

        final int beforeLast = 6;

        try {
            for (int i = 0; i < input.length; i++) {
                for (int o = 0; o < NO_AMOUNTOFDATA; o++) {
                    if (input[i][o] != null) {
                        fw.write(input[i][o]);
                    } else {
                    fw.write("");
                    }
                    if (o != beforeLast) { // if isn't last
                        fw.write(",");
                    }
                }
            fw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fw.close();
    }
    /**
     * Method to print the data from the CSV in an easy-to-read form.
     *
     * Starts by storing all the data from the file to a toPrint 2D-array by
     * using method above and proceeds to a 2D-for-loop to go through every
     * iteration on the array.
     * For-loops contain switch case, which has unique print to every
     * data-value, so that it is easy to read from the CLI.
     *
     */
    public static void read() {
        int linesSum = linesFromFile();
        String[][] toPrint = csvToArray();

        final int noPlaceHolder = 0;
        final int noID = 1;
        final int noFirstName = 2;
        final int noLastName = 3;
        final int noPhone = 4;
        final int noAddress = 5;
        final int noEmail = 6;

        System.out.println("Contacts:");
        System.out.println("_____________________________________________\n");

        for (int i = 0; i < linesSum; i++) {
            for (int o = 0; o < NO_AMOUNTOFDATA; o++) {
                switch (o) {
                    case noPlaceHolder:
                        System.out.println(toPrint[i][o]);
                        break;
                    case noID:
                        System.out.println("ID:            " + toPrint[i][o]);
                        break;
                    case noFirstName:
                        System.out.println("First name:    " + toPrint[i][o]);
                        break;
                    case noLastName:
                        System.out.println("Last name:     " + toPrint[i][o]);
                        break;
                    case noPhone:
                        System.out.println("Phone:         " + toPrint[i][o]);
                        break;
                    case noAddress:
                        System.out.println("Address:       " + toPrint[i][o]);
                        break;
                    case noEmail:
                        System.out.println("E-mail:        " + toPrint[i][o]);
                        break;
                    default:
                        // not called
                }
            }
            System.out.println("_____________________________________________");
            System.out.println();
        }
    }
    /**
     * Method to review if the csv-file already has contacts.
     *
     * Method reads the first line of a file and return true if it isn't null.
     * If it is null (doesn't contain any files), returns false.
     *
     * @return true if the csv has contacts and false if doesn't.
     */
    public static boolean ifContacts() {
        try {
                BufferedReader br =
                new BufferedReader(new FileReader("contacts.csv"));
                if ((br.readLine()) != null) {
                    return true;
                }
                br.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
        }
        return false;
    }
}
