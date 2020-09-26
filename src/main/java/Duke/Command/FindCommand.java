package Duke.Command;

import Duke.Task;
import Duke.TaskList;
import Duke.Ui;

import java.util.ArrayList;

public class FindCommand extends Command  {
    private String key;

    public FindCommand(String command)  {
        this.key = command.substring(5);

        ArrayList<Task> tasks = TaskList.find(key);

        Ui.printFindList(tasks,key);
    }

}


