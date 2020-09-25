package Duke.Command;

import Duke.Ui;

public class ExitCommand extends Command { public ExitCommand(){
    Ui.printExitMessage();
}

    @Override
    public boolean isExit(){
        return true;
    }
}