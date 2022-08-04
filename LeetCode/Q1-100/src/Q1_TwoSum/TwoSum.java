package Q1_TwoSum;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;

        for(int num : nums){
            int kv = map.getOrDefault(target-num, -1);
            if(kv == -1){
                map.put(num, index++);
                continue;
            }
            ans[0] = kv;
            ans[1] = index;
        }
        return ans;
    }
}
