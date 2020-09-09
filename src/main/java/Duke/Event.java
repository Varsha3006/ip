package Duke;

public class Event extends Task {
    private static final String SYMBOL = "[E]";
    private String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public void printTask() {
        System.out.print("  " + SYMBOL);
        System.out.print("[" + this.getStatusIcon() + "] " + this.description);
        System.out.println(" (at: " + this.at + ")");
    }
}
