package Q78_Subset;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 */
public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for(int num : nums){
            int arr_cur_size = ans.size();

            for(int i=0; i<arr_cur_size; i++){
                List<Integer> new_list = new ArrayList<>(ans.get(i));
                new_list.add(num);
                ans.add(new_list);
            }
        }
        return ans;
    }
}
