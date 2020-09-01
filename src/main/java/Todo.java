public class Todo extends Task {
    private static final String SYMBOL = "[T]";

    public Todo(String description) {
        super(description);
    }

    @Override
    public void printTask() {
        System.out.print("  " + SYMBOL);
        super.printTask();
    }
}
