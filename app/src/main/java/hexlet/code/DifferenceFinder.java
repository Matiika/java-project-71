package hexlet.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class DifferenceFinder {
    /*public static Map<String, OldNewValue> findDifferences(
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
    }*/

    public static Map<String, List<Object>> findDifferencesToMap(
            Map<String, Object> fileMap1, Map<String, Object> fileMap2) {
        Map<String, List<Object>> result = new HashMap<>();

        for (var key : fileMap1.keySet()) {
            var oldValue = fileMap1.get(key);
            var newValue = fileMap2.get(key);
            if (fileMap2.containsKey(key)) {
                if (oldValue != null && newValue != null && oldValue.equals(newValue)) {
                    result.put(key, List.of("unchanged", oldValue));
                }

                if (oldValue != null && newValue != null && !oldValue.equals(newValue)) {
                    result.put(key, List.of("changed", oldValue, newValue));
                }

                if (oldValue == null || newValue == null) {
                    result.put(key, Arrays.asList("changed", oldValue, newValue));
                }
            }
            if (!fileMap2.containsKey(key)) {
                result.put(key, List.of("deleted", oldValue));
            }
        }

        for (var key : fileMap2.keySet()) {
            var newValue = fileMap2.get(key);
            if (!result.containsKey(key)) {
                result.put(key, List.of("added", newValue));
            }
        }

        return result;
    }
}
