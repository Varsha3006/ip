import java.util.Scanner;

public class Duke {

    public static final int MAX_TASKS = 100;
    public static Task[] list =  new Task[MAX_TASKS];
    public static int size = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        printWelcomeMessage();

        String userInput = in.nextLine();
        while (userInput.equals("bye") == false) {
            if (userInput.equals("list")) {
                printList();
            } else if(userInput.contains("done")){   //cannot use command.equals since user is entering more than just "done"
                isCompleted(userInput);
            } else {
                addTask(userInput);
            }
            userInput = in.nextLine();
        }
        printExitMessage();
    }

    public static void printWelcomeMessage(){


         String logo = "    ____   ____ " + System.lineSeparator()
                 + "   |  __| |  _ \\ " + System.lineSeparator()
                + "   | |__  | | | |    " + System.lineSeparator()
                + "   |  __| | | | |    " + System.lineSeparator()
                + "   | |__  | |_| |  " + System.lineSeparator()
                + "   |____| |____/  ";


        ;
        System.out.println("    Hi! I am friendly\n" + logo);
        System.out.println("    ____________________________________________________________");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }

    public static void printList() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < size; i++) {
            System.out.print(i+1+ ".");
            list[i].printTask();
        }
        System.out.println("    ____________________________________________________________");
    }


    public static void isCompleted(String command) {
        command = command.replace("done", " ");
        command = command.strip(); //removes white space
        int index;
        index = Integer.parseInt(command);

        if(index > size){
            System.out.println("Oh no! This is an invalid task number. Try again");
            return;
        }
        index--;
        list[index].isDone = true;
        System.out.println("    ____________________________________________________________");
        System.out.println("    Nice! I've marked this task as done:");
        System.out.print(index+1 + ".");
        list[index].printTask();
        System.out.println("    ____________________________________________________________");
    }

    public static void addTask(String line){
        if(line.startsWith("todo")) {
            line = line.replace("todo", " ");
            line = line.strip();
            addTodo(line);
        }else if(line.startsWith("deadline")){
            line = line.replace("deadline", " ");
            line = line.strip();
            addDeadline(line);
        }else if(line.startsWith("event")){
            line = line.replace("event", " ");
            line = line.strip();
            addEvent(line);
        }
        System.out.println("Got it. I've added this task:");
        list[size-1].printTask();
        System.out.println("Now you have " + size + " tasks in the list!");
    }

    public static void printExitMessage(){
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");

    }

    public static void addTodo(String description) {
       list[size] = new Todo(description);
        size++;
    }

    public static void addDeadline(String line){
        String[] descriptionBy = line.split(" /by ");
        list[size++] = new Deadline(descriptionBy[0], descriptionBy[1]);
    }

    public static void addEvent(String line) {
        String[] descriptionAt = line.split(" /at ");
        list[size++] = new Event(descriptionAt[0], descriptionAt[1]);
    }
}

