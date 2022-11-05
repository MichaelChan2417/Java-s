package Q396_RotateFunc;

public class RotateFunc {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int curSum = 0;
        int totalSum = 0;
        for (int i=0; i<n; i++) {
            curSum += i * nums[i];
            totalSum += nums[i];
        }

        int curMax = curSum;
        for (int i=0; i<n; i++) {
            int curLast = nums[n-i-1];
            curSum -= (n-1) * curLast;
            curSum += (totalSum - curLast);

            if (curSum > curMax) {
                curMax = curSum;
            }
        }

        return curMax;
    }
}
