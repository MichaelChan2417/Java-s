package Q108_SortedArray2BST;

import TreeNode.TreeNode;


public class BuildBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;

        return construct(nums, 0 ,n);
    }

    public TreeNode construct(int[] nums, int start, int end){
        if(start == end) return null;

        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = construct(nums, start, mid);
        root.right = construct(nums, mid+1, end);

        return root;
    }
}
