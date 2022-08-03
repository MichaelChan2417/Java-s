package Q437_PathSumIII;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    int temp = 0;
    public int pathSum(TreeNode root, int targetSum) {

        return dfs(root, targetSum);
    }

    public int dfs(TreeNode root, int target){
        int num;

        dfs_helper(root, target);
        num = temp;
        temp = 0;

        if (root.left != null){
            num += dfs(root.left, target);
        }

        if (root.right != null){
            num += dfs(root.right, target);
        }

        return num;
    }

    public void dfs_helper(TreeNode root, int target){
        if (root == null) return;

        if (root.val == target){
            temp++;
        }

        dfs_helper(root.left, target - root.val);
        dfs_helper(root.right, target - root.val);
    }
}

class PathSumPrefix{

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}


