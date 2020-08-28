
public class List {
    private Task[] list;
    private static int size;

    public List() {                             //constructor
        this.list = new Task[100];
        this.size = 0;
    }

   /**Prints the list*/
    public void printList() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < size; i++) {
            System.out.println("    "+ (i+1) + ". [" + this.list[i].getStatusIcon() + "] " + this.list[i].description);
        }
        System.out.println("    ____________________________________________________________");
    }

    /** add tasks to the list*/
    public void addTask(String description) {
        this.list[size] = new Task(description);
        this.size++;
    }

    /** Ticks the completed tasks */
    public void isCompleted(String command) {
        command = command.replace("done", " ");
        command = command.strip(); //removes white space
        int index;
        index = Integer.parseInt(command);
        index--;

        this.list[index].markTaskAsDone();
        System.out.println("    ____________________________________________________________");
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("    " + " [" + this.list[index].getStatusIcon() + "] " + this.list[index].description);
        System.out.println("    ____________________________________________________________");
        }
    }




