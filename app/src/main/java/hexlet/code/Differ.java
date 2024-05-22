package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;



public class Differ {

    public static ArrayList<String> generate(String filepath1, String filepath2) throws Exception {
        Stylish defaultStyler = new Stylish();
        ArrayList<String> result = generate(filepath1, filepath2, defaultStyler);
        return result;
    }

    public static ArrayList<String> generate(String filepath1, String filepath2, Stylish styler) throws Exception {
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

        Map<String, Object> result = new HashMap<>(fileMap2);

        for (var key : fileMap1.keySet()) {
            Object objMap1 = fileMap1.get(key);
            Object objResult = result.get(key);

            if (objResult != null && !objResult.equals(objMap1)) {
                result.put("  + " + key, result.get(key));
                result.put("  - " + key, fileMap1.get(key));
                result.remove(key);
                fileMap2.remove(key);
            }
            if (objResult == null) {
                result.put("  - " + key, objMap1);
            }
        }

        for (var key : fileMap2.keySet()) {
            Object objMap1 = fileMap1.get(key);
            Object objResult = result.get(key);

            if (objMap1 != null && objResult != null) {
                result.put("    " + key, objResult);
                result.remove(key);
            } else  {
                result.put("  + " + key, objResult);
                result.remove(key);
            }
        }

        ArrayList<String> sortedResult = new ArrayList<>();
        sortedResult.add("    ");
        for (var key : result.keySet()) {
            sortedResult.add(key + ": " + result.get(key));
        }

        styler.resultToStyle(sortedResult);

        for (var str : sortedResult) {
            System.out.println(str);
        }
        return sortedResult;
    }

}
