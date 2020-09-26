package Duke.Command;

import Duke.TaskList;

/**
 * Represents a command which deletes a task from the TaskList.
 */
public class DeleteCommand extends Command {
    /**
     * Deletes a task from the TaskList.
     *
     * @param list Current TaskList.
     * @param s To delete s from list
     */
    public DeleteCommand(String s, TaskList list) {
        list.deleteTask(s);
    }
}