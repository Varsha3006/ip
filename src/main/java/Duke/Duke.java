package Duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Duke {

    public static ArrayList<Task> tasks = new ArrayList<>();


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        try {
            createFile();
        } catch (IOException e) {
            printFileError();
        }
        printWelcomeMessage();
        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {

            //If user input list, return list of items
            if (userInput.equals("list")) {
                printList();

                //If user input done, mark the task as done
            } else if (userInput.contains("done")) {
                isCompleted(userInput);

            } else {
                addTask(userInput);
            }
            userInput = in.nextLine();
        }
        printExitMessage();
    }

    public static void printWelcomeMessage() {


        String logo = "    ____   ____ " + System.lineSeparator()
                + "   |  __| |  _ \\ " + System.lineSeparator()
                + "   | |__  | | | |    " + System.lineSeparator()
                + "   |  __| | | | |    " + System.lineSeparator()
                + "   | |__  | |_| |  " + System.lineSeparator()
                + "   |____| |____/  ";


        ;
        System.out.println("    Hi! I am easy\n" + logo);
        System.out.println("    ____________________________________________________________");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }

    private static void printFileError() {
        System.out.println(" Error reading/writing data.txt.");
    }

    public static void printList() {

        if (tasks.size() == 0) {
            new Exception("empty list");
            return;
        }
        System.out.println("    ____________________________________________________________");
        System.out.println("    Here are the tasks in your list:");
        for (Task task : tasks) {
            System.out.print(tasks.indexOf(task) + 1 + ".");
            task.printTask();
        }
        System.out.println("    ____________________________________________________________");
    }

    //completed tasks ( e.g. done 3)
    public static void isCompleted(String command) {
        int index;
        command = command.replace("done", " ");
        command = command.strip(); //removes white space
        try {
            index = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Oh no! Please list a task number to be marked done :(");
            return;
        }

        try {
            Task task = tasks.get(index - 1);
            String oldTaskString = task.toString();
            task.isDone = true;
            updateFile(oldTaskString, task.toString());
            System.out.println("    ____________________________________________________________");
            System.out.println("    Nice! I've marked this task as done:");
            System.out.print(index + ".");
            task.printTask();
            System.out.println("    ____________________________________________________________");
        } catch (NullPointerException e) {
            System.out.println("Oh no! Please enter a valid task number :(");
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }


    //add task to list
    public static void addTask(String line) {

        if (line.startsWith("todo")) {
            try {
                line = line.substring(5);
                addTodo(line,false);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! The description of a todo cannot be empty☹ Please try again!");
                return;
            }
        } else if (line.startsWith("deadline")) {
            try {
                line = line.substring(9);
                addDeadline(line,false);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! The description of a deadline cannot be empty☹ Please try again! ");
                return;
            }
        } else if (line.startsWith("event")) {
            try {
                line = line.substring(6);
                addEvent(line,false);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! The description of a event cannot be empty☹ Please try again!");
                return;
            }
        } else {
            new Exception("not valid");
            return;
        }

        System.out.println("Got it. I've added this task:");
        tasks.get(tasks.size() - 1).printTask();
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");
    }

    public static void addTodo(String line, Boolean fromFile) {
        tasks.add(new Todo(line));

        if (!fromFile) {
            writeToFile("duke.txt", tasks.get(tasks.size()-1).toString());
        }
    }

    public static void addDeadline(String line, Boolean fromFile) {
        String[] descriptionBy = line.split(" /by ");
        tasks.add(new Deadline(descriptionBy[0], descriptionBy[1]));

        if (!fromFile) {
            writeToFile("duke.txt", tasks.get(tasks.size()-1).toString());
        }
    }

    public static void addEvent(String line, Boolean fromFile) {
        String[] descriptionAt = line.split(" /at ");
        tasks.add(new Event(descriptionAt[0], descriptionAt[1]));

        if (!fromFile) {
            writeToFile("duke.txt", tasks.get(tasks.size()-1).toString());
        }
    }


    public static void printExitMessage() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");

    }

    public static void createFile() throws IOException {
        File file = new File("duke.txt");

        if (file.exists() == false) {
            file.createNewFile();
        }
        Scanner read = new Scanner(file);
        while (read.hasNext()) {
            loadFileTask(read.nextLine());
        }
        read.close();
    }

    public static void loadFileTask(String line) {
        String[] taskDetails = line.split(" \\| ");

        switch (taskDetails[0]) {
        case "[T]":
            addTodo(taskDetails[2], true);
            break;
        case "[D]":
            addDeadline(taskDetails[2] + " /by " + taskDetails[3], true);
            break;
        case "[E]":
            addEvent(taskDetails[2] + " /at " + taskDetails[3], true);
            break;
        default:
            // Happens if there is nothing in the list (or any garbage text)
            return;
        }

        // Mark as done if the task is already done
        if (taskDetails[1].equals("1")) {
            tasks.get(tasks.size()-1).isDone = true;
        }
    }

    public static void writeToFile(String filePath, String line) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(System.lineSeparator() + line);
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /*
    Updates the file
     */
    public static void updateFile(String oldTaskString, String newTaskString) throws IOException {
        File file = new File("duke.txt");
        Scanner read = new Scanner(file);
        StringBuffer buffer = new StringBuffer();

        // Puts everything from file into buffer
        while (read.hasNext()) {
            buffer.append(read.nextLine() + System.lineSeparator());
        }

        read.close();

        // Puts everything from buffer into String
        String fileContents = buffer.toString();

        // Update the file
        fileContents = fileContents.replace(oldTaskString, newTaskString);
        FileWriter writer = new FileWriter("duke.txt");
        writer.append(fileContents);
        writer.flush();
    }

}