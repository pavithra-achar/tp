package seedu.address.ui.filter;

import java.util.Set;

import seedu.address.model.FilterDetails;

/**
 * Setter for a specific keyword set in a {@link FilterDetails} instance.
 * Provides a contract for setting filter keywords for a particular field/prefix.
 */
@FunctionalInterface
public interface KeywordSetter {
    /**
     * Sets the keywords for a specific field in the given FilterDetails.
     *
     * @param filterDetails the FilterDetails instance to modify
     * @param keywords      the set of keywords to set for this field
     */
    void set(FilterDetails filterDetails, Set<String> keywords);
}

