package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's emergency contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class EmergencyContact extends ContactNumber {
    public final String value;

    /**
     * Constructs a {@code EmergencyContact}.
     *
     * @param emergencyPhone A valid emergency phone number.
     */
    public EmergencyContact(String emergencyPhone) {
        requireNonNull(emergencyPhone);
        checkArgument(isValidContact(emergencyPhone), MESSAGE_CONSTRAINTS);
        value = emergencyPhone;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EmergencyContact)) {
            return false;
        }

        EmergencyContact otherEmergencyContact = (EmergencyContact) other;
        return value.equals(otherEmergencyContact.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
