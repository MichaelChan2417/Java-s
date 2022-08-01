package Q3_LongestSubstringNoDup;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstrNoDup {

    public static int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        HashSet<Character> table = new HashSet<Character>();

        int n = cs.length;
        int ans = 0;
        int i=0, j=0;

        while(j < n){
            char c = cs[j];

            if(!table.contains(c)){
                j++;
                table.add(c);
                continue;
            }

            ans = Math.max(ans, j-i);
            while(table.contains(c)){
                table.remove(cs[i]);
                i++;
            }
        }
        ans = Math.max(ans, j-i);

        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcacdhj");
    }
}
