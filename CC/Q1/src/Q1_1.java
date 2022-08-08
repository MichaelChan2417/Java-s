import java.util.Arrays;

/**
 * Given a String, detect whether each Character is unique;(no repetitive)
 */
public class Q1_1 {
    public static boolean isUnique(String s){
        if(s.length() > 128) return false;
        boolean[] cont = new boolean[128];

        for(char c : s.toCharArray()){
            if(cont[c]){
                return false;
            }
            cont[c] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "I_.12da", "0HaopO"};
        for(String s : words){
            System.out.println(isUnique(s));
        }
    }

}

/**
 * Can you implement it without using extra structure?
 */
class Q1_1_B{
    // this is the O(NlogN) solution, need to sort and compare
    public static boolean isUnique(String s){
        char[] crs = s.toCharArray();
        Arrays.sort(crs);

        for(int i=0; i<s.length()-1; i++){
            if(crs[i] == crs[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for(String s : words){
            System.out.println(isUnique(s));
        }
    }
}

/**
 * -- Bit Operations?
 * In this case, we should assume that it only contains 'a' to 'z'
 */
class Q1_1_C{
    public static boolean isUnique(String s){
        if(s.length() > 26){
            return false;
        }
        int checker = 0;

        for(char c : s.toCharArray()){
            int diff = c - 'a';

            if((checker & (1<<diff)) > 0){
                return false;
            }
            checker = checker | (1<<diff);
        }
        return true;
    }
}