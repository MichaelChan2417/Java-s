package Q16_3SumClosest;

import java.util.Arrays;

public class ThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;

        for(int i=0; i<n-2; i++){
            int j = i+1;
            int k = n-1;
            while(j < k){
                int temp = nums[i] + nums[j] + nums[k];

                if(Math.abs(target - temp) < diff){
                    diff = Math.abs(target - temp);
                    ans = temp;
                }
                if(temp == target){
                    return temp;
                }
                if(temp < target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return ans;
    }
}
