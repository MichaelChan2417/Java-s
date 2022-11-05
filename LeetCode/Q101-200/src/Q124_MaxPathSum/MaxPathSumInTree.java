package Q124_MaxPathSum;

import TreeNode.TreeNode;

import java.util.HashMap;

public class MaxPathSumInTree {
    HashMap<TreeNode, Integer> valMap = new HashMap<>();

    public int maxPathSum(TreeNode root) {
        getLeaf(root);
        int tmpMax = root.val;
        for (int val : valMap.values()){
            if (val > tmpMax) {
                tmpMax = val;
            }
        }

        return tmpMax;
    }

    public int getLeaf(TreeNode root) {
        // return 0 when null
        if (root == null) return 0;
        // return when its a leaf node
        if (root.left == null && root.right == null) {
            valMap.put(root, root.val);
            return root.val;
        }

        int leftMax = getLeaf(root.left);
        int rightMax = getLeaf(root.right);

        int retVal = Math.max(0, Math.max(leftMax, rightMax)) + root.val;

        if (root.val + leftMax + rightMax > retVal) {
            valMap.put(root, root.val + leftMax + rightMax);
        }
        else {
            valMap.put(root, retVal);
        }

        return retVal;
    }
}
