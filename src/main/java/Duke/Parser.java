package Duke;

//import Duke.Command.AddTaskCommand;

import Duke.Command.*;

import java.io.IOException;
import java.util.Scanner;


public class Parser {


    public static Command runCommand(TaskList list) throws IOException {
        Scanner in = new Scanner(System.in);


        String userInput = in.nextLine();
        String[]splitInput =  userInput.split(" ",2);

        switch(splitInput[0]) {
        case"bye":
            return new ExitCommand();
        case "list":
           return new ListCommand(list);
        case"done":
            return new CompleteCommand(userInput, list);
        case "delete":
            return new DeleteCommand(userInput, list);
        default:
           return new AddTaskCommand(userInput, list);
    }

  }
}
