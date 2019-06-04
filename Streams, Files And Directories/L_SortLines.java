package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.*;

public class L_SortLines {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");

        Path inPath = Paths.get(userDir + "/resources/input.txt");
        Path outPath = Paths.get(userDir + "/resources/output.txt");

        List<String> lines = readAllLines(inPath).stream().filter(e -> !e.isEmpty()).sorted().collect(Collectors.toList());

        Files.write(outPath, lines);
    }
}
