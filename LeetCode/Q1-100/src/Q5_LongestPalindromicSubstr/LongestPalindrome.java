package Q5_LongestPalindromicSubstr;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start_i = 0, max_l = 1;

        for(int i=0; i<n; i++){
            dp[i][i] = true;
            for(int j=0; j<i; j++){
                // the even condition
                if(j == i-1 && s.charAt(j)==s.charAt(i)){
                    dp[j][i] = true;
                    if(max_l < 2){
                        max_l = 2;
                        start_i = j;
                    }
                }

                if(dp[j+1][i-1] && s.charAt(i) == s.charAt(j)){
                    dp[j][i] = true;
                    if(max_l < i-j){
                        max_l = i-j;
                        start_i = j;
                    }
                }

            }
        }
        return s.substring(start_i, start_i+max_l+1);
    }
}
