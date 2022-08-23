package Q1062_LongestRepSubstring;

import java.util.HashMap;

public class LongestRepSubstring {
    public boolean search(String s, int L, int[] code){
        long module = 1<<25;
        int c0 = 0;

        long curhash = 0L;
        long mark = 1L;
        for(int i=0; i<L; i++){
            curhash = (curhash*26 + code[i]) % module;
            mark = mark * 26 % module;
        }

        HashMap<Long, Integer> codeToIndex = new HashMap<>();
        codeToIndex.put(curhash, 0);

        for(int i=1; i<s.length()-L+1; i++){
            curhash = (curhash * 26 - code[i-1] * mark % module + module) % module;
            curhash = (curhash + code[i+L-1]) % module;

            if(!codeToIndex.containsKey(curhash)){
                codeToIndex.put(curhash, i);
            }
            else{
                int i1 = codeToIndex.get(curhash);
                if(s.substring(i1, i1+L).equals(s.substring(i, i+L))){
                    return true;
                }
                else{
                    codeToIndex.put(curhash, i);
                }
            }
        }

        return false;
    }

    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;

        int[] code = new int[n];
        for(int i=0; i<n; i++){
            code[i] = s.charAt(i) - 'a';
        }

        while(left <= right){
            int L = (left + right) >> 1;

            if (search(s, L, code)) {
                left = L + 1;
                continue;
            }
            right = L - 1;
        }

        return left - 1;
    }
}
