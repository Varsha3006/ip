package Duke;

import Duke.Command.*;

import java.io.IOException;
import java.util.Scanner;


public class Parser {

    /**
     * Represents a parser to parse command inputs by the user.
     */
    public static Command runCommand(TaskList list) throws IOException {
        Scanner in = new Scanner(System.in);

        String userInput = in.nextLine();
        String[]splitInput =  userInput.split(" ",2);

        switch(splitInput[0]) {
        case"bye":
            return new ExitCommand();
        case "list":
           return new ListCommand(userInput,list);
        case"done":
            return new CompleteCommand(userInput, list);
        case "delete":
            return new DeleteCommand(userInput, list);
        case "help":
            return new HelpCommand();
        case "find":
            return new FindCommand(userInput);
        default:
           return new AddTaskCommand(userInput, list);
    }

  }
}
