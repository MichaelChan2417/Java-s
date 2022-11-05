package Q198_Robbing;

public class Robbing {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i=2; i<n; i++) {
            int tempMax = dp[0];
            for (int j=1; j<i-1; j++) {
                if (dp[j] > tempMax) {
                    tempMax = dp[j];
                }
            }
            dp[i] = tempMax + nums[i];
        }

        int tMax = dp[0];
        for (int i=0; i<dp.length; i++) {
            if (dp[i] > tMax) {
                tMax = dp[i];
            }
        }

        return tMax;
    }
}
