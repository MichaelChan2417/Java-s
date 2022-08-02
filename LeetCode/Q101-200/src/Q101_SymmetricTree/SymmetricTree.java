package Q101_SymmetricTree;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;

        Queue<TreeNode> lt = new LinkedList<>();
        Queue<TreeNode> rt = new LinkedList<>();

        lt.offer(root.left);
        rt.offer(root.right);

        while (!lt.isEmpty()){
            TreeNode templ = lt.poll();
            TreeNode tempr = rt.poll();

            if(templ == null && tempr == null){
                continue;
            }
            if(templ == null || tempr == null){
                return false;
            }
            if (templ.val != tempr.val){
                return false;
            }

            lt.offer(templ.left);
            lt.offer(templ.right);
            rt.offer(tempr.right);
            rt.offer(tempr.left);
        }
        return true;
    }

}
