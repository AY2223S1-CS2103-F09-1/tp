package seedu.address.model.person;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always assumed to be valid
 */
public class Remark {

    public final String input;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark A String remark.
     */
    public Remark(String remark) {
        input = remark;
    }

    @Override
    public String toString() {
        return input;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && input.equals(((Remark) other).input)); // state check
    }

    @Override
    public int hashCode() {
        return input.hashCode();
    }
}
