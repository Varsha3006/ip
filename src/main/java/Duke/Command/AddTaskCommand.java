package Duke.Command;

import Duke.Exception;

import Duke.TaskList;
import Duke.Ui;


import java.io.IOException;

import static Duke.Ui.emptyDescriptionErr;
import static Duke.Ui.notValidNumberErr;

public class AddTaskCommand extends Command {

    /**
     * Adds a task to the TaskList.
     *
     * @param tasks Current TaskList.
     *
     * @param line input by user
     */
    public AddTaskCommand (String line, TaskList tasks) throws IOException {

        String[] input = line.split(" ", 2);
        switch (input[0]) {
        case "todo":
            try {
                line = line.substring(5);
               TaskList.addTodo(line);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("todo");
                return;
            } catch (IndexOutOfBoundsException e) {
                notValidNumberErr();
                return;
            }
            break;
        case "deadline":
            try {
                line = line.substring(9);
                TaskList.addDeadline(line);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("deadline");
                return;
            } catch (IndexOutOfBoundsException e) {
                notValidNumberErr();
                return;
            }
            break;
        case "event":
            try {
                line = line.substring(6);
                TaskList.addEvent(line);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("event");
                return;
            } catch (IndexOutOfBoundsException e) {
                notValidNumberErr();
                return;
            }
            break;
        default:
            new Exception("not valid");
            return;
        }
        Ui.itemAddedMessage(tasks.getTask(tasks.getSize() -1), tasks);
    }
}


