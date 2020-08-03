package task2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueNameFinder {

    protected static String findUniqueName(ArrayList<String> names) {

        Integer countdown = 0;
        final LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (String s : names) {
            Integer count = map.getOrDefault(s, countdown);
            map.put(s, count + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return "there aren't unique elements";
    }
}
