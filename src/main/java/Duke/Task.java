package Duke;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected String SYMBOL;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a tick or cross depending on whether a task is marked done.
     *
     * @return Tick or Cross
     */
    public String getStatusIcon() {
        return (isDone ? "[" + "\u2713" + "]" : "[" + "\u2718" + "]"); //return tick or X symbols
    }

    /**
     * Returns the description of the task.
     *
     * @return Description of task.
     */
    public String getDescription() {
        return description;
    }

    public abstract String getSYMBOL();

    public abstract String toString();

    public String toFindString(){
            return getStatusIcon() + " " + getDescription();
    }

    public void printTask() {
        System.out.println(this.getStatusIcon() + " " + this.description);
    }


}


