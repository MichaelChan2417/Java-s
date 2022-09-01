package Q1_4;

public class Q1_4 {
    /**
     * The most direct way is to have a 26-store count
     */
    public static boolean isPermutationOfPalindrome(String str){
        int[] charTable = new int[26];
        // build the char table
        for (char c : str.toCharArray()) {
            if (c>='a' && c<='z') {
                charTable[c-'a']++;
            }
        }
        // check idup of chars
        boolean foundOdd = false;
        for(int num : charTable){
            if (num % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    // test
    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println(isPermutationOfPalindrome(pali));
    }
}

/**
 * We can improve the algorithm with less space cost, using bit vector
 */
class Q1_4B{
    public static boolean isPermutationOfPalindrome(String str){
        int meet = 0;
        str = str.toLowerCase();
        // build the meet int
        for(char c : str.toCharArray()){
            if (c>='a' && c<='z') {
                meet ^= 1<<(c-'a');
            }
        }

        // I can use this way
        // checkAtMostOneBitSet(meet);

        // Or, traditionally, count how many 1s in meet
        boolean meetOne = false;
        while (meet > 0) {
            int cnt = meet & 1;
            if (cnt == 1) {
                if (meetOne) {
                    return false;
                }
                meetOne = true;
            }
            meet >>= 1;
        }
        return true;
    }

    /* Check that at most one bit is set by subtracting one from the
     * integer and ANDing it with the original integer. */
    public static boolean checkAtMostOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    // test
    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println(isPermutationOfPalindrome(pali));
    }
}