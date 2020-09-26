package Duke.Command;

import Duke.Ui;

/**
 * Represents a command which exits the program.
 */
public class ExitCommand extends Command { public ExitCommand(){
    Ui.printExitMessage();
}

    @Override
    public boolean isExit(){
        return true;
    }
}