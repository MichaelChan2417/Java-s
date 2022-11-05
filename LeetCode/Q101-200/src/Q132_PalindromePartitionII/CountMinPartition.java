package Q132_PalindromePartitionII;

import java.util.Arrays;

/**
 * Traditional DFS, TLE
 */
public class CountMinPartition {
    boolean[][] isPalin;
    int ans;
    int cur;

    public int minCut(String s) {
        int n = s.length();
        isPalin = new boolean[n][n];
        ans = n;
        cur = 0;

        // set up boolean table
        for (int i=0; i<n; i++) {
            isPalin[i][i] = true;
            for (int j=0; j<i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i-1) {
                        isPalin[j][i] = true;
                    }
                    if (j < i-1 && isPalin[j+1][i-1]) {
                        isPalin[j][i] = true;
                    }
                }
            }
        }

        // make count
        dfs(0, n-1);

        return ans;
    }

    private void dfs(int start, int last) {
        // System.out.println(start + " " + last + " " + cur);
        if (start == last || isPalin[start][last]) {
            if (cur < ans) {
                ans = cur;
            }
            return;
        }

        for (int i=last-1; i>=start; i--) {
            if (isPalin[start][i]) {
                cur++;
                dfs(i+1, last);
                cur--;
            }
        }
    }
}


/**
 * use dp to memorize min count from 0-i
 */
class dpCountMinPartition{

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];

        // set up boolean table
        for (int i=0; i<n; i++) {
            isPalin[i][i] = true;
            for (int j=0; j<i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i-1) {
                        isPalin[j][i] = true;
                    }
                    if (j < i-1 && isPalin[j+1][i-1]) {
                        isPalin[j][i] = true;
                    }
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, n);

        dp[0] = 0;
        for (int i=1; i<n; i++) {
            // fill dp[i]
            if (isPalin[0][i]) {
                dp[i] = 0;
            }
            else {
                for (int j=i-1; j>=0; j--) {
                    if (isPalin[j+1][i] && dp[j]<dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        return dp[n-1];
    }
}