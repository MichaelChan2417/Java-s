package Q46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<Integer> temp;
    List<List<Integer>> ans;
    boolean[] mask;

    public List<List<Integer>> permute(int[] nums) {
        temp = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        mask = new boolean[n];

        dppm(nums);

        return ans;
    }

    public void dppm(int[] nums){
        for(int i=0; i<nums.length; i++){
            if(!mask[i]){
                temp.add(nums[i]);
                mask[i] = true;

                if(temp.size() == nums.length){
                    ans.add(new ArrayList<Integer>(temp));
                }
            }
            else{
                continue;
            }
            dppm(nums);
            mask[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
