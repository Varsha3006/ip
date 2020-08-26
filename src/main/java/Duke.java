
import java.util.Scanner;


public class Duke {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list = new List();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        String userInput = in.nextLine();
        while (userInput.equals("bye") == false) {
            if (userInput.equals("list")) {
                list.printList();
            } else if(userInput.contains("done")){   //cannot use command.equals since user is entering more than just "done"
                list.taskCompleted(userInput);
            } else {
                System.out.println("added: " + userInput);
                list.addTask(userInput);
            }
            userInput = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");

    }
}

