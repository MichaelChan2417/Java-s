import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string s consisting of small English letters,
 * find and return the first instance of a non-repeating character in it.
 * If there is no such character, return '_'.
 */
public class firstNotRepeatingChar {

    char mysolution(String s) {
        HashMap<Character, Integer> mapp = new LinkedHashMap<Character, Integer>();

        // putting in all the chars
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int nums = mapp.getOrDefault(c, 0);
            mapp.put(c, nums+1);
        }

        Iterator<Map.Entry<Character, Integer>> iter = mapp.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry enty = iter.next();

            Character key = (Character) enty.getKey();
            Integer value = (Integer) enty.getValue();
            if(value == 1){
                return key;
            }
        }
        return '_';
    }


    // Other Solution 1
    char osolution1(String s) {
        char[] c=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(s.indexOf(c[i])==s.lastIndexOf(c[i]))
                return c[i];
        }
        return '_';
    }


    // Other Solution 2
    char osolution2(String s) {
        int[] counter = new int[26];

        for (char c : s.toCharArray()) counter[c - 'a']++;

        for (char c : s.toCharArray()) {
            if (counter[c - 'a'] == 1) return c;
        }

        return '_';
    }

}

