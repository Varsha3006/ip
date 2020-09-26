package Duke;

import Duke.Task;

import java.util.ArrayList;

public class Ui {
    private static int NUMBER_DASHES = 50;
    //private Scanner in = new Scanner(System.in);

    public static void printLogo() {
        System.out.println( "    ____   ____ " + System.lineSeparator()
                + "   |  __| |  _ \\ " + System.lineSeparator()
                + "   | |__  | | | |    " + System.lineSeparator()
                + "   |  __| | | | |    " + System.lineSeparator()
                + "   | |__  | |_| |  " + System.lineSeparator()
                + "   |____| |____/  ");
    }

    public static void printWelcomeMessage() {

        System.out.println("    Hi! I am easy\n");
        printLogo();
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
        System.out.println( "   " + "_".repeat(NUMBER_DASHES));
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

    public static void listAllCommands(){
        printLine();
        System.out.println("    Hi there! Here are all the available commands and their respective formats:");
        System.out.println("    To add a deadline: \"deadline {Name of task} /by {time} \"");
        System.out.println("    To add an event: \"event {Name of task} /at {time} \" \");");
        System.out.println("    To add an item in todo: \"todo {Name of task}\" ");
        System.out.println("    To list out all tasks that you have entered: \"list\"");
        System.out.println("    To mark a task as completed: \"done {index of task in list}\"");
        System.out.println("    To delete a task: \"delete {index of task in list}\"");
        printLine();
    }

    public static void printList(TaskList tasks) {

        if (tasks.getSize() == 0) {
            new Exception("empty list");
            return;
        }
        printLine();
        System.out.println("    Here are the current tasks in your list:");
        tasks.print();
        printLine();
    }

    public static void printFindList(ArrayList<Task> tasks, String Key) {

        if (tasks.isEmpty()) {
            new Exception("empty list");
            return;
        }
        System.out.println("Here are the matching tasks in your list (search: " + Key + "):");
        int i = 0;

        for (Task t : tasks) {
            System.out.println((i + 1) + "." + tasks.get(i).toFindString());
            i++;
        }
    }
    public static void itemAddedMessage(Task task, TaskList tasks){
        System.out.println("Got it. I've added this task:");
        tasks.getTask(tasks.getSize()-1).printTask();
        System.out.println("Now you have " + tasks.getSize() + " tasks in the list!");
    }

}

