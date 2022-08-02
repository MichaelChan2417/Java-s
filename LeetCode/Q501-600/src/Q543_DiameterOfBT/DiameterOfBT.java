package Q543_DiameterOfBT;


import TreeNode.TreeNode;

public class DiameterOfBT {
    int templ = 1;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        dfs(root);

        return templ;
    }

    public int dfs(TreeNode root){

        if(root == null) return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        int h = Math.max(l, r) + 1;

        if(l + r > templ){
            templ = l + r;
        }
        return h;
    }
}
