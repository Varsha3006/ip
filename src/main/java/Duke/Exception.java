package Duke;

public class Exception {
    public Exception(String type) {
        switch (type) {
        case "not valid":
            Ui.printLine();
            System.out.println("     Oops!!! Please input a valid command");
            Ui.printLine();
            break;
        case "empty list":
            Ui.printLine();
            System.out.println("     Oops!!! I'm sorry, but there is no tasks in list");
            Ui.printLine();
            break;
        }
    }
}

