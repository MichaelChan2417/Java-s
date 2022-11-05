package Q384_RandomList;

import java.util.Random;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
public class RandomizeList {
    int[] orgNums;
    Random random = new Random();

    public RandomizeList(int[] nums) {
        int n = nums.length;
        orgNums = new int[n];
        for (int i=0; i<n; i++) {
            orgNums[i] = nums[i];
        }
    }

    public int[] reset() {
        return orgNums;
    }

    public int[] shuffle() {
        int n = orgNums.length;
        int[] curNum = new int[n];
        for (int i=0; i<n; i++) {
            curNum[i] = orgNums[i];
        }

        for (int i=0; i<n; i++) {
            int pickIndex = random.nextInt(n-i)+i;
            int temp = curNum[pickIndex];
            curNum[pickIndex] = curNum[i];
            curNum[i] = temp;
        }

        return curNum;
    }
}
