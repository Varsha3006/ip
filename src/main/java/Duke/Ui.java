package Duke;

import java.util.ArrayList;

/**
 * Represents interactions with the user.
 */
public class Ui {
    private static int NUMBER_DASHES = 75;

    /**
     * Prints the logo at the start of the program.
     */
    public static void printLogo() {
        System.out.println( "    ____   ____ " + System.lineSeparator()
                + "   |  __| |  _ \\ " + System.lineSeparator()
                + "   | |__  | | | |    " + System.lineSeparator()
                + "   |  __| | | | |    " + System.lineSeparator()
                + "   | |__  | |_| |  " + System.lineSeparator()
                + "   |____| |____/  ");
    }

    /**
     * Prints the welcome message at the start of the program.
     */
    public static void printWelcomeMessage() {

        System.out.println("    Hi! I am easy\n");
        printLogo();
        printLine();
        System.out.println("    What can I do for you?");
        printLine();
    }

    /**
     * Prints the exit message before the program exits.
     */
    public static void printExitMessage() {
        printLine();
        System.out.println("    Bye Bye for now! See you soon!");
        printLine();
    }

    public static void printLine(){
        System.out.println( "   " + "_".repeat(NUMBER_DASHES));
    }

    /**
     * Prints the list of command and their respective formats
     *
     */
    public static void listAllCommands(){
        printLine();
        System.out.println("    Hello there! Here are all the available commands and their respective formats:");
        System.out.println("    To add a deadline: \"deadline {Name of task} /by {date} \"");
        System.out.println("    To add an event: \"event {Name of task} /at {date} \" \");");
        System.out.println("    To add an item in todo: \"todo {Name of task}\" ");
        System.out.println("    To list out all tasks that you have entered: \"list\"");
        System.out.println("    To filter task by date: \"list {date}\"");
        System.out.println("    To mark a task as completed: \"done {index of task in list}\"");
        System.out.println("    To delete a task: \"delete {index of task in list}\"");
        System.out.println("    To find a task: \"find {keyword to be searched }\"");
        printLine();
    }

    /**
     * Prints the list of tasks and indicates whether they are done.
     *
     * @param tasks Current TaskList.
     */
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

    /**
     * Prints the list of tasks that contain the keyword.
     *
     * @param tasks Current TaskList.
     * @param Key To find the keyword
     */
    public static void printFindList(ArrayList<Task> tasks, String Key) {
    
        if (tasks.isEmpty()) {
            System.out.println("    No matching tasks in your list (search: " + Key + ")");
            return;
        }
        printLine();
        System.out.println("    Here are the matching tasks in your list (search: " + Key + "):");
        int i = 0;
        for (Task t : tasks) {
            System.out.println((i + 1) + "." + tasks.get(i).toFindString());
            i++;
        }
        printLine();
    }

    /**
     * Prints the list of tasks that contain the Date input.
     *
     * @param tasks Current TaskList.
     *
     */
    public static void printDateList(ArrayList<Task> tasks) {

        if (tasks.isEmpty()) {
            System.out.println("    No matching tasks in your list");
            return;
        }
        printLine();
        System.out.println("    Here are the matching tasks in your list");
        int i =0;
        for (Task t : tasks) {
            System.out.println((i + 1) + "." + tasks.get(i).toFindString());
            i++;
        }
        printLine();

    }

    /**
     * Prints success message when the task is added successfully.
     *
     * @param tasks Current TaskList.
     */
    public static void itemAddedMessage(TaskList tasks){
        printLine();
        System.out.println("    Got it. I've added this task:");
        tasks.getTask(tasks.getSize()-1).printTask();
        System.out.println("    Now you have " + tasks.getSize() + " tasks in the list!");
        printLine();
    }

    /**
     * Prints error message when there is something wrong with the format of the date entered
     */
    public static void printDateTimeErr() {
        printLine();
        System.out.println("    Oops! Please enter your date in the yyyy-mm-dd format\n");
        printLine();
    }

    /**
     * Prints error message when there is something wrong with "duke.txt"
     */
    public static void printFileError() {
        printLine();
        System.out.println("    Oops! Something went wrong with duke.txt");
        printLine();
    }

    /**
     * Prints error message when the description is not specified.
     */
    public static void emptyDescriptionErr(String line){
        printLine();
        System.out.println("    Oops!!! The description of a " + line + " cannot be empty. Please try again!");
        printLine();
    }

    /**
     * Prints error message when user did not input the index number
     */
    public static void notValidNumberErr(){
        printLine();
        System.out.println("    Oops! Please enter a valid task number");
        printLine();
    }

}

