package Q226_InvertBinaryTree;

import TreeNode.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return root;
        TreeNode tp;

        // swap its left and right
        tp = root.left;
        root.left = root.right;
        root.right = tp;

        if(root.left != null){
            invertTree(root.left);
        }

        if(root.right != null){
            invertTree(root.right);
        }

        return root;
    }


}
