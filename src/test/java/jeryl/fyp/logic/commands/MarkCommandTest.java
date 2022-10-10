package jeryl.fyp.logic.commands;

import static jeryl.fyp.logic.commands.CommandTestUtil.VALID_STATUS_AMY;
import static jeryl.fyp.logic.commands.CommandTestUtil.VALID_STATUS_BOB;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jeryl.fyp.model.person.StudentID;

/**
 * Contains integration tests (interaction with the Model) and unit tests for RemarkCommand.
 */
public class MarkCommandTest {
    final StudentID studentID = new StudentID("A0123456G");

    /**
     * Code to be revisited later :(
     * final Status status = "IP";
     * assertCommandFailure(new RemarkCommand(INDEX_FIRST_PERSON, remark), model,
     *           String.format(MESSAGE_ARGUMENTS, INDEX_FIRST_PERSON.getOneBased(), remark));
    */

    @Test
    public void equals() {
        final MarkCommand standardCommand = new MarkCommand(studentID, VALID_STATUS_AMY);

        // same values -> returns true
        MarkCommand commandWithSameValues = new MarkCommand(studentID, VALID_STATUS_AMY);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different studentID -> returns false
        final StudentID diffStudentID = new StudentID("A1234567F");
        assertFalse(standardCommand.equals(new MarkCommand(diffStudentID, VALID_STATUS_AMY)));

        // different status -> returns false
        assertFalse(standardCommand.equals(new MarkCommand(studentID, VALID_STATUS_BOB)));
    }
}
