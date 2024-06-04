package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;



public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {

        Map<String, Object> fileMap1 = readFile(filepath1);
        Map<String, Object> fileMap2 = readFile(filepath2);
        Map<String, OldNewValue> result = DifferenceFinder.findDifferences(fileMap1, fileMap2);
//        String fileResult = Formatter.formatterChoose(result, formatName);
//        Files.write(Paths.get("./src/test/resources/fixtures/resultTestYMLPlain.txt"), fileResult.getBytes());

        return Formatter.formatterChoose(result, formatName);

    }

    public static HashMap readFile(String filepath) throws Exception {
        Path path = Paths.get(filepath);
        Path path1 = path.toAbsolutePath().normalize();

        // Проверяем существование файла
        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }

        // Читаем файл
        String content1 = Files.readString(path1);

        if (filepath.contains(".yml") || filepath.contains(".yaml")) {
            return Parser.parseYaml(content1);
        } else {
            return Parser.parseJson(content1);
        }
    }

}
