package Q105_BuildTreeWithPre_In;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePre_In {

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // the first element of preorder should be the root
        int preorder_root = preorder_left;
        // find its index in the inorder
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // construct the root
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // get the number of left-sub-tree
        int size_left_subtree = inorder_root - inorder_left;

        // left sub-tree
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);

        // right sub-tree
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // HashMap to locate the root
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{3,2,1};

    }
}
