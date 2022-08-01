package Q173_BSTIterator;

import TreeNode.TreeNode;

import java.util.Stack;

public class BST_Iterator {


}

class BSTIterator{
// the monotonic stack
    private Stack<TreeNode> stk = new Stack<TreeNode>();

    public BSTIterator(TreeNode root){
        while(root != null){
            stk.push(root);
            root = root.left;
        }
    }


    public int next(){
        TreeNode trv = stk.pop();
        int ans = trv.val;

        if(trv.right != null){
            trv = trv.right;
            while(trv != null){
                stk.push(trv);
                trv = trv.left;
            }
        }

        return ans;
    }


    public boolean hasNext(){

        return !stk.isEmpty();
    }

}
