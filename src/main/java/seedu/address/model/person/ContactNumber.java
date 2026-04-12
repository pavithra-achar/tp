package seedu.address.model.person;

/**
 * Represents a Person's contact number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class ContactNumber {
    public static final String MESSAGE_CONSTRAINTS =
            "Phone numbers should be in the format of +<country code> <number>, with the <country code> being between "
                    + "1-3 digits and the <number> between 3-15 digits. It should only contain numbers and" + " '+'s";
    public static final String VALIDATION_REGEX = "^\\+\\d{1,3}([ -]?\\(?\\d{3,15}\\)?)+$";

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidContact(String test) {
        return test.matches(VALIDATION_REGEX);
    }
}
