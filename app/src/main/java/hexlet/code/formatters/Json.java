package hexlet.code.formatters;

//import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.OldNewValue;

import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Json {
    public static String resultToStyle(Map<String, OldNewValue> result) throws Exception {
        Map<String, OldNewValue> sortedMap = new TreeMap<>(result);
        return new ObjectMapper().writeValueAsString(sortedMap);
    }
}
