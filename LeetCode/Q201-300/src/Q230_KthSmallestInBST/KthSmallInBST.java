package Q230_KthSmallestInBST;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallInBST {

    List<Integer> list = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        Insert(root, k);
        return list.get(k-1);
    }

    public void Insert(TreeNode root, int k){
        if(root == null || k<0){
            return;
        }
        Insert(root.left, k);

        list.add(root.val);
        k--;

        Insert(root.right, k);
    }
}
