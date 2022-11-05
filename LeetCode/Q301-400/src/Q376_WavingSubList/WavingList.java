package Q376_WavingSubList;

import java.util.HashSet;

public class WavingList {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        int n = nums.length;
        int[] dp = new int[n];

        HashSet<Integer> numSet = new HashSet<>();

        for (int i=0; i<n; i++) {
            numSet.add(nums[i]);
            for (int j=0; j<i; j++) {
                // the previous is decrease
                if (dp[j] <= 0 && nums[i] > nums[j]) {
                    if (-dp[j] + 1 > Math.abs(dp[i])) {
                        dp[i] = 1 - dp[j];
                    }
                }
                // the previous is increasing
                if (dp[j] >= 0 && nums[i] < nums[j]) {
                    if (dp[j] + 1 > Math.abs(dp[i])) {
                        dp[i] = -dp[j] - 1;
                    }
                }
            }
        }

        int curMax = 1;
        for (int i=0; i<n; i++) {
            // System.out.println(dp[i]);
            if (Math.abs(dp[i]) > curMax) {
                curMax = Math.abs(dp[i]);
            }
        }

        if (numSet.size() == 1) {
            return 1;
        }

        return curMax+1;
    }
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
