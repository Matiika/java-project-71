package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    @Test
    public void testJsonCompareStylish() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.json", "./src/test/resources/file2.json");
        Path filePath = Paths.get("./src/test/resources/fixtures/resultTestJsonStylish.txt");
        String expected = Files.readString(filePath).trim();
        assertEquals(actual, expected);
    }

    @Test
    public void testJsonComparePlain() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.json",
                "./src/test/resources/file2.json", "plain");
        Path filePath = Paths.get("./src/test/resources/fixtures/resultTestJsonPlain.txt");
        String expected = Files.readString(filePath).trim();
        assertEquals(actual, expected);
    }

    @Test
    public void testYMLCompareStylish() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.yml", "./src/test/resources/file2.yml");
        Path filePath = Paths.get("./src/test/resources/fixtures/resultTestYMLStylish.txt");
        String expected = Files.readString(filePath).trim();
        assertEquals(actual, expected);
    }

    @Test
    public void testYMLComparePlain() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.yml",
                "./src/test/resources/file2.yml", "plain");
        Path filePath = Paths.get("./src/test/resources/fixtures/resultTestYMLPlain.txt");
        String expected = Files.readString(filePath).trim();
        assertEquals(actual, expected);
    }
}
