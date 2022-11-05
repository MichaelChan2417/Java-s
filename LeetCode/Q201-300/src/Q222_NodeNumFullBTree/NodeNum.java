package Q222_NodeNumFullBTree;

import TreeNode.TreeNode;

public class NodeNum {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        // count the level
        int h = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            h++;
            cur = cur.left;
        }

        int left = 1 << h;
        int right = (1 << (h+1)) - 1;

        while (left < right) {
            int mid = (right - left + 1)/2 + left;
            if (exist(root, mid, h)) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean exist(TreeNode root, int mid, int h) {
        TreeNode cur = root;
        int mask = 1 << (h-1);

        while (cur != null && mask > 0) {
            if ((mask & mid) == 0) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
            mask >>= 1;
        }
        return cur!=null;
    }
}
