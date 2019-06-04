package StreamsFilesAndDirectories;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class L_WriteEveryThirdLine {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inPath = userDir + "/resources/input.txt";
        String outPath = userDir + "/resources/output.txt";

        try (BufferedReader bfr = new BufferedReader(new FileReader(inPath));
            PrintWriter out = new PrintWriter(new FileWriter(outPath))){

            List<String> lines = bfr.lines().collect(Collectors.toList());

            for (int i = 1; i < lines.size(); i++) {
                if (i % 3 == 0) {
                    out.printf(lines.get(i - 1) + "%n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
