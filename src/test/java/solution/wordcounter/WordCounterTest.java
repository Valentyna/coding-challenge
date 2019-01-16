package solution.wordcounter;

import org.junit.Test;
import solution.wordcounter.WordCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {
    private final ClassLoader classLoader = getClass().getClassLoader();
    private final File emptyFile = new File(Objects.requireNonNull(classLoader.getResource("empty.txt")).getFile());
    private final File mainFile = new File(Objects.requireNonNull(classLoader.getResource("main.txt")).getFile());
    private final WordCounter wordCounter = new WordCounter();

    @Test
    public void testContentAndSize() throws FileNotFoundException {
        Map actual = wordCounter.countWords(mainFile);

        assertEquals(5, actual.get("you"));
        assertEquals(1, actual.get("Fairbanks"));
        assertEquals(41, actual.size());
    }

    @Test
    public void testEmptyFile() throws FileNotFoundException {
        Map actual = wordCounter.countWords(emptyFile);
        assertEquals(0, actual.size());
    }

    @Test(expected = FileNotFoundException.class)
    public void testNoFile() throws FileNotFoundException {
        wordCounter.countWords(new File("./properties/files/ListStopWords.txt"));

    }

    // more tests for file size, format
}
