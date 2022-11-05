package Q1_9;

/**
 * detect whether the given two string could be rotate to be the same
 */
public class Q1_9 {
    public static boolean isSubstring(String s1, String s2){
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        int startIndex = 0;
        int i=0;
        while (i < n) {
            int j = 0;
            startIndex = i;
            while (i<n && s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }

            if (i == n) {
                int index = 0;
                while (j<n && s1.charAt(index) == s2.charAt(j)) {
                    index++;
                    j++;
                }
                if (j == n) {
                    return true;
                }
            }

            i -= j;
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isSubstring(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}

/**
 * Consider string s1+s1; there should be a s2 in it
 */
class Q1_9B {
    public static boolean isSubstring(String s1, String s2){
        StringBuilder sb1 = new StringBuilder(s1+s1);
        String doubleS1 = sb1.substring(1, sb1.length()-1);
        return doubleS1.contains(s2);
    }
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isSubstring(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}