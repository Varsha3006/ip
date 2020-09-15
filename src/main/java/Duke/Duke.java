package Duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;



public class Duke {

    public static ArrayList<Task> tasks = new ArrayList<>();
   public static final String path = ("C:\\Users\\65837\\Desktop\\NUS\\Y2S1\\CS2113T\\project\\duke.txt");

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        createFile();

        printWelcomeMessage();

        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {

            //If user input list, return list of items
            if (userInput.equals("list")) {
                printList();
                //If user input done, mark the task as done
            } else if (userInput.contains("done")) {
                isCompleted(userInput);

            } else if(userInput.contains("delete")){
                deleteTask(userInput);
            }
            else {
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
        printLine();
        System.out.println("    What can I do for you?");
        printLine();
    }

    public static void printExitMessage() {
        printLine();
        System.out.println("    Bye. Hope to see you again soon!");
        printLine();
    }

    public static void printLine(){
        System.out.println("    ____________________________________________________________");
    }

    private static void printFileError() {
        System.out.println(" Oops! Something went wrong with duke.txt");
    }

    public static void emptyDescriptionErr(String line){
        System.out.println("OOPS!!! The description of a " + line + " cannot be empty☹ Please try again!");
    }

    public static void notValidNumberErr(){
        System.out.println("Oh no! Please enter a valid task number :(");

    }

    public static void printList() {

        if (tasks.size() == 0) {
            new Exception("empty list");
            return;
        }

        printLine();

        System.out.println("    Here are the current tasks in your list:");

        for (Task task : tasks) {
            System.out.print(tasks.indexOf(task) + 1 + ".");
            task.printTask();
        }
        printLine();
    }

    //add task to list
    public static void addTask(String line) {
        String[] input = line.split(" ", 2);

        switch (input[0]) {
        case "todo":
            try {
                line = line.substring(5);
                addTodo(line, false);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("todo");
                return;
            }
            break;
        case "deadline":
            try {
                line = line.substring(9);
                addDeadline(line, false);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("deadline");
                return;
            }
            break;
        case "event":
            try {
                line = line.substring(6);
                addEvent(line, false);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("event");
                return;
            }
            break;
        default:
            new Exception("not valid");
            return;
        }
        System.out.println("Got it. I've added this task:");
        tasks.get(tasks.size()-1).printTask();
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");
    }

    public static void deleteTask(String line){
        int size = 0;
        try {
            size = Integer.parseInt(line.substring(7));
        } catch (StringIndexOutOfBoundsException e){
            emptyDescriptionErr("delete command");
            return;
        } catch (IndexOutOfBoundsException e){
            notValidNumberErr();
        }

        Task task = tasks.get(size - 1);
        String prevTask = task.toString();
        tasks.remove(task);
        try {
            replaceContent(prevTask, " ");
        } catch (IOException e) {
            printFileError();
        }
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
        }
        try {
            Task task = tasks.get(index - 1);
            String prevTask = task.toString();
            task.isDone = true;
            String newTask = task.toString();
            replaceContent(prevTask, newTask);

            printLine();
            System.out.println("    Nice! I've marked this task as done:");
            System.out.print(index + ".");
            task.printTask();
            printLine();
        } catch (NullPointerException e) {
            notValidNumberErr();
        } catch (IOException e) {
            printFileError();
        }
    }

    public static void addTodo(String line, Boolean existInFile) {
        tasks.add(new Todo(line));

        String inputToFile =  tasks.get(tasks.size()-1).toString();

        if (!existInFile) {
            writeToFile(path, inputToFile);
        }
    }

    public static void addDeadline(String line, Boolean fromFile) {
        String[] description = line.split(" /by ");

        tasks.add(new Deadline(description[0], description[1]));

        String inputToFile =  tasks.get(tasks.size()-1).toString();

        if (!fromFile) {
            writeToFile(path, inputToFile);
        }

    }

    public static void addEvent(String line, Boolean fromFile) {
        String[] description = line.split(" /at ");

        tasks.add(new Event(description[0], description[1]));
        String inputToFile =  tasks.get(tasks.size()-1).toString();
        if (!fromFile) {
            writeToFile(path, inputToFile);
        }
    }


    public static void createFile() {
        try{
        File file = new File(path);

        if (file.exists() == false) {
            file.createNewFile();
        } else {
            System.out.println("File already exists.");
        }
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                loadFileTask(input.nextLine());
            }
            input.close();
        } catch (IOException e) {
            printFileError();
        }

    }

    public static void writeToFile(String filePath, String textToAdd) {
        try{
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(System.lineSeparator() + textToAdd);
        fw.close();
        } catch (IOException e) {
            printFileError();
        }
    }


    public static void loadFileTask(String line) {
        String[] taskDescription = line.split(" \\| ");

        switch (taskDescription[0]) {
        case "[T]":
            addTodo(taskDescription[2], true);
            break;
        case "[D]":
            addDeadline(taskDescription[2] + " /by " + taskDescription[3], true);
            break;
        case "[E]":
            addEvent(taskDescription[2] + " /at " + taskDescription[3], true);
            break;
        default:
        }
    }


    //Reused from https://www.tutorialspoint.com/how-to-overwrite-a-line-in-a-txt-file-using-java
    // with slight modifications
    public static void replaceContent(String prevTask, String newTask) throws IOException {
        File file = new File(path);
        Scanner read = new Scanner(file);
        StringBuilder buffer = new StringBuilder();

        while (read.hasNext()) {
            buffer.append(read.nextLine() + System.lineSeparator());
        }
        read.close();

        String fileContents = buffer.toString();
        fileContents = fileContents.replace(prevTask, newTask);
        FileWriter write = new FileWriter(path);
        write.append(fileContents);
        write.flush();
    }


}