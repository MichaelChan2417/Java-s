import java.util.Arrays;
import java.util.HashMap;

/**
 * Check Permutation
 */

// Two ways, Sort / Use HashTable
public class Q1_2 {
    public static boolean checkPer(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for(int i=0; i<c1.length; i++){
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = checkPer(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}

class Q1_2_B{
    public static boolean checkPer(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s1.toCharArray()){
            int trad = map.getOrDefault(c, 0);
            map.put(c, trad+1);
        }

        for(char c : s2.toCharArray()){
            int td = map.getOrDefault(c, 0);
            if(td == 0){
                return false;
            }
            map.put(c, td-1);
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = checkPer(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
