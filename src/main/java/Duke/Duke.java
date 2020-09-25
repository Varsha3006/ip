package Duke;


import java.io.IOException;

import Duke.Command.Command;

public class Duke {
    private TaskList list;
    private Storage storage;


    public static void main(String[] args) throws IOException{
            new Duke("duke.txt").run("duke.txt");
    }

    public Duke(String filePath) throws IOException{
        storage = new Storage(filePath);
        list = new TaskList(storage);
    }

    public void run (String filePath) throws IOException {
        Ui.printWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
           Command c =  Parser.runCommand(list);
            isExit = c.isExit();
        }
    }

}