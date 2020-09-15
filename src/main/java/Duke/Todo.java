
package Duke;

public class Todo extends Task {

    public Todo(String description) {

        super(description);
        this.SYMBOL = "[T]";
    }
    @Override
    public String getSYMBOL() {
        return SYMBOL;
    }
    @Override
    public String toString() {
        return SYMBOL + " | " + (this.isDone ? "1 | " : "0 | ") + this.description;
    }

    @Override
    public void printTask() {
        System.out.print("  " + SYMBOL);
        super.printTask();
    }
}
