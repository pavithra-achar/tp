package seedu.address.model.tag;

/**
 * Represents the type of a Tag in the address book.
 * Guarantees: immutable; name is valid
 */
public enum TagType {

    YEAR("^[1-6]$"),
    MAJOR("[\\p{Alnum} ]*[\\p{Alnum}]+[\\p{Alnum} ]*"),
    GENDER("^(she/her|he/him|they/them)$");

    private final String validationRegex;

    TagType(String validationRegex) {
        this.validationRegex = validationRegex;
    }

    /**
     * Returns true if the given {@code tagContent} is valid according to this tag type's validation regex.
     * Returns true if {@code tagContent} is null, as null represents the absence of a tag.
     *
     * @param tagContent the tag name to validate, or null if no tag is present.
     * @return true if {@code tagContent} is null or matches the validation regex, false otherwise.
     */

    public boolean isValidTagName(String tagContent) {
        if (tagContent == null) {
            return true;
        }
        return tagContent.matches(validationRegex);
    }
}
