package Duke;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Duke.TaskList.addEvent;
import static Duke.TaskList.addDeadline;
import static Duke.TaskList.addTodo;
import static Duke.Ui.printFileError;

public class Storage {

    private static String filePath;

    public Storage(String input) throws IOException{
        filePath = input;
          try {
            createFile();
         } catch (IllegalStateException e) {
              printFileError();
          }
    }

    /**
     * Loads data from the file "duke.txt".
     * Creates a new file if the file does not exist.
     *
     */
    public  void createFile()  {
          try{
              File file = new File(filePath);
              if (!file.exists()) {
                  file.createNewFile();
              } else {
                  System.out.println("File already exists.");
              }
              Scanner s = new Scanner(file);
            while (s.hasNext()) {
                String[] taskDescription = s.nextLine().split(" \\| ");
                switch (taskDescription[0]) {
                case "[T]":
                    addTodo(taskDescription[2]);
                    break;
                case "[D]":
                    addDeadline(taskDescription[2] + " /by " + taskDescription[3]);
                    break;
                case "[E]":
                    addEvent(taskDescription[2] + " /at " + taskDescription[3]);
                    break;
                default:
                }
                s.close();
            }
        } catch (IOException e) {
            printFileError();
        }
    }

    /**
     * writes data into file "duke.txt"
     * @param tasks ArrayList of Task objects.
     *
     */

    public static void writeToFile(ArrayList<Task> tasks)  {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (int i = 0; i < tasks.size(); i++) {
                String fileInput = tasks.get(i).toString();
                fw.write(System.lineSeparator() + fileInput);
            }
            fw.close();
        } catch (IOException e) {
            printFileError();
        }
    }

    /**
     * adds new data into file "duke.txt"
     * @param input add different tasks to file
     *
     */

    public static void appendToFile(Task input) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        String fileInput = input.toString();
        fw.write(System.lineSeparator() + fileInput);
        fw.close();
    }
}




