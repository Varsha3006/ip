package Duke;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected String SYMBOL;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[" + "\u2713" + "]" : "[" + "\u2718" + "]"); //return tick or X symbols
    }

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


