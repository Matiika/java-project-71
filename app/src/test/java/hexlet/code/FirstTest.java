package hexlet.code;

import org.junit.jupiter.api.Test;
import  static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstTest {

    @Test
    public void testJsonCompare() throws Exception {
        ArrayList<String> actual = generate("./src/test/resources/file1.json", "./src/test/resources/file2.json");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("{",
                "  - follow: false",
                "    host: hexlet.io",
                "  - proxy: 123.234.53.22",
                "  - timeout: 50",
                "  + timeout: 20",
                "  + verbose: true",
                "}"));
        assertTrue(actual.equals(expected));
    }

    @Test
    public void testYMLCompare() throws Exception {
        ArrayList<String> actual = generate("./src/test/resources/file1.yml", "./src/test/resources/file2.yml");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("{",
                "  - follow: false",
                "    host: hexlet.io",
                "  - proxy: 123.234.53.22",
                "  - timeout: 50",
                "  + timeout: 20",
                "  + verbose: true",
                "}"));
        assertTrue(actual.equals(expected));
    }
}
