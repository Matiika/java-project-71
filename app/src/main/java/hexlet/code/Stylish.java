package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;

public class Stylish {
    public static void resultToStyle(ArrayList<String> result) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Apply the function to the strings
                if (s1.length() < 5 || s2.length() < 5) {
                    return s1.compareTo(s2);
                }
                String sub1 = s1.substring(4, s1.indexOf(':'));
                String sub2 = s2.substring(4, s2.indexOf(':'));
                if (sub1.equals(sub2)) {
                    return s2.substring(2, 3).compareTo(s1.substring(2, 3));
                }
                // Compare the results
                return sub1.compareTo(sub2);
            }
        };

        result.sort(comparator);
        result.set(0, "{");
        result.add("}");
    }
}
