package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("/Users/yaroslavstarenkij/Desktop/GoIT/GIT/HomeWorkModule10/src/main/java/task1/file.txt");

        matchingPhoneNumbers(file);

    }

    private static void matchingPhoneNumbers(File file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            while (bf.ready()) {
                String line = bf.readLine();
                if (Pattern.matches("[(]\\d{3}[)] \\d{3}-\\d{4}", line)
                        || Pattern.matches("\\d{3}-\\d{3}-\\d{4}", line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
