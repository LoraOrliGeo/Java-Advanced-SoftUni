package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L_ReadAndWriteFile {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");

        String path = userDir + "/resources/input.txt";

        try (FileInputStream fis = new FileInputStream(path);
             FileOutputStream fos = new FileOutputStream(userDir + "/resources/output.txt")) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                oneByte = fis.read();

                if (oneByte != '.' && oneByte != ',' && oneByte != '!' && oneByte != '?') {
                    fos.write(oneByte);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
