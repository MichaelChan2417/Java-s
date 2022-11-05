package Q318_MaxWordMult;

import java.util.HashMap;

public class MaxWordMult {
    public int maxProduct(String[] words) {
        HashMap<String, Integer> word2Code = new HashMap<>();
        for (String word : words) {
            int code = encode(word);
            word2Code.put(word, code);
        }

        int n = words.length;
        int curmax = 0;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                String s1 = words[i];
                String s2 = words[j];
                int l1 = s1.length();
                int l2 = s2.length();
                int code1 = word2Code.get(s1);
                int code2 = word2Code.get(s2);
                if ((code1 & code2) == 0) {
                    if (l1 * l2 > curmax) {
                        curmax = l1 * l2;
                    }
                }
            }
        }
        return curmax;
    }

    private int encode(String word) {
        int retVal = 0;
        for (int i=0; i<word.length(); i++) {
            char bit = word.charAt(i);
            retVal |= (1 << (bit - 'a'));
        }
        return retVal;
    }
}
