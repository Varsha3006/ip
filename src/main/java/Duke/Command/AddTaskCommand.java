package Duke.Command;

import Duke.Command.Command;
import Duke.Exception;
import Duke.TaskList;
import Duke.Ui;


import java.io.IOException;

import static Duke.Ui.emptyDescriptionErr;

public class AddTaskCommand extends Command {
    public AddTaskCommand (String line, TaskList tasks) throws IOException {

        String[] input = line.split(" ", 2);
        switch (input[0]) {
        case "todo":
            try {
                line = line.substring(5);
               TaskList.addTodo(line);
              // Ui.itemAddedMessage(tasks.getTask(tasks.getSize() -1), tasks);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("todo");
                return;
            }
            break;
        case "deadline":
            try {
                line = line.substring(9);
                TaskList.addDeadline(line);
              //  Ui.itemAddedMessage(tasks.getTask(tasks.getSize() -1), tasks);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("deadline");
                return;
            }
            break;
        case "event":
            try {
                line = line.substring(6);
                TaskList.addEvent(line);
               // Ui.itemAddedMessage(tasks.getTask(tasks.getSize() -1), tasks);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("event");
                return;
            }
            break;
        default:
            new Exception("not valid");
        }
        Ui.itemAddedMessage(tasks.getTask(tasks.getSize() -1), tasks);
    }
}


