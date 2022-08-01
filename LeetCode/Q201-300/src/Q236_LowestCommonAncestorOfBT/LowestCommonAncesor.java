package Q236_LowestCommonAncestorOfBT;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncesor {

    static List<TreeNode> branch = new ArrayList<TreeNode>();
    static List<List<TreeNode>> anes = new ArrayList<>();

    public static void dfs(TreeNode n, TreeNode p, TreeNode q){
        if(n == null) return;

        if(n == p || n == q){
            List<TreeNode> z = new ArrayList<TreeNode>(branch);
            anes.add(z);
            if(anes.size() == 2){
                return;
            }
        }
        // go on to left/right child
        if(n.left != null){
            branch.add(n.left);
            dfs(n.left, p, q);
            branch.remove(n.left);
        }
        if(n.right != null){
            branch.add(n.right);
            dfs(n.right, p, q);
            branch.remove(n.right);
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // if one of them is the root, just return
        if(p == root || q == root) return root;

        branch.add(root);
        dfs(root, p, q);

        List<TreeNode> road1 = anes.get(0);
        List<TreeNode> road2 = anes.get(1);

        int i = 0;
        for(i=0; i< Math.min(road1.size(), road2.size()); i++){
            if(road1.get(i) != road2.get(i)){
                break;
            }
        }
        TreeNode ans = road1.get(i-1);
        return ans;

    }

    public static void main(String[] args) {

    }
}


class Solution{

    TreeNode ans;

    public boolean dfs(TreeNode n, TreeNode p, TreeNode q){
        if(n == null) return false;

        boolean l = dfs(n.left, p, q);
        boolean r = dfs(n.right, p, q);

        if((l&&r) || ((l||r) && (n==p || n==q))){
            ans = n;
        }

        return l || r || n==p || n==q;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == q || root == p) return root;

        boolean kk = dfs(root, p, q);
        return ans;

    }

}
