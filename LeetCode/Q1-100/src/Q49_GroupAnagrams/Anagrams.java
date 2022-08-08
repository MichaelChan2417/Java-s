package Q49_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<Integer>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            char[] temp = str.toCharArray();

            Arrays.sort(temp);
            String ns = String.copyValueOf(temp);

            List<Integer> indexes = map.getOrDefault(ns, new ArrayList<Integer>());
            indexes.add(i);
            map.put(ns, indexes);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            List<Integer> is = map.get(key);
            List<String> temp = new ArrayList<>();

            for(int i=0; i<is.size(); i++){
                temp.add(strs[is.get(i)]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
