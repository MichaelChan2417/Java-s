package Q307_RangeFindChange;

public class NumArray {
    int[] holder;
    int[] presum;
    int[] change;

    public NumArray(int[] nums) {
        int n = nums.length;
        holder = new int[n+1];
        presum = new int[n+1];
        change = new int[n];
        int curSum = 0;

        for (int i=1; i<=n; i++) {
            holder[i] = nums[i-1];
            curSum += nums[i-1];
            presum[i] = curSum;
        }
    }

    public void update(int index, int val) {
        int orgVal = holder[index+1];
        // holder[index+1] = val;
        change[index] = val - orgVal;
    }

    public int sumRange(int left, int right) {
        int tmpChange = 0;
        for (int i=left; i<=right; i++) {
            tmpChange += change[i];
        }
        int locSum = presum[right+1] - presum[left];
        return locSum + tmpChange;
    }
}
