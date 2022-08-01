package Q110_BalancedBT;

import TreeNode.TreeNode;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        int k = getHeight(root);
        if(k < 0){
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int l_height = getHeight(root.left);
        int r_height = getHeight(root.right);

        if(l_height < 0 || r_height < 0){
            return -1;
        }
        if(Math.abs(l_height - r_height) > 1){
            return -1;
        }
        return Math.max(l_height, r_height)+1;
    }
}
