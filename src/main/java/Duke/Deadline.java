package Duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.SYMBOL = "[D]";
        this.setDate(LocalDate.parse(by));

    }

    /**
     * Returns the Symbol of the deadline: [D]
     *
     * @return Symbol of deadline.
     */
    @Override
    public String getSYMBOL() {
        return SYMBOL;
    }

    /**
     * Returns a string format of the deadline.
     *
     * @return String format of deadline.
     */
    @Override
    public String toString() {
        return SYMBOL + " | " + (this.isDone ? "1 | " : "0 | ") + this.description + " | " + this.by;
    }

    /**
     * Returns a string format of searching a deadline.
     *
     * @return String format for searching deadline.
     */
    @Override
    public String toFindString() {
        return SYMBOL + getStatusIcon() + " " + getDescription();
    }

    /**
     * Prints the deadline in the format:
     * [D][status] description (by: deadline)
     */
    @Override
    public void printTask() {
        System.out.print("  " + SYMBOL);
        System.out.print(this.getStatusIcon() + " " + this.description);
        System.out.println(" (by: " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")");
    }
}