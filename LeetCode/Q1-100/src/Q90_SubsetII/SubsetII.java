package Q90_SubsetII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // build the map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int lengs = map.getOrDefault(num, 0);
            map.put(num, lengs+1);
        }

        // construct the ans
        ans.add(new ArrayList<Integer>());
        for(Integer key : map.keySet()){
            int sizeOfKey = map.get(key);

            int sizeOfTemp = ans.size();
            for(int i=0; i<sizeOfTemp; i++){
                List<Integer> temp = new ArrayList<>(ans.get(i));
                for(int reps=1; reps<=sizeOfKey; reps++){
                    temp.add(key);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }

        return ans;
    }
}
