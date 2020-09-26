package Duke.Command;
import Duke.TaskList;
import Duke.Ui;

public class ListCommand extends Command{
    public ListCommand(TaskList list){
       Ui.printList(list);
    }
}