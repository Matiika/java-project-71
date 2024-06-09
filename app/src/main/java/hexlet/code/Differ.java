package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {

        Map<String, Object> fileMap1 = readFile(filepath1);
        Map<String, Object> fileMap2 = readFile(filepath2);
  //      Map<String, OldNewValue> result = DifferenceFinder.findDifferences(fileMap1, fileMap2);
        Map<String, List<Object>> result = DifferenceFinder.findDifferencesToMap(fileMap1, fileMap2);

   //     String fileResult = Formatter.formatterChooseMap(result, formatName);
    //    Files.write(Paths.get("./src/test/resources/fixtures/resultTestJson.txt"), fileResult.getBytes());

        return Formatter.formatterChooseMap(result, formatName);

    }

    public static HashMap readFile(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        // Проверяем существование файла
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        // Читаем файл
        String content1 = Files.readString(path);

        return Parser.findFileTypeAndParse(content1, filepath);
    }

}
