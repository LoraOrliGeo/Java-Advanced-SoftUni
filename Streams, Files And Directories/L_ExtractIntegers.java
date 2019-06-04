package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class L_ExtractIntegers {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/resources/input.txt";
        String outputPath = userDir + "/resources/output.txt";

        try (Scanner sc = new Scanner(new FileInputStream(inputPath));
             PrintWriter fos = new PrintWriter(outputPath)) {

            while (sc.hasNext()) {
                if (sc.hasNextInt()){
                    fos.println(sc.nextInt());
                }
                sc.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
