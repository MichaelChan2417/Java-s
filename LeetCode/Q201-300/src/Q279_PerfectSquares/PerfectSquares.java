package Q279_PerfectSquares;

public class PerfectSquares {
    public int numSquares(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        for(int i=1; i<=Math.sqrt(n); i++){
            dp[i] = 1;
        }

        for(int i=2; i<=n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=1; j<=Math.sqrt(i); j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }

        // for(int i=0; i<=n; i++){
        //     System.out.println(i + " : " + dp[i]);
        // }

        return dp[n];
    }
}
