package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GITHUB;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENTID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TELEGRAM;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.student.NameContainsKeywordsPredicate;
import seedu.address.model.student.Student;
import seedu.address.testutil.EditStudentDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_TAG_INTLSTUDENT = "internationalStudent";
    public static final String VALID_TAG_YEAR2 = "year2";
    public static final String VALID_GITHUB_AMY = "amyB";
    public static final String VALID_GITHUB_BOB = "bobC";
    public static final String VALID_TELEGRAM_AMY = "amy_B";
    public static final String VALID_TELEGRAM_BOB = "bob_C";
    public static final String VALID_STUDENTID_AMY = "A0123456B";
    public static final String VALID_STUDENTID_BOB = "A0123457C";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String TAG_DESC_YEAR2 = " " + PREFIX_TAG + VALID_TAG_YEAR2;
    public static final String TAG_DESC_INTLSTUDENT = " " + PREFIX_TAG + VALID_TAG_INTLSTUDENT;
    public static final String GITHUB_DESC_AMY = " " + PREFIX_GITHUB + VALID_GITHUB_AMY;
    public static final String GITHUB_DESC_BOB = " " + PREFIX_GITHUB + VALID_GITHUB_BOB;
    public static final String TELEGRAM_DESC_AMY = " " + PREFIX_TELEGRAM + VALID_TELEGRAM_AMY;
    public static final String TELEGRAM_DESC_BOB = " " + PREFIX_TELEGRAM + VALID_TELEGRAM_BOB;
    public static final String STUDENTID_DESC_AMY = " " + PREFIX_STUDENTID + VALID_STUDENTID_AMY;
    public static final String STUDENTID_DESC_BOB = " " + PREFIX_STUDENTID + VALID_STUDENTID_BOB;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags
    // cant have consecutive '-'
    public static final String INVALID_GITHUB_CONSECUTIVE_HYPHEN_DESC = " " + PREFIX_GITHUB + "invalid--1";
    // cant start with '-'
    public static final String INVALID_GITHUB_STARTING_HYPHEN_DESC = " " + PREFIX_GITHUB + "-invalid";
    // cant end with '-'
    public static final String INVALID_GITHUB_ENDING_HYPHEN_DESC = " " + PREFIX_GITHUB + "invalid-";
    // cant be longer than 39 alphanumeric characters
    public static final String INVALID_GITHUB_LONGER_THAN_39_DESC = " " + PREFIX_GITHUB
            + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    public static final String INVALID_TELEGRAM_DESC = " " + PREFIX_TELEGRAM + "James&"; // '&' not alphanumeric
    public static final String INVALID_STUDENTID_START_LETTER_DESC = " " + PREFIX_STUDENTID + "B0123456B";
    public static final String INVALID_STUDENTID_WRONG_LENGTH_DESC = " " + PREFIX_STUDENTID + "A012345B";
    public static final String INVALID_STUDENTID_END_NUMBER_DESC = " " + PREFIX_STUDENTID + "A01234567";
    public static final String INVALID_STUDENTID_MIDDLE_LETTER = " " + PREFIX_STUDENTID + "A012C456B";

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditStudentDescriptor DESC_AMY;
    public static final EditCommand.EditStudentDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditStudentDescriptorBuilder().withName(VALID_NAME_AMY)
                .withEmail(VALID_EMAIL_AMY)
                .withTags(VALID_TAG_YEAR2)
                .withGithub(VALID_GITHUB_AMY)
                .withTelegram(VALID_TELEGRAM_AMY)
                .withStudentId(VALID_STUDENTID_AMY).build();
        DESC_BOB = new EditStudentDescriptorBuilder().withName(VALID_NAME_BOB)
                .withEmail(VALID_EMAIL_BOB)
                .withTags(VALID_TAG_INTLSTUDENT, VALID_TAG_YEAR2)
                .withGithub(VALID_GITHUB_BOB)
                .withTelegram(VALID_TELEGRAM_BOB)
                .withStudentId(VALID_STUDENTID_BOB).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
                                            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered student list and selected student in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Student> expectedFilteredList = new ArrayList<>(actualModel.getFilteredStudentList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredStudentList());
    }

    /**
     * Updates {@code model}'s filtered list to show only the student at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showStudentAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredStudentList().size());

        Student student = model.getFilteredStudentList().get(targetIndex.getZeroBased());
        final String[] splitName = student.getName().fullName.split("\\s+");
        model.updateFilteredStudentList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredStudentList().size());
    }

}
