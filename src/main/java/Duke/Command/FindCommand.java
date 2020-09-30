package Duke.Command;

import Duke.Task;
import Duke.TaskList;
import Duke.Ui;

import java.util.ArrayList;

/**
 * Represents a command which finds tasks based on the keyword input.
 */
public class FindCommand extends Command  {
    private String key;

    /**
     * Finds tasks with the corresponding keyword.
     *
     * @param command input by user to find the keyword
     *
     */
    public FindCommand(String command) {
        try {
            this.key = command.substring(5);
            ArrayList<Task> tasks = TaskList.find(key);
            Ui.printFindList(tasks, key);
        } catch (StringIndexOutOfBoundsException e) {
            Ui.emptyDescriptionErr("find command");
        }
    }

}


