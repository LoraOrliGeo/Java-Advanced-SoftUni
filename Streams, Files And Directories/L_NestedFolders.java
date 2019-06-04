package StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class L_NestedFolders {
    public static void main(String[] args) {

        File file = new File("D:\\Programming\\SoftUni\\Java Advanced\\Lab\\04. Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> folders = new ArrayDeque<>();

        // TODO continue!

        if (file.isDirectory()){
            folders.offer(file);
        } else {
            System.out.println(file.getName());
        }
    }
}
