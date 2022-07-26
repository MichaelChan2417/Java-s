package Q14_LongestCommonPrefix;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 1) return strs[0];

        boolean flag = true;
        int bit = 0;
        int min_len = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            min_len = Math.min(min_len, strs[i].length());
        }

        StringBuilder ans = new StringBuilder();

        while(flag && bit<min_len){
            char c = strs[0].charAt(bit);

            for(int i=1; i<n; i++){
                if(strs[i].charAt(bit) != c){
                    flag = false;
                    break;
                }
            }

            if(flag){
                ans.append(c);
                bit++;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

    }
}
