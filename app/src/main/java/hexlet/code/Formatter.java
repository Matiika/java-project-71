package hexlet.code;

//import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    /*public static String formatterChoose(Map<String, OldNewValue> result, String formatName)
            throws Exception {
        return switch (formatName) {
            case "plain" -> Plain.resultToStyle(result);
            case "json" -> Json.resultToStyle(result);
            default -> Stylish.resultToStyle(result);
        };
    }*/

    public static String formatterChooseMap(Map<String, List<Object>> result, String formatName)
            throws Exception {
        return switch (formatName) {
            case "plain" -> Plain.resultToStyleMap(result);
            case "json" -> Json.resultToStyleMap(result);
            default -> Stylish.resultToStyleMap(result);
        };
    }
}
