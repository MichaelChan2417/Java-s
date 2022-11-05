package Q114_ExtendTree;

import TreeNode.TreeNode;

public class BST2LinkedList {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        TreeNode nxt, sh, st;

        while (cur != null) {
            nxt = cur.right;
            // left son
            if (cur.left != null) {
                sh = cur.left;
                cur.right = sh;
                cur.left = null;
                while (sh.right != null) {
                    sh = sh.right;
                }
                sh.right = nxt;
            }
            cur = cur.right;
        }

    }
}
