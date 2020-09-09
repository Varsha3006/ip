public class Exception{
    public Exception (String type) {
        switch (type) {
        case "not valid": //ARRAYOUTOFBOUNDS exception
            System.out.println("☹ OOPS!!! Please input a valid command");
            break;
        case "empty list":
            System.out.println("☹ OOPS!!! I'm sorry, but there is no tasks in list");
            break;
        }
    }
}