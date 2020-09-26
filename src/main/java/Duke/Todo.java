
package Duke;

public class Todo extends Task {

    public Todo(String description) {

        super(description);
        this.SYMBOL = "[T]";
    }

    /**
     * Returns the todo's symbol: [T]
     *
     * @return symbol of Todo.
     */
    @Override
    public String getSYMBOL() {
        return SYMBOL;
    }

    /**
     * Returns the string format of the Todo.
     *
     * @return String format of Todo.
     */
    @Override
    public String toString() {
        return SYMBOL + " | " + (this.isDone ? "1 | " : "0 | ") + this.description;
    }

    /**
     * Returns the string format for searching a Todo.
     *
     * @return String format of searching a Todo.
     */
    @Override
    public String toFindString() {
        return SYMBOL + getStatusIcon() + " " + getDescription();
    }

    /**
     * Prints the Todo in the format:
     * [T][status] description
     */
    @Override
    public void printTask() {
        System.out.print("  " + SYMBOL);
        super.printTask();
    }
}
