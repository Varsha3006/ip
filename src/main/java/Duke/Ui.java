package Duke;

import Duke.Task;

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

    public static void printErrorMessage (){
        System.out.println("Something went wrong");
    }

}
