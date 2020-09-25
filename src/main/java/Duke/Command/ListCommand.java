package Duke.Command;
import Duke.TaskList;

public class ListCommand extends Command{
    public ListCommand(TaskList list){
        list.printList();
    }
}