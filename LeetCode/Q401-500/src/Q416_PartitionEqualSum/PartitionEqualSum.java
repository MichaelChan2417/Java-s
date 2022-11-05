package Q416_PartitionEqualSum;

import java.util.Arrays;

public class PartitionEqualSum {
    /**
     * Can the input list be equally partitioned into 2 equal sum
     * @param nums
     * @return TLE!!!
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        // if it's odd, then must cannot
        if(sum % 2 != 0){
            return false;
        }

        Arrays.sort(nums);

        return dfs(nums, 0, sum/2);
    }

    private boolean dfs(int[] nums, int curIndex, int target) {
        if (target < 0) return false;
        int n = nums.length;
        boolean flag = false;

        for (int i=curIndex+1; i<n; i++) {
            target -= nums[i];
            flag = dfs(nums, i, target);
            if (flag) return flag;
            target += nums[i];
        }

        return false;
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;

        int ttSum = 0;
        for (int i=0; i<n; i++) {
            ttSum += nums[i];
        }
        if (ttSum % 2 != 0) {
            return false;
        }

        int target = ttSum / 2;
        Arrays.sort(nums);

        boolean[][] dp = new boolean[n][target+1];
        dp[0][0] = true;
        dp[0][nums[0]] = true;

        for (int i=1; i<n; i++) {
            // using nums range [0, i];
            // using additive num -- nums[i]
            int additive = nums[i];
            for (int j=0; j<target; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                    if ((j + additive) == target) {
                        return true;
                    }
                    if ((j+additive) < target){
                        dp[i][j+additive] = true;
                    }
                }
            }
        }

        return false;
    }
}