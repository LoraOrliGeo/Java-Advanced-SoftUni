package StreamsFilesAndDirectories;

import java.io.*;

public class P03_ALL_CAPITALS {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/resources/input_ex.txt";
        String outputPath = userDir + "/resources/output_ex.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            FileWriter writer = new FileWriter(outputPath)){
            String line;

            while((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                   writer.append(Character.toUpperCase(c));
                }
                writer.write(String.format("%n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
