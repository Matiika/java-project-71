package hexlet.code;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Parser {
    public static HashMap parseFile(String filepath) throws Exception {
        // Формируем абсолютный путь,
        // если filePath будет содержать относительный путь,
        // то мы всегда будет работать с абсолютным
        Path path = Paths.get(filepath);
        Path path1 = path.toAbsolutePath().normalize();

        // Проверяем существование файла
        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }

        // Читаем файл
        String content1 = Files.readString(path1);

        if (filepath.contains(".yml") || filepath.contains(".yaml")) {
            return parseYaml(content1);
        } else {
            return parseJson(content1);
        }
    }
    public static HashMap parseYaml(String content) throws Exception  {
        return new YAMLMapper().readValue(content, HashMap.class);
    }

    public static HashMap parseJson(String content) throws Exception  {
        return new ObjectMapper().readValue(content, HashMap.class);
    }
}
