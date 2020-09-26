package Duke.Command;
import Duke.Ui;

public class HelpCommand extends Command{
    public HelpCommand(){
        Ui.listAllCommands();
    }
}