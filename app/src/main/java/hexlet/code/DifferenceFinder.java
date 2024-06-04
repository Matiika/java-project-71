package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class DifferenceFinder {
    public static Map<String, OldNewValue> findDifferences(
            Map<String, Object> fileMap1, Map<String, Object> fileMap2) {
        Map<String, OldNewValue> result = new HashMap<>();
        for (var key : fileMap1.keySet()) {
            if (fileMap2.containsKey(key)) {
                var oldValue = fileMap1.get(key);
                var newValue = fileMap2.get(key);
                result.put(key, new OldNewValue(oldValue, newValue));
            }
            if (!fileMap2.containsKey(key)) {
                var oldValue = fileMap1.get(key);
                var newValue = "";
                result.put(key, new OldNewValue(oldValue, newValue));
            }
        }

        for (var key : fileMap2.keySet()) {
            if (!result.containsKey(key)) {
                var oldValue = "";
                var newValue = fileMap2.get(key);
                result.put(key, new OldNewValue(oldValue, newValue));
            }
        }
        return result;
    }
}
