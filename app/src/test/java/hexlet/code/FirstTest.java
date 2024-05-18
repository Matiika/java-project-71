package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import  static hexlet.code.Differ.generate;

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
                "  + timeout: 20",
                "  - timeout: 50",
                "  + verbose: true",
                "}"));
        assertEquals(actual, expected);
    }
}
