package hexlet.code;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;

public class Parser {

    public static HashMap parseYaml(String content) throws Exception  {
        return new YAMLMapper().readValue(content, HashMap.class);
    }

    public static HashMap parseJson(String content) throws Exception  {
        return new ObjectMapper().readValue(content, HashMap.class);
    }
}
