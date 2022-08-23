package Q981_TimeBasedHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedHashMap {
    class TimeMap {

         HashMap<String, TreeMap<Integer, String>> gmap;
        public TimeMap() {
            gmap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> timeMap = gmap.getOrDefault(key, new TreeMap<>());
            timeMap.put(timestamp, value);
            gmap.put(key, timeMap);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> timeMap = gmap.getOrDefault(key, null);
            if(timeMap == null) return "";

            Map.Entry<Integer, String> entry = timeMap.floorEntry(timestamp);
            if(entry == null) return "";

            return entry.getValue();
        }
    }
}
