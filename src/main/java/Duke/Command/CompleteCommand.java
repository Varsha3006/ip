package Duke.Command;
import Duke.TaskList;

public class CompleteCommand extends Command{
    public CompleteCommand(String s, TaskList list) {
        list.isCompleted(s);
    }
}