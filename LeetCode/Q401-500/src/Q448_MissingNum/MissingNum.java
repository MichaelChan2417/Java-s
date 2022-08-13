package Q448_MissingNum;

import java.util.ArrayList;
import java.util.List;

public class MissingNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            int cur = nums[i];

            if(cur != i+1){
                while(nums[cur-1] != cur){
                    // swap nums[i] and nums[cur-1];
                    int temp = nums[i];
                    nums[i] = nums[cur-1];
                    nums[cur-1] = temp;
                    cur = nums[i];
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(nums[i] != i+1){
                ans.add(i+1);
            }
        }

        return ans;
    }
}
