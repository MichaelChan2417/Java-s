package Q1_6;

/**
 * An improved way is to calculate the new length first; if it is shorter, do the concat
 */
public class Q1_6B {
    public static String stringCompress(String str){
        int finalLength = getNewLength(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength); // initialize capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different from current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    public static int getNewLength(String str){
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
}
