package Duke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import Duke.Task;

import static Duke.Ui.*;

public class TaskList {
    private Storage storage;
    public static ArrayList<Task> tasks = new ArrayList<>();


    public TaskList(Storage inStorage) {
        tasks = new ArrayList<>();
        storage = inStorage;
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int getSize() {
        return tasks.size();
    }

    public Task getTask(Integer index) {
        return tasks.get(index);
    }

    public void print() {
        for (Task task : tasks) {
            System.out.print(tasks.indexOf(task) + 1 + ".");
            task.printTask();
        }
    }


    public static void deleteTask(String line){
        int size = 0;
        printLine();
        try {
            size = Integer.parseInt(line.substring(7));
        } catch (StringIndexOutOfBoundsException e){
            emptyDescriptionErr("delete command");
            return;
        } catch (IndexOutOfBoundsException e){
            notValidNumberErr();
        }

        Task task = tasks.get(size - 1);
        tasks.remove(task);
        Storage.writeToFile(tasks,size);
        System.out.println("I'll delete this:");
        task.printTask();
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");

    }

    public static void isCompleted(String command) {
        int index = 0;
        command = command.replace("done", " ");
        command = command.strip(); //removes white space
        try {
            index = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            notValidNumberErr();
            return;
        }
        try {
            Task task = tasks.get(index - 1);
            task.isDone = true;

            Storage.writeToFile(tasks,index);
            printLine();
            System.out.println("    Nice! I've marked this task as done:");
            System.out.print(index + ".");
            task.printTask();
            printLine();
        } catch (NullPointerException e) {
            notValidNumberErr();
        }
    }

    public static void addTodo(String line) throws IOException{

        Todo newTodo = new Todo(line);
        tasks.add(newTodo);
        Storage.appendToFile(newTodo);
    }

    public static void addDeadline(String line) throws IOException{
        String[] description = line.split(" /by ");
        Deadline newDeadline = new Deadline(description[0], description[1]);
        tasks.add(newDeadline);

        Storage.appendToFile(newDeadline);
    }

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

}
