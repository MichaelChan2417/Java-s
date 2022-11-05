package Q330_FitList;

public class FitList {
    public int minPatches(int[] nums, int n) {
        int ans = 0;
        long x = 1;
        int l = nums.length;
        int index = 0;

        while (x <= n) {
            if (index < l && nums[index] <= x) {
                x += nums[index];
                index++;
            }
            else {
                x *= 2;
                ans++;
            }
        }
        return ans;
    }
}
