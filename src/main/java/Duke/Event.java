package Duke;

public class Event extends Task {

    private String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.SYMBOL = "[E]";
    }
    @Override
    public String getSYMBOL() {
        return SYMBOL;
    }

    @Override
    public String toString() {
        return SYMBOL + " | " + (this.isDone ? "1 | " : "0 | ") + this.description + " | " + this.at;
    }
    @Override
    public String toFindString() {
        return SYMBOL + getStatusIcon() + " " + getDescription();
    }
    @Override
    public void printTask() {
        System.out.print("  " + SYMBOL);
        System.out.print(this.getStatusIcon() + " " + this.description);
        System.out.println(" (at: " + this.at + ")");
    }
}