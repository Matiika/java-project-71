package hexlet.code;

import java.util.Map;
import java.util.HashMap;



public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {

        Map<String, Object> fileMap1 = Parser.parseFile(filepath1);

        Map<String, Object> fileMap2 = Parser.parseFile(filepath2);

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

        String finalResult = Formatter.formatterChoose(result, formatName);
        System.out.println(finalResult);

        return finalResult;
    }

}
