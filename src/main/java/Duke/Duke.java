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

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        try {
            createFile();
        } catch (IllegalStateException e) {
            printFileError();
        }
        printWelcomeMessage();

        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {

            if (userInput.equals("list")) {
                printList();

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

    public static void printFileError() {
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
    public static void addTask(String line) throws IOException {
        String[] input = line.split(" ", 2);

        switch (input[0]) {
        case "todo":
            try {
                line = line.substring(5);
                addTodo(line);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("todo");
                return;
            }
            break;
        case "deadline":
            try {
                line = line.substring(9);
                addDeadline(line);
            } catch (StringIndexOutOfBoundsException e) {
                emptyDescriptionErr("deadline");
                return;
            }
            break;
        case "event":
            try {
                line = line.substring(6);
                addEvent(line);
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
        writeToFile();
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
            task.isDone = true;

            writeToFile();
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
        appendToFile(newTodo);
    }

    public static void addDeadline(String line) throws IOException{
        String[] description = line.split(" /by ");
        Deadline newDeadline = new Deadline(description[0], description[1]);
        tasks.add(newDeadline);

        appendToFile(newDeadline);
    }

    public static void addEvent(String line) throws IOException{
        String[] description = line.split(" /at ");
        Event newEvent = new Event(description[0], description[1]);
        tasks.add(newEvent);
        appendToFile(newEvent);
    }


    public static void createFile() {
        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("File already exists.");
            }
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                String[] taskDescription = s.nextLine().split(" \\| ");
                switch (taskDescription[0]) {
                case "[T]":
                    addTodo(taskDescription[2]);
                    break;
                case "[D]":
                    addDeadline(taskDescription[2] + " /by " + taskDescription[3]);
                    break;
                case "[E]":
                    addEvent(taskDescription[2] + " /at " + taskDescription[3]);
                    break;
                default:
                }
                s.close();
            }
        } catch  (IOException e) {
                printFileError();
            }
        }


    public static void writeToFile() {
        try{
        FileWriter fw = new FileWriter(path);
            for(int i=0; i<tasks.size() ;i++) {
                String fileInput = tasks.get(i).toString();
                fw.write(System.lineSeparator() + fileInput);
            }
            fw.close();
        } catch (IOException e) {
            printFileError();
        }
    }

    private static void appendToFile(Task input) throws IOException {
        FileWriter fw = new FileWriter(path,true);

            String fileInput = input.toString();
            fw.write(System.lineSeparator()+fileInput);

        fw.close();
    }

}