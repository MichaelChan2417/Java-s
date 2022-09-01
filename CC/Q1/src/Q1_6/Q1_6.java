package Q1_6;
/**
 * return Compressed string if the length is decreased: aabcccaaaa -> a2b1c3a4
 * Simulation
 */
public class Q1_6 {
    public static String stringCompress(String str){
        int ptr = 0;
        int n = str.length();
        StringBuilder sb = new StringBuilder(n);

        int cur = 0;
        while (ptr < n) {
            cur++;
            if (ptr+1 >= n || str.charAt(ptr) != str.charAt(ptr+1)) {
                sb.append(str.charAt(ptr));
                sb.append(cur);
                cur = 0;
            }
            ptr++;
        }

        String newStr = sb.toString();
        return newStr.length() < str.length() ? newStr : str;
    }

}
