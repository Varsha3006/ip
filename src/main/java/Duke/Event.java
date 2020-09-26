package Duke;

public class Event extends Task {

    private String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.SYMBOL = "[E]";
    }

    /**
     * Returns the symbol for event: [E]
     *
     * @return Symbol of event.
     */
    @Override
    public String getSYMBOL() {
        return SYMBOL;
    }

    /**
     * Returns the string format of the event.
     *
     * @return String format of event.
     */
    @Override
    public String toString() {
        return SYMBOL + " | " + (this.isDone ? "1 | " : "0 | ") + this.description + " | " + this.at;
    }

    /**
     * Returns the string format for finding an event.
     *
     * @return String format of finding an event.
     */
    @Override
    public String toFindString() {
        return SYMBOL + getStatusIcon() + " " + getDescription();
    }

    /**
     * Prints the event in the format:
     * [E][status] description (at: date)
     */
    @Override
    public void printTask() {
        System.out.print("  " + SYMBOL);
        System.out.print(this.getStatusIcon() + " " + this.description);
        System.out.println(" (at: " + this.at + ")");
    }
}