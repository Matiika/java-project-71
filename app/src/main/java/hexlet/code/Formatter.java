package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String formatterChoose(Map<String, OldNewValue> result, String formatName) {
        String finalResult = "";
        switch (formatName) {
            case "plain":
                return Plain.resultToStyle(result);
            default:
                return Stylish.resultToStyle(result);
        }
    }
}
