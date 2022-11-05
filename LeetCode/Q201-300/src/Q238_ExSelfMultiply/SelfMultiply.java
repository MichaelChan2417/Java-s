package Q238_ExSelfMultiply;

public class SelfMultiply {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for (int i=1; i<n; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        int[] ansb = new int[n];
        ansb[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            ansb[i] = ansb[i+1] * nums[i+1];
        }

        for (int i=0; i<n; i++) {
            ans[i] = ans[i] * ansb[i];
        }

        return ans;
    }
}
