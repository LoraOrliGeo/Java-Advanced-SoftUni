package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_WordCount {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String textFilePath = userDir + "/resources/text.txt";
        String wordsFilePath = userDir + "/resources/words.txt";
        String outputPath = userDir + "/resources/output_ex.txt";

        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        try (Scanner textReader = new Scanner(new FileReader(textFilePath));
             Scanner wordsReader = new Scanner(new FileReader(wordsFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            Arrays.stream(wordsReader.nextLine().split("\\s+")).forEach(w -> wordsCount.putIfAbsent(w, 0));

            while (textReader.hasNext()) {
                String word = textReader.next();
                if (wordsCount.containsKey(word)) {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }
            }

            wordsCount.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).forEach(e -> {
                writer.println(String.format("%s - %d", e.getKey(), e.getValue()));
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}