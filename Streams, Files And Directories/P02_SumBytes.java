package StreamsFilesAndDirectories;

import java.io.*;

public class P02_SumBytes {
    public static void main(String[] args) throws FileNotFoundException {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/resources/input_ex.txt";

        File file = new File(path);
        FileReader fileReader = new FileReader(file);

        try (BufferedReader reader = new BufferedReader(fileReader);) {
            String line;
            long sum = 0;

            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
