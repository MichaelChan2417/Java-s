package Q152_MaxProductSubarray;

public class MaxSubProduct {

    /*
    * There are Three conditions when find the dp[i] the largest product number
    *   1) by all positive and continuous, dpmax[i-1] * nums[i]
    *   2) if the previous product is negative or smaller, just the nums[i] itself
    *   3) if the nums[i] is negative, then it is possible for previous dpmin[i-1] * nums[i] to be the largest
    * */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] minF = new int[n];
        int[] maxF = new int[n];

        for(int i=0; i<n; i++){
            minF[i] = nums[i];
            maxF[i] = nums[i];
        }

        for (int i=1; i<n; i++){
            minF[i] = Math.min(minF[i-1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            maxF[i] = Math.max(maxF[i-1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for(int i=0; i<n; i++){
            if (maxF[i] > ans){
                ans = maxF[i];
            }
        }
        return ans;
    }

}
