package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P05_LineNumbers {
    public static void main(String[] args){

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/resources/inputLineNumbers.txt";
        String outputPath = userDir + "/resources/output_ex.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             FileWriter writer = new FileWriter(outputPath)) {

            int[] count = {1};
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(String.format("%d. %s%n", count[0]++, line));
            }

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
