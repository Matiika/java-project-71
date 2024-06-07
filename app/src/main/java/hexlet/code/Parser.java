package hexlet.code;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;

public class Parser {

    public static HashMap findFileTypeAndParse(String content, String filepath) throws Exception {
        if (filepath.contains(".yml") || filepath.contains(".yaml")) {
            return Parser.parseYaml(content);
        } else {
            return Parser.parseJson(content);
        }
    }

    public static HashMap parseYaml(String content) throws Exception  {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(content, new TypeReference<>() { });
    }

    public static HashMap parseJson(String content) throws Exception  {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<>() { });
    }
}
