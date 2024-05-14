package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Differ {
    public static void generate(String filepath1, String filepath2) throws Exception {
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
        // Выводим содержимое
        System.out.println(content1);
        System.out.println(content2);


        HashMap<String,Object> fileMap1 =
                new ObjectMapper().readValue(content1, HashMap.class);

        HashMap<String,Object> fileMap2 =
                new ObjectMapper().readValue(content2, HashMap.class);

        Map<String, Object> result = new HashMap<>();

        for (var fileMap : fileMap2.entrySet()) {
            String key = fileMap.getKey();
            if (fileMap1.containsKey(key)) {
                if (fileMap1.get(key).equals(fileMap2.get(key))) {
                    result.put("   " + key, fileMap1.get(key));
                }
                if (!fileMap1.get(key).equals(fileMap2.get(key))) {
                    result.put(" - " + key, fileMap1.get(key));
                    result.put(" + " + key, fileMap2.get(key));
                }
            }
            if(!fileMap1.containsKey(key)) {
                result.put(" + " + key, fileMap2.get(key));
            }
        }

        for (var fileMap : fileMap1.entrySet()) {
            String key = fileMap.getKey();
            if(!fileMap2.containsKey(key)) {
                result.put(" - " + key, fileMap1.get(key));
            }
        }

        List sortedKeys=new ArrayList(result.keySet());
        Collections.sort(sortedKeys);


        for (var entry : sortedKeys) {
            System.out.println(entry + ": " + result.get(entry));
        }


    }
}
