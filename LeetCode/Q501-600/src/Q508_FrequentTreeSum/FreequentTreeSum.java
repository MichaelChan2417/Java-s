package Q508_FrequentTreeSum;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FreequentTreeSum {
    HashMap<Integer, Integer> sumToCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        sumToCount = new HashMap<>();

        dfs(root);

        int maxOccur = 0;
        List<Integer> ansHolder = new ArrayList<>();
        for(int sumkey : sumToCount.keySet()){
            int occurNum = sumToCount.get(sumkey);
            if(occurNum > maxOccur){
                maxOccur = occurNum;
                ansHolder.clear();
            }
            if(occurNum == maxOccur){
                ansHolder.add(sumkey);
            }
        }

        int n = ansHolder.size();
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = ansHolder.get(i);
        }
        return ans;
    }

    public int dfs(TreeNode root){

        if(root == null) return 0;

        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);

        int curVal = leftVal + rightVal + root.val;

        int occ = sumToCount.getOrDefault(curVal, 0);
        sumToCount.put(curVal, occ + 1);

        return curVal;
    }
}
