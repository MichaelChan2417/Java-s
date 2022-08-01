package Q77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    // get all combinations from numbers [1,n] with k-element each

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> combs = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k){
        dfs(1, n, k);

        return combs;
    }

    public void dfs(int cur, int n, int k){
        // if the left numbers are not enough
        if(temp.size() + (n-cur+1) < k){
            return;
        }

        // if length-k, add in
        if(temp.size() == k){
            combs.add(new ArrayList<Integer>(temp));
            return;
        }

        // with cur
        temp.add(cur);
        dfs(cur+1, n, k);

        // without cur
        temp.remove(temp.size() - 1);
        dfs(cur+1, n, k);
    }
}
