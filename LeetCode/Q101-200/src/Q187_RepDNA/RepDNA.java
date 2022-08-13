package Q187_RepDNA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Integer> cMap = new HashMap<>();
        cMap.put('A', 0);
        cMap.put('C', 1);
        cMap.put('G', 2);
        cMap.put('T', 3);

        if(s.length() < 10) return new ArrayList<>();

        char[] cs = s.toCharArray();

        HashMap<Integer, Integer> app = new HashMap<>();
        int cur = 0;
        for(int i=0; i<10; i++){
            cur <<= 2;
            cur |= cMap.get(cs[i]);
        }

        // now we get our base;
        app.put(cur, 1);
        List<String> ans = new ArrayList<>();

        for(int i=10; i<s.length(); i++){
            cur <<= 2;
            cur |= cMap.get(cs[i]);
            cur &= (1<<20)-1;

            int count = app.getOrDefault(cur, 0);
            app.put(cur, count+1);
            if(app.get(cur) == 2){
                ans.add(s.substring(i-10, i));
            }
        }

        return ans;
    }


}
