package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;



public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        // Формируем абсолютный путь,
        // если filePath будет содержать относительный путь,
        // то мы всегда будет работать с абсолютным
        Path path = Paths.get(filepath1);
        Path path1 = path.toAbsolutePath().normalize();
        path = Paths.get(filepath2);
        Path path2 = path.toAbsolutePath().normalize();

        // Проверяем существование файла
        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }

        if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        // Читаем файл
        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);


        Map<String, Object> fileMap1 = Parser.parseYaml(content1);

        Map<String, Object> fileMap2 = Parser.parseYaml(content2);

        Map<String, OldNewValue> result = new HashMap<>();

        for (var key : fileMap1.keySet()) {
            if (fileMap2.containsKey(key)) {
                var oldValue = fileMap1.get(key);
                var newValue = fileMap2.get(key);
                result.put(key, new OldNewValue(oldValue, newValue));
            }
            if (!fileMap2.containsKey(key)) {
                var oldValue = fileMap1.get(key);
                var newValue = "";
                result.put(key, new OldNewValue(oldValue, newValue));
            }
        }

        for (var key : fileMap2.keySet()) {
            if (!result.containsKey(key)) {
                var oldValue = "";
                var newValue = fileMap2.get(key);
                result.put(key, new OldNewValue(oldValue, newValue));
            }
        }

        String finalResult = Stylish.resultToStyle(result);
        System.out.println(finalResult);
        return finalResult;
    }

}
