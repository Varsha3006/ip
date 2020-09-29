package Duke;


import java.io.IOException;
import java.time.DateTimeException;

import Duke.Command.Command;

public class Duke {
    private TaskList list;
    private Storage storage;

    /**
     * Runs Duke instance.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        new Duke("duke.txt").run("duke.txt");
    }

    /**
     * Instantiates a Duke instance.
     *
     * @param filePath is the File path of the file which the data is to be saved into.
     */
    public Duke(String filePath) throws IOException {
        storage = new Storage(filePath);
        list = new TaskList(storage);
    }

    /**
     * Runs the program.
     */
    public void run(String filePath) throws IOException {
        Ui.printWelcomeMessage();
        boolean isExit = false;

        while (!isExit) {
            try {
                Command c = Parser.runCommand(list);
                isExit = c.isExit();
            } catch (DateTimeException e) {
                Ui.printDateTimeErr();
            }
        }
    }
}