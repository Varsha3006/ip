package Duke;

import java.io.IOException;
import java.util.Scanner;


import static Duke.TaskList.*;
import static Duke.Ui.printFileError;
import static Duke.Ui.printWelcomeMessage;


public class Parser {

public static void runCommand() throws IOException{
    Scanner in = new Scanner(System.in);
    try {
       Storage.createFile();
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

        } else if (userInput.contains("delete")) {
            TaskList.deleteTask(userInput);
        } else {
            TaskList.addTask(userInput);
        }
        userInput = in.nextLine();
    }
    Ui.printExitMessage();
}
}
