package hexlet.code.formatters;

//import hexlet.code.OldNewValue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;

public class Plain {
    private static final int STATUS_OF_DIFFERENCE = 0;
    private static final int OLD_VALUE = 1;
    private static final int NEW_VALUE = 2;
    private static final int ONLY_WHEN_STATUS_ADDED = 1;

    /*public static String resultToStyle(Map<String, OldNewValue> result) {
        String finalResult = "";
        ArrayList<String> sortedKeys = new ArrayList<>(result.keySet());
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
    }*/

    public static String resultToStyleMap(Map<String, List<Object>> result) {
        String finalResult = "";
        ArrayList<String> sortedKeys = new ArrayList<>(result.keySet());
        sortedKeys.sort(Comparator.naturalOrder());

        for (var key : sortedKeys) {
            String status = (String) result.get(key).get(STATUS_OF_DIFFERENCE);
            var oldValue = objToString(result.get(key).get(OLD_VALUE));

            switch (status) {
                case "changed":
                    finalResult += "\nProperty '" + key + "' was updated. From "
                            + oldValue + " to " + objToString(result.get(key).get(NEW_VALUE));
                    break;
                case "deleted":
                    finalResult += "\nProperty '" + key + "' was removed";
                    break;
                case "added":
                    finalResult += "\nProperty '" + key + "' was added with value: "
                            + objToString(result.get(key).get(ONLY_WHEN_STATUS_ADDED));
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException();
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
