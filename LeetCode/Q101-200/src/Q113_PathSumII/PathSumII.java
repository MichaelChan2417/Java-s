package Q113_PathSumII;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    List<Integer> temp;
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        temp = new ArrayList<Integer>();
        ans = new ArrayList<>();

        if (root == null) return ans;

        dfs(root, targetSum);

        return ans;
    }

    public void dfs(TreeNode root, int targetSum){

        temp.add(root.val);
        // judge if it is a leaf
        if (root.left == null && root.right == null){
            if (targetSum == root.val){
                ans.add(new ArrayList<>(temp));
            }
        }
        if (root.left != null){
            dfs(root.left, targetSum-root.val);
        }
        if (root.right != null){
            dfs(root.right, targetSum-root.val);
        }

        temp.remove(temp.size()-1);
    }
}
