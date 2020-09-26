package Duke.Command;
import Duke.TaskList;

/**
 * Represents a command which marks a task as done.
 */
public class CompleteCommand extends Command{
    /**
     * Deletes a task from the TaskList.
     *
     * @param list Current TaskList.
     * @param s To mark s as done
     */
    public CompleteCommand(String s, TaskList list) {
        list.isCompleted(s);
    }
}