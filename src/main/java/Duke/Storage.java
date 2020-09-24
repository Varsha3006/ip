package Duke;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Duke.TaskList.addEvent;
import static Duke.TaskList.addDeadline;
import static Duke.TaskList.addTodo;

public class Storage {

    public static final String path = ("C:\\Users\\65837\\Desktop\\NUS\\Y2S1\\CS2113T\\project\\duke.txt");

    public static void createFile() throws IOException {
          try{
              File file = new File(path);
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
            Ui.printFileError();
        }
    }



    public static void writeToFile(ArrayList < Task >tasks,int size) {
        try {
            FileWriter fw = new FileWriter(path);
            for (int i = 0; i < tasks.size(); i++) {
                String fileInput = tasks.get(i).toString();
                fw.write(System.lineSeparator() + fileInput);
            }
            fw.close();
        } catch (IOException e) {
            Ui.printFileError();
        }
    }

    public static void appendToFile( Task input) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        String fileInput = input.toString();
        fw.write(System.lineSeparator() + fileInput);

    }
}




