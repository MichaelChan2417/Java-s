public class Q96_DiffBST {
    public int numTrees(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            int hold = 0;
            for (int j=0; j<=i-1; j++) {
                hold += dp[j] * dp[i-1-j];
            }
            dp[i] = hold;
        }
        return dp[n];
    }
}
