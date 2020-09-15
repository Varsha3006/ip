package Duke;

public class Deadline extends Task{
    //private static final String SYMBOL = "[D]";
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.SYMBOL = "[D]";
    }
    @Override
    public String getSYMBOL() {
        return SYMBOL;
    }

    @Override
    public String toString() {
        return SYMBOL + " | " + (this.isDone ? "1 | " : "0 | ") + this.description + " | " + this.by;
    }

    @Override
    public void printTask() {
        System.out.print("  " + SYMBOL);
        System.out.print(this.getStatusIcon() + " " + this.description);
        System.out.println(" (by: " + this.by + ")");
    }
}