package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class StudentID {

    public static final String MESSAGE_CONSTRAINTS =
            "ID should be of the format 'A' + (7 digits) + (1 letter) , and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "A\\d{7}[A-Z]";

    public final String id;

    /**
     * Constructs a {@code StudentID}.
     *
     * @param studentID A valid studentID.
     */
    public StudentID(String studentID) {
        requireNonNull(studentID);
        checkArgument(isValidStudentID(studentID), MESSAGE_CONSTRAINTS);
        id = studentID;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidStudentID(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StudentID // instanceof handles nulls
                && id.equals(((StudentID) other).id)); // state check
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
