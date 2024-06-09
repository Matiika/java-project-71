package hexlet.code.formatters;

//import hexlet.code.OldNewValue;

import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stylish {
    private static final int STATUS_OF_DIFFERENCE = 0;
    private static final int OLD_VALUE = 1;
    private static final int NEW_VALUE = 2;
    private static final int ONLY_WHEN_STATUS_ADDED = 1;



    /*public static String resultToStyle(Map<String, OldNewValue> result) {
        ArrayList<String> sortedKeys = new ArrayList<>(result.keySet());
        sortedKeys.sort(Comparator.naturalOrder());
        String finalResult = "{";

        for (var key : sortedKeys) {
            var oldValue = result.get(key).getOldValue();
            var newValue = result.get(key).getNewValue();
            if (oldValue != null && newValue != null) {
                if (oldValue.equals(newValue)) {
                    finalResult += "\n    " + key + ": " + oldValue;
                }
                if (!oldValue.equals(newValue) && !oldValue.equals("") && !newValue.equals("")) {
                    finalResult += "\n  - " + key + ": " + oldValue;
                    finalResult += "\n  + " + key + ": " + newValue;
                }
                if (!oldValue.equals(newValue) && !oldValue.equals("") && newValue.equals("")) {
                    finalResult += "\n  - " + key + ": " + oldValue;
                }
                if (!oldValue.equals(newValue) && oldValue.equals("") && !newValue.equals("")) {
                    finalResult += "\n  + " + key + ": " + newValue;
                }
            } else {
                finalResult += "\n  - " + key + ": " + oldValue;
                finalResult += "\n  + " + key + ": " + newValue;
            }
        }
        finalResult += "\n}";
        System.out.println(finalResult);
        return finalResult;
    }*/

    public static String resultToStyleMap(Map<String, List<Object>> result) {
        ArrayList<String> sortedKeys = new ArrayList<>(result.keySet());
        sortedKeys.sort(Comparator.naturalOrder());
        String finalResult = "{";

        for (var key : sortedKeys) {
            String status = (String) result.get(key).get(STATUS_OF_DIFFERENCE);
            switch (status) {
                case "unchanged":
                    finalResult += "\n    " + key + ": " + result.get(key).get(OLD_VALUE);
                    break;
                case "changed":
                    finalResult += "\n  - " + key + ": " + result.get(key).get(OLD_VALUE);
                    finalResult += "\n  + " + key + ": " + result.get(key).get(NEW_VALUE);
                    break;
                case "deleted":
                    finalResult += "\n  - " + key + ": " + result.get(key).get(OLD_VALUE);
                    break;
                case "added":
                    finalResult += "\n  + " + key + ": " + result.get(key).get(ONLY_WHEN_STATUS_ADDED);
                    break;
                default:
                    throw new RuntimeException();
            }
        }

        finalResult += "\n}";
        System.out.println(finalResult);
        return finalResult;
    }
}
