package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.FilterDetails;

/**
 * Tests whether a {@code Person} matches the details specified in a {@link FilterDetails}.
 */
public record PersonMatchesDetailsPredicate(FilterDetails filterDetails) implements Predicate<Person> {

    /**
     * Creates a {@code PersonMatchesDetailsPredicate} with the given {@code FilterDetails}.
     */
    public PersonMatchesDetailsPredicate(FilterDetails filterDetails) {
        this.filterDetails = requireNonNull(filterDetails);
    }

    /**
     * Returns a snapshot of the filter details used by this predicate.
     */
    @Override
    public FilterDetails filterDetails() {
        return new FilterDetails(filterDetails);
    }

    @Override
    public boolean test(Person person) {
        return isFuzzyMatch(person.getName().fullName, filterDetails.getNameKeywords())
                && isFuzzyMatch(person.getEmail().value, filterDetails.getEmailKeywords())
                && isFuzzyMatch(person.getPhone().value, filterDetails.getPhoneNumberKeywords())
                && isFuzzyMatch(person.getRoomNumber().value, filterDetails.getRoomNumberKeywords())
                && isFuzzyMatch(person.getStudentId().value, filterDetails.getStudentIdKeywords())
                && isFuzzyMatch(person.getEmergencyContact().value, filterDetails.getEmergencyContactKeywords())
                && matchesFuzzyTags(person.getYear().getTagName(), filterDetails.getTagYearKeywords())
                && matchesFuzzyTags(person.getMajor().getTagName(), filterDetails.getTagMajorKeywords())
                && matchesExactTags(person.getGender().getTagName(), filterDetails.getTagGenderKeywords());
    }

    /**
     * Checks if the given {@code fieldValue} matches any of the {@code keywords} via substring matching
     * (case-insensitive).
     */
    private boolean isFuzzyMatch(String fieldValue, Set<String> keywords) {
        requireNonNull(fieldValue);
        requireNonNull(keywords);
        if (keywords.isEmpty()) {
            return true;
        }
        if (fieldValue.isEmpty()) {
            return false;
        }
        String lower = fieldValue.toLowerCase();
        return keywords.stream().map(k -> k.toLowerCase()).anyMatch(lower::contains);
    }

    /**
     * Checks if the person's tag match any of the {@code keywords} via fuzzy matching, as defined in
     * {@link StringUtil#fuzzyMatchesAnyIgnoreCase(String, Set)}.
     */
    private boolean matchesFuzzyTags(String tag, Set<String> keywords) {
        requireNonNull(tag);
        requireNonNull(keywords);

        if (keywords.isEmpty()) {
            return true;
        }
        if (tag.isEmpty()) {
            return false;
        }

        return StringUtil.fuzzyMatchesAnyIgnoreCase(tag, keywords);
    }

    /**
     * Checks if any of the person's tags exactly match any of the {@code keywords} (case-insensitive)
     */
    private boolean matchesExactTags(String tag, Set<String> keywords) {
        requireNonNull(tag);
        requireNonNull(keywords);

        if (keywords.isEmpty()) {
            return true;
        }
        if (tag.isEmpty()) {
            return false;
        }

        return StringUtil.equalsAnyIgnoreCase(tag, keywords);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PersonMatchesDetailsPredicate otherPredicate)) {
            return false;
        }
        return Objects.equals(this.filterDetails, otherPredicate.filterDetails);
    }

    @Override
    public String toString() {
        return new ToStringBuilder("")
                .add("filterDetails", filterDetails)
                .toString();
    }
}
