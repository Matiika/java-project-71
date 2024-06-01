package hexlet.code.formatters;

import hexlet.code.OldNewValue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;

public class Plain {
    public static String resultToStyle(Map<String, OldNewValue> result) {
        String finalResult = "";
        ArrayList<String> sortedKeys = new ArrayList<>();
        sortedKeys.addAll(result.keySet());
        sortedKeys.sort(Comparator.naturalOrder());

        for (var key : sortedKeys) {
            var oldValue = result.get(key).getOldValue();
            var newValue = result.get(key).getNewValue();
            var oldValueString = objToString(result.get(key).getOldValue());
            var newValueString = objToString(result.get(key).getNewValue());
            if (oldValue != null && newValue != null) {
                if (!oldValue.equals(newValue) && !oldValue.equals("") && !newValue.equals("")) {
                    finalResult += "\nProperty '" + key + "' was updated. From "
                            + oldValueString + " to " + newValueString;
                }
                if (!oldValue.equals(newValue) && oldValue.equals("") && !newValue.equals("")) {
                    finalResult += "\nProperty '" + key + "' was added with value: " + newValueString;
                }
                if (!oldValue.equals(newValue) && !oldValue.equals("") && newValue.equals("")) {
                    finalResult += "\nProperty '" + key + "' was removed";
                }
            } else {
                finalResult += "\nProperty '" + key + "' was updated. From " + oldValueString + " to " + newValueString;
            }
        }

        System.out.println(finalResult.replaceAll("^(\\s*\\n)", ""));
        finalResult = finalResult.replaceAll("^(\\s*\\n)", "");
        return finalResult;
    }

    public static String objToString(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }

        // Тип результата всегда должен быть строкой.
        return value.toString();
    }
}
