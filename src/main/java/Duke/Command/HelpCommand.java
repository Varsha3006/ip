package Duke.Command;
import Duke.Ui;

/**
 * Represents a command which lists out the available commands for the user
 */
public class HelpCommand extends Command{
    public HelpCommand(){
        Ui.listAllCommands();
    }
}