package Duke.Command;
import Duke.Task;
import Duke.TaskList;
import Duke.Ui;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents a command which lists the current TaskList to the user.
 */
public class ListCommand extends Command{
   ;
    /**
     * Prints the entire list of tasks to the user.
     *
     * @param command user Input
     * @param list Current TaskList.
     *
     **/
    public ListCommand (String command, TaskList list){
        if (command.equals("list")) {
            Ui.printList(list);
        } else {
            LocalDate date = LocalDate.parse(command.substring(5));
            ArrayList<Task> tasks = TaskList.filterByDate(date);
            Ui.printDateList(tasks);
        }
    }
}
