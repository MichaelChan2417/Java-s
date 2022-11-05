package Q453_MinOperate;

public class MinOperate {
    public int minMoves(int[] nums) {
        int minGet = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < minGet) {
                minGet = nums[i];
            }
        }

        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            ans += nums[i] - minGet;
        }
        return ans;
    }
}
