package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RemarkTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Remark(null));
    }

    @Test
    public void constructor_validEmptyRemark() {
        String invalidRemark = "";
        assertDoesNotThrow(() -> new Remark(invalidRemark));
    }

    @Test
    public void equals() {
        Remark Remark = new Remark("Valid Remark");

        // same values -> returns true
        assertTrue(Remark.equals(new Remark("Valid Remark")));

        // same object -> returns true
        assertTrue(Remark.equals(Remark));

        // null -> returns false
        assertFalse(Remark.equals(null));

        // different types -> returns false
        assertFalse(Remark.equals(5.0f));

        // different values -> returns false
        assertFalse(Remark.equals(new Remark("Other Valid Remark")));
    }
}
