package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;

public class L_ListFiles {
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\Programming\\SoftUni\\Java Advanced\\Lab\\04. Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        for (File f : file.listFiles()) {
            if (!f.isDirectory()) {
                System.out.println(String.format("%s: [%d]", f.getName(), f.length()));
            }
        }
    }
}
