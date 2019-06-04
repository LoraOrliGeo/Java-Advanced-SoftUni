package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L_CopyBytes {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/resources/input.txt";
        String outputPath = userDir + "/resources/output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                oneByte = fis.read();
                String digits = String.valueOf(oneByte);

                if (!digits.equals("32") && !digits.equals("10")) {
                    for (int i = 0; i < digits.length(); i++) {
                        int dig = digits.charAt(i);
                        fos.write(dig);
                    }
                } else {
                    if (digits.equals("32")){
                        fos.write(32);
                    } else {
                        fos.write(10);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
