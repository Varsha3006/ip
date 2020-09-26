package Duke.Command;
import Duke.TaskList;
import Duke.Ui;

/**
 * Represents a command which lists the current TaskList to the user.
 */
public class ListCommand extends Command{
    /**
     * Prints the entire list of tasks to the user.
     *
     * @param list Current TaskList.
     *
     **/
    public ListCommand(TaskList list){
       Ui.printList(list);
    }
}