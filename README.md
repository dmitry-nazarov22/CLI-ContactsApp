# JavaProjectWork-24

Contacts app – for easy handling of Finnish contact-information.

App provides a simple CLI UI to store, edit and manage
contact-information.

## Description

* [LINK TO MY SCREENCAST](https://youtu.be/1IIRuaWblSo)

This program manages user-given contact-information by saving it into a CSV-file precisely without losing any information before quitting.

The contact has: Finnish ID number, first name, last name, phone number, address (optional) and email (optional).

Program provides four different use scenarios:
* reading all saved contacts.
* adding a new contact.
* updating data to an already existing contact.
* deleting a contact.
* also of course quitting the program.

After executing the program it will open up a menu of 5 different choices:
```
    --------------------------
    | 1 - Read contacts      |
    | 2 - Create new contact |
    | 3 - Update contact     |
    | 4 - Delete contact     |
    | 5 - Quit.              |
    --------------------------
```
Managing through menus in this program is as easy as typing the number of choice
to the CLI and pressing Enter.
The program will run as long as user won't tell it to quit by selecting "5" in
the main menu as above ^^.

Validation of choices is implemented, so that any incorrect input will be asked
to be corrected.

The program has six java classes with many methods to categorize different
methods for more intuitive structure.

ContactsApp.java – acts as a core of the program. Calling for different methods to run through the program.

* ContactsUI.java – contains methods for displaying information to the user in the CLI.
  * mainUI()
  * contactVariants()
  * dataVariants()
* Contact.java - is a Contact object and stores various methods to create a contact.
  * create()
  * toArray()
  * setID()
  * setFirstName()
  * setLastName()
  * setPhone()
  * setAddress()
  * setEmail()
* ContactManager.java - contains three methods to manage the contact-data.
  * addContact()
  * updateContact()
  * deleteContact()
* FileOperations.java – contains different methods for operating with the CSV-file.
  * linesFromFile()
  * csvToArray()
  * writeArray()
  * read()
  * ifContacts()
* Validation.java – contains methods for validation of every type of data contact can have.
  * isIDValid()
  * isNameValid()
  * isPhoneValid()
  * isAddressValid()
  * isEmailValid()
  * validMenuChoice()
  * choiceYesOrNo()

## Getting Started

### Installing

* Program can be installed thorugh this repository and is stored there.

### Executing program

* Opening the folder in the CLI (command line interface;
  Terminal, Command Prompt, etc.)
* Running following command:
```
cd src/ && javac *.java && java ContactsApp
```

* After executing the program it will work as described in the Description.

## Authors

* Nazarov Dmitry

## Links To Material That Helped
* [writing to a file](https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html)
* [about writing to a file](https://www.geeksforgeeks.org/file-handling-java-using-filewriter-filereader/)
* [(METHOD THAT WAS USED) about listing CSV-files to arrays in java](https://www.youtube.com/watch?v=-Aud0cDh-J8)
* [CSV to array to help me understand previous](https://www.baeldung.com/java-csv-file-array)
* [about CSV to array, but more specific, for implementation and understanding](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-int-)
* [about regex generally](https://www.w3schools.com/java/java_regex.asp)
* [Finnish personal ID info for regex](https://dvv.fi/en/personal-identity-code)
* [site to test regex](https://regexr.com)
