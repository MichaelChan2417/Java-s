package Q325_LongestSumKSubArr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSumKArr {
    public int maxSubArrayLen(int[] nums, int target) {
        HashMap<Integer, List<Integer>> indexMap = new HashMap<>();
        // construct prefix table, which is the pointer to the prefix sum
        int temp = 0;
        int n = nums.length;
        int[] prefix_sum = new int[n];

        for(int i=0; i<n; i++){
            temp += nums[i];
            prefix_sum[i] = temp;
        }

        // make map
        for(int i=0; i<n; i++){
            List<Integer> lit = indexMap.getOrDefault(prefix_sum[i], new ArrayList<>());
            lit.add(i);
            indexMap.put(prefix_sum[i], lit);
        }

        // get compare
        int mal = 0;
        for(int i=0; i<n; i++){
            int sum_hold = prefix_sum[i];
            if(sum_hold == target){
                mal = i+1;
            }
            List<Integer> itgs = indexMap.getOrDefault(sum_hold-target, null);
            if(itgs != null){
                for(int itg : itgs){
                    if(i - itg > mal){
                        mal = i - itg;
                    }
                }
            }
        }

        return mal;
    }
}

/**
 * Since the following sum would not affect the previous prefix sum;
 * We can do search as well as the insert.
 */
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        int res = 0;
        int sum = 0;
        map.put(0,-1);
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                res = Math.max(res,i - map.get(sum-k));
            }
            map.putIfAbsent(sum,i);
        }

        return res;

    }
}
