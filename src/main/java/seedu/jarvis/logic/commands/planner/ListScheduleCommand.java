package seedu.jarvis.logic.commands.planner;

import static java.util.Objects.requireNonNull;

import seedu.jarvis.logic.commands.Command;
import seedu.jarvis.logic.commands.CommandResult;
import seedu.jarvis.logic.commands.exceptions.CommandException;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.viewstatus.ViewType;
import seedu.jarvis.storage.history.commands.JsonAdaptedCommand;
import seedu.jarvis.storage.history.commands.exceptions.InvalidCommandToJsonException;

/**
 * Lists all the tasks in the planner that is due in the given day or week
 */
//TODO tests
public class ListScheduleCommand extends Command {

    public static final String COMMAND_WORD = "list-schedule";

    public static final String MESSAGE_SUCCESS = "Here are the tasks due for the day & the week:";

    public static final String MESSAGE_NO_INVERSE = "The command " + COMMAND_WORD + " cannot be undone";

    public static final boolean HAS_INVERSE = false;

    /**
     * Gets the command word of the command
     *
     * @return {@code String} representation of the command word
     */
    @Override
    public String getCommandWord() {
        return COMMAND_WORD;
    }

    /**
     * Returns whether the command has an inverse execution.
     * Since ListScheduleCommand has no inverse execution, then calling {@code executeInverse}
     * will be guaranteed to always throw a {@code CommandException}
     *
     * @return whether the command has an inverse execution
     */
    @Override
    public boolean hasInverseExecution() {
        return HAS_INVERSE;
    }

    /**
     * Lists all {@code Task} in the planner due for that day & week.
     *
     * @param model {@code Model} which the command should operate on.
     * @return {@code CommandResult} that all the tasks were listed successfully.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateSchedule();
        model.setViewStatus(ViewType.LIST_PLANNER_SCHEDULE);

        return new CommandResult(MESSAGE_SUCCESS, true);
    }

    /**
     * There is no inverse execution available, always throws a {@code CommandException}
     *
     * @param model {@code Model} which the command should inversely operate on.
     * @throws CommandException
     */
    @Override
    public CommandResult executeInverse(Model model) throws CommandException {
        throw new CommandException(MESSAGE_NO_INVERSE);
    }

    /**
     * Gets a {@code JsonAdaptedCommand} from a {@code Command} for local storage purposes
     *
     * @return {@code JsonAdaptedCommand}
     * @throws InvalidCommandToJsonException If command should not be adapted to JSON format.
     */
    @Override
    public JsonAdaptedCommand adaptToJsonAdaptedCommand() throws InvalidCommandToJsonException {
        throw new InvalidCommandToJsonException();
    }
}
