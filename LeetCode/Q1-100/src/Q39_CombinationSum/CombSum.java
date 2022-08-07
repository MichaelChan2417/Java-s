package Q39_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSum {
    List<Integer> row;
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        row = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);

        dfs(candidates, target, 0);

        return ans;
    }

    public void dfs(int[] candidates, int target, int i){
        if(target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<Integer>(row));
            return;
        }

        int idx;
        for(idx = i; idx < candidates.length; idx++){
            int candidate = candidates[idx];

            row.add(candidate);
            dfs(candidates, target-candidate, idx);
            row.remove(row.size()-1);
        }
    }
}
