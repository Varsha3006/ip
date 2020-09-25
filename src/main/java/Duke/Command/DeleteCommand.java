package Duke.Command;

import Duke.TaskList;

public class DeleteCommand extends Command {
    public DeleteCommand(String s, TaskList list) {
        list.deleteTask(s);
    }
}