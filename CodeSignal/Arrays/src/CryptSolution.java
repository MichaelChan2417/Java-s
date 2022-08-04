import java.util.Arrays;
import java.util.HashMap;

/**
 * You have an array of strings crypt, the cryptarithm, and an an array containing
 * the mapping of letters and digits, solution.
 * The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3],
 * which should be interpreted as the word1 + word2 = word3 cryptarithm.
 *
 * If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits
 * using the mapping in solution, becomes a valid arithmetic equation containing no numbers with leading zeroes,
 * the answer is true. If it does not become a valid arithmetic solution, the answer is false.
 */
public class CryptSolution {
    /**
     * Simulation of Solution steps
     * @param crypt
     * @param solution which is a key-value map
     * @return
     */
    boolean Mysolution(String[] crypt, char[][] solution) {
        HashMap<Character, Integer> keymap = new HashMap<Character, Integer>();

        for(char[] cp : solution){
            keymap.put(cp[0], cp[1]-'0');
        }

        int[] ints = new int[3];
        int index = 0;

        for(String s : crypt){
            // zero-judge
            char c0 = s.charAt(0);
            if(keymap.get(c0) == 0){
                if(s.length() != 1){
                    return false;
                }
                ints[index++] = 0;
                continue;
            }

            for(char c : s.toCharArray()){
                ints[index] = ints[index]*10 + keymap.get(c);
            }
            index++;
        }

        return ints[0] + ints[1] == ints[2];
    }

    /**
     * Replace First, then judge. Using the built functions.
     */
    boolean osolution(String[] crypt, char[][] solution) {
        for(char[] arr : solution){
            for(int i = 0; i < crypt.length; i++){
                crypt[i]=crypt[i].replace(arr[0],arr[1]);
            }
            System.out.println(Arrays.toString(crypt));
        }

        for(int i = 0; i < crypt.length; i++){
            if(!crypt[i].equals("0")&&crypt[i].startsWith("0"))
                return false;
        }

        return Long.parseLong(crypt[0])+Long.parseLong(crypt[1])==Long.parseLong(crypt[2]);
    }

}
