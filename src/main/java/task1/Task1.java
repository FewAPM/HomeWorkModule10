package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("/Users/yaroslavstarenkij/Desktop/GoIT/GIT/HomeWorkModule10/src/main/java/task1/file.txt");

        MyBufferingReading(file);

    }

    private static void MyBufferingReading(File file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            while (bf.ready()) {
                String line = bf.readLine();
                comparingPhoneNumbersFormat(line);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void comparingPhoneNumbersFormat(String line) {
        if (line.length() == 12) { // comparing First type of phone numbers
            int digitCounter = 0;
            int hyphen = 0;
            char[] chars = line.toCharArray();
            for (char aChar : chars) {
                if (aChar == '-') {
                    hyphen++;
                }
                if (Character.isDigit(aChar)) {
                    digitCounter++;
                }
            }
            if (digitCounter == 10 && hyphen == 2) {
                System.out.println(line);
            }

        }

        if (line.length() == 14) { // comparing Second type of phone numbers
            int digitCounter = 0;
            char[] chars = line.toCharArray();
            for (char aChar : chars) {
                if (Character.isDigit(aChar)) {
                    digitCounter++;
                }

            }
            if (digitCounter == 10 &&
                    chars[0] == '(' &&
                    chars[4] == ')' &&
                    chars[5] == ' ' &&
                    chars[9] == '-') {
                System.out.println(line);
            }

        }
    }
}
