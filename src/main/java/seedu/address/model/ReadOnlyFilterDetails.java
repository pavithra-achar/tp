package seedu.address.model;

import javafx.beans.property.ReadOnlyObjectWrapper;

/**
 * Unmodifiable view of filter details.
 */
public interface ReadOnlyFilterDetails {
    /**
     * Returns the filter details as an unmodifiable object.
     * @return the filter details
     */
    ReadOnlyObjectWrapper<FilterDetails> getFilterDetails();
}
