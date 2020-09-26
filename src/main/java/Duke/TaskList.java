package Duke;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * Represents the TaskList.
 */
public class TaskList {
    private Storage storage;
    public static ArrayList<Task> tasks = new ArrayList<>();


    public TaskList(Storage inStorage) {
        tasks = new ArrayList<>();
        storage = inStorage;
    }

    /**
     * Returns the size of the task list.
     *
     * @return Size of task list.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Returns the task based on the index.
     *
     * @param index Index of task.
     * @return Task with the corresponding index.
     */
    public Task getTask(Integer index) {
        return tasks.get(index);
    }

    /**
     * Prints the entire task list.
     */
    public void print() {
        for (Task task : tasks) {
            System.out.print(tasks.indexOf(task) + 1 + ".");
            task.printTask();
        }
    }

    /**
     *
     * @param line task to be deleted from list
     */

    public static void deleteTask(String line){
        int size = 0;
        Ui.printLine();
        try {
            size = Integer.parseInt(line.substring(7));
        } catch (StringIndexOutOfBoundsException e){
            Ui.emptyDescriptionErr("delete command");
            return;
        } catch (IndexOutOfBoundsException e){
            Ui.notValidNumberErr();
        }

        Task task = tasks.get(size - 1);
        tasks.remove(task);
        Storage.writeToFile(tasks);
        System.out.println("I'll delete this:");
        task.printTask();
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");

    }

    /**
     *
     * @param command task to be marked as done
     */
    public static void isCompleted(String command) {
        int index = 0;
        command = command.replace("done", " ");
        command = command.strip(); //removes white space
        try {
            index = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            Ui.notValidNumberErr();
            return;
        }
        try {
            Task task = tasks.get(index - 1);
            task.isDone = true;

            Storage.writeToFile(tasks);
            Ui.printLine();
            System.out.println("    Nice! I've marked this task as done:");
            System.out.print(index + ".");
            task.printTask();
            Ui.printLine();
        } catch (IndexOutOfBoundsException e) {
            Ui.notValidNumberErr();
        }
    }

    /**
     * Adds a todo task to the TaskList.
     *
     * @param line User command input.
     *
     */
    public static void addTodo(String line) throws IOException{

        Todo newTodo = new Todo(line);
        tasks.add(newTodo);
        Storage.appendToFile(newTodo);
    }

    /**
     * Adds a deadline task to the TaskList.
     *
     * @param line User command input.
     *
     */
    public static void addDeadline(String line) throws IOException{
        String[] description = line.split(" /by ");
        Deadline newDeadline = new Deadline(description[0], description[1]);
        tasks.add(newDeadline);

        Storage.appendToFile(newDeadline);
    }
    /**
     * Adds an event task to the TaskList.
     *
     * @param line User command input.
     */
    public static void addEvent(String line) throws IOException{
        String[] description = line.split(" /at ");
        Event newEvent = new Event(description[0], description[1]);
        tasks.add(newEvent);
        Storage.appendToFile(newEvent);
    }


    public static ArrayList<Task> find(String line) {
        return (ArrayList<Task>) tasks.stream()
                .filter(t -> t.description.toLowerCase().contains(line))
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of tasks which has deadlines on a specific date or
     * events which occur on that specific date.
     * Filters the task list by the date.
     *
     * @param date Date to be filtered by.
     * @return List of tasks which are filtered by the date.
     */
    public static ArrayList<Task> filterByDate(LocalDate date) {
      return (ArrayList<Task>)tasks.stream()
                .filter((t) -> !(t instanceof Todo))
                .filter((t) -> t.getDate().equals(date))
                .collect(Collectors.toList());
    }

}
