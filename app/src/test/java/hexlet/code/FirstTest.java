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
    public void testJsonCompareEmpty() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.json", "./src/test/resources/file2.json");
        String expected = fileToString("./src/test/resources/fixtures/resultTestStylish.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testJsonCompareStylish() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.json", "./src/test/resources/file2.json",
                "stylish");
        String expected = fileToString("./src/test/resources/fixtures/resultTestStylish.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testJsonComparePlain() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.json",
                "./src/test/resources/file2.json", "plain");
        String expected = fileToString("./src/test/resources/fixtures/resultTestPlain.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testJsonCompareJson() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.json",
                "./src/test/resources/file2.json", "json");
        String expected = fileToString("./src/test/resources/fixtures/resultTestJson.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testYMLCompareEmpty() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.yml", "./src/test/resources/file2.yml");
        String expected = fileToString("./src/test/resources/fixtures/resultTestStylish.txt");
        assertEquals(actual, expected);
    }
    @Test
    public void testYMLCompareStylish() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.yml", "./src/test/resources/file2.yml",
                "stylish");
        String expected = fileToString("./src/test/resources/fixtures/resultTestStylish.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testYMLComparePlain() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.yml",
                "./src/test/resources/file2.yml", "plain");
        String expected = fileToString("./src/test/resources/fixtures/resultTestPlain.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testYMLCompareJson() throws Exception {
        String actual = Differ.generate("./src/test/resources/file1.yml",
                "./src/test/resources/file2.yml", "json");
        String expected = fileToString("./src/test/resources/fixtures/resultTestJson.txt");
        assertEquals(actual, expected);
    }
}
