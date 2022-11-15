package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("/Users/yaroslavstarenkij/Desktop/GoIT/GIT/HomeWorkModule10/src/main/java/task3/words.txt");
        ArrayList<String> words = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        readingAndWritingWordsFromFile(file, words);

        countWordsFrequency(words, map);

        wordsPrinter(map);

    }

    private static void readingAndWritingWordsFromFile(File file, ArrayList<String> words) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void countWordsFrequency(ArrayList<String> words, HashMap<String, Integer> map) {
        int length = new HashSet<>(words).size();
        int frequency = 0;
        int counter = 0;
        while (map.size() < length) {

            for (String word : words) {
                if (words.get(counter).equals(word)) {
                    frequency++;
                }
            }
            map.put(words.get(counter), frequency);
            counter++;
            frequency = 0;
        }







    }

    private static void wordsPrinter(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for (int i = list.size()-1; i >= 0; i--) {
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
        }
    }

}
