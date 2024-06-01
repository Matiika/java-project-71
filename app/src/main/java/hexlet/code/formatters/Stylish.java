package hexlet.code.formatters;

import hexlet.code.OldNewValue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Stylish {


    public static String resultToStyle(Map<String, OldNewValue> result) {
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
    }
}
