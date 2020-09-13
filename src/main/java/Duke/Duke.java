package Duke;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        printWelcomeMessage();
        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {

            //If user input list, return list of items
            if (userInput.equals("list")) {
                printList();
                //If user input done, mark the task as done
            } else if (userInput.contains("done")) {
                isCompleted(userInput);

            } else if(userInput.contains("delete")){
                toDeleteTask(userInput);
            }
            else {
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
        System.out.println("    Hi! I am easy\n" + logo);
        System.out.println("    ____________________________________________________________");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }

    public static void printList() {

        if(tasks.size() ==0 ) {
            new Exception("empty list");
            return;
        }
        System.out.println("    ____________________________________________________________");
        System.out.println("    Here are the tasks in your list:");
        for (Task task: tasks) {
            System.out.print(tasks.indexOf(task)+1+ ".");
            task.printTask();
        }
        System.out.println("    ____________________________________________________________");
    }


    public static void isCompleted(String command){
        int index = 0;
            command = command.replace("done", " ");
            command = command.strip(); //removes white space
        try {
             index = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Oh no! Please list a task number to be marked done :(");
        }

        try{
            Task task = tasks.get(index-1);

            task.isDone = true;
            System.out.println("    ____________________________________________________________");
            System.out.println("    Nice! I've marked this task as done:");
            System.out.print(index + ".");
            task.printTask();
            System.out.println("    ____________________________________________________________");
        } catch (NullPointerException e) {
            System.out.println("Oh no! Please enter a valid task number :(");
        }
    }


//add task to list
    public static void addTask(String line){

        if(line.startsWith("todo")) {
            try {
                line = line.substring(5);
                addTodo(line);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! The description of a todo cannot be empty☹ Please try again!");
                return;
            }
        } else if(line.startsWith("deadline")){
            try {
                line = line.substring(9);
                addDeadline(line);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! The description of a deadline cannot be empty☹ Please try again! ");
                return;
            }
        } else if(line.startsWith("event")){
            try {
                line = line.substring(6);
                addEvent(line);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! The description of a event cannot be empty☹ Please try again!");
                return;
            }
        } else {
            new Exception("not valid");
            return;
        }

        System.out.println("Got it. I've added this task:");
        tasks.get(tasks.size()-1).printTask();
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");
    }

    public static void toDeleteTask(String line){
        int size = 0;
        try {
            size = Integer.parseInt(line.substring(7));
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("OOPS!!! The description of a delete command cannot be empty☹ Please try again!");
            return;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Oh no! Please enter a valid task number :(");
        }

        Task task = tasks.get(size - 1);
        tasks.remove(task);

        System.out.println("I'll delete this:");
        task.printTask();
        System.out.println("Now you have " + tasks.size() + " tasks in the list!");

    }

    public static void addTodo(String description) {
        //list[size] = new Todo(description);
       // size++;
        tasks.add(new Todo(description));
    }

    public static void addDeadline(String line){
        String[] descriptionBy = line.split(" /by ");
       // list[size++] = new Deadline(descriptionBy[0], descriptionBy[1]);
        tasks.add(new Deadline(descriptionBy[0], descriptionBy[1]));
    }

    public static void addEvent(String line) {
        String[] descriptionAt = line.split(" /at ");
      //  list[size++] = new Event(descriptionAt[0], descriptionAt[1]);
        tasks.add(new Event(descriptionAt[1], descriptionAt[1]));
    }


    public static void printExitMessage(){
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");

    }

}

