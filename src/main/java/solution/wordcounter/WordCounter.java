package solution.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

        private Scanner getScanner(File file) throws FileNotFoundException {
            return new Scanner(file);
        }

        public Map<String, Integer> countWords(File file) throws FileNotFoundException {
            Scanner scanner = getScanner(file);
            final Map<String, Integer> countMap = new HashMap<>();
            if(!scanner.hasNext()) System.out.println("File is empty");
            while (scanner.hasNext()) {
                String value = scanner.next();
                String word = value.replaceAll("[^a-zA-Z]", "");
                if (word.isEmpty()) continue;
                Integer count = countMap.get(word);
                if (count != null) {
                    countMap.put(word, ++count);
                } else {
                    countMap.put(word, 1);
                }
            }
            scanner.close();

            return countMap;
        }
}