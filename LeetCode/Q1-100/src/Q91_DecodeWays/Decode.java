package Q91_DecodeWays;

public class Decode {
    public int numDecodings(String s) {
        int n = s.length();
        // s[0:n] can form X codes
        int[] dp = new int[n+1];

        // dp[0] is 0
        dp[0] = 1;
        // dp[1]
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            dp[1] = 1;
        }
        else {
            return 0;
        }

        for (int i=2; i<=n; i++) {
            char c = s.charAt(i-1);
            char prevC = s.charAt(i-2);

            if (prevC == '0' && c == '0') {
                return 0;
            }
            if (prevC == '1') {
                if (c == '0') {
                    dp[i] = dp[i-2];
                }
                else {
                    dp[i] = dp[i-2] + dp[i-1];
                }
            }
            else if (prevC == '2') {
                if (c == '0') {
                    dp[i] = dp[i-2];
                }
                else if (c>='1' && c<='6') {
                    dp[i] = dp[i-2] + dp[i-1];
                }
                else {
                    dp[i] = dp[i-1];
                }
            }
            else if (c == '0') {
                return 0;
            }
            else {
                dp[i] = dp[i-1];
            }
        }

        return dp[n];
    }
}
