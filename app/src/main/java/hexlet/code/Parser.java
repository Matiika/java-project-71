package hexlet.code;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseYaml(String content) throws Exception  {
        return new YAMLMapper().readValue(content, HashMap.class);
    }

    public static Map<String, Object> parseJson(String content) throws Exception  {
        return new ObjectMapper().readValue(content, HashMap.class);
    }
}
