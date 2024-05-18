package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.ArrayList;


public class Differ {
    public static ArrayList<String> generate(String filepath1, String filepath2) throws Exception {
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


        HashMap<String, Object> fileMap1 =
                new ObjectMapper().readValue(content1, HashMap.class);

        HashMap<String, Object> fileMap2 =
                new ObjectMapper().readValue(content2, HashMap.class);

        Map<String, Object> result = new HashMap<>(fileMap2);

        for (var key : fileMap1.keySet()) {
            if (result.containsKey(key)) {
                if (!fileMap1.get(key).equals(result.get(key))) {
                    result.put("  + " + key, result.get(key));
                    result.put("  - " + key, fileMap1.get(key));
                    result.remove(key);
                    fileMap2.remove(key);
                }
            }
            if (!result.containsKey(key)) {
                result.put("  - " + key, fileMap1.get(key));
            }
        }

        for (var key : fileMap2.keySet()) {
            if (fileMap1.containsKey(key)) {
                result.put("    " + key, result.get(key));
                result.remove(key);
            } else  {
                result.put("  + " + key, result.get(key));
                result.remove(key);
            }
        }

        Comparator<String> comparator = Comparator.comparing(key -> key.substring(3));

        ArrayList<String> sortedResult = new ArrayList<>();
        sortedResult.add("    ");
        for (var key : result.keySet()) {
            sortedResult.add(key + ": " + result.get(key));
        }
        sortedResult.sort(comparator);
        sortedResult.set(0, "{");
        sortedResult.add("}");


        for (var str : sortedResult) {
            System.out.println(str);
        }
        return sortedResult;
    }

}
