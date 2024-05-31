package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String formatterChoose(Map<String, OldNewValue> result, String formatName)
            throws JsonProcessingException {
        switch (formatName) {
            case "plain":
                return Plain.resultToStyle(result);
            case "json":
                return Json.resultToStyle(result);
            default:
                return Stylish.resultToStyle(result);
        }
    }
}
