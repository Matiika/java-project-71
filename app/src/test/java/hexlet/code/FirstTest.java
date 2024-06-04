package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {
    public static String fileToString(String filePathString) throws IOException {
        Path filePath = Paths.get(filePathString);
        return Files.readString(filePath).trim();
    }

    @Test
    public void testJsonCompareStylish() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.json", "./src/test/resources/file2.json");
        String expected = fileToString("./src/test/resources/fixtures/resultTestJsonStylish.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testJsonComparePlain() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.json",
                "./src/test/resources/file2.json", "plain");
        String expected = fileToString("./src/test/resources/fixtures/resultTestJsonPlain.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testYMLCompareStylish() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.yml", "./src/test/resources/file2.yml");
        String expected = fileToString("./src/test/resources/fixtures/resultTestYMLStylish.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testYMLComparePlain() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.yml",
                "./src/test/resources/file2.yml", "plain");
        String expected = fileToString("./src/test/resources/fixtures/resultTestYMLPlain.txt");
        assertEquals(actual, expected);
    }
}
