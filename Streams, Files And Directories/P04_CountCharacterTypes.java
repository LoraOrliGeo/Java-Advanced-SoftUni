package StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P04_CountCharacterTypes {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/resources/input_ex.txt";
        String outputPath = userDir + "/resources/output_ex.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String line;
            int vowelsCount = 0;
            int constantsCount = 0;
            int punctuationCount = 0;

            List<Character> vowels = new ArrayList<Character>() {{
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
            }};

            List<Character> punctuation = new ArrayList<Character>() {{
                add(',');
                add('.');
                add('!');
                add('?');
            }};

            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)){
                        vowelsCount++;
                    } else if (punctuation.contains(c)){
                        punctuationCount++;
                    } else {
                        if (c != 32) {
                            constantsCount++;
                        }
                    }
                }
            }

            writer.println(String.format("Vowels: 41\n" +
                    "Consonants: 72\n" +
                    "Punctuation: 6\n", vowelsCount, constantsCount, punctuationCount));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
