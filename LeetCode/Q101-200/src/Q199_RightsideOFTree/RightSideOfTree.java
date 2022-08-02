package Q199_RightsideOFTree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideOfTree {

    List<Integer> ansList;
    Queue<TreeNode> rootQ;
    Queue<TreeNode> holdQ;

    public List<Integer> rightSideView(TreeNode root) {
        ansList = new ArrayList<Integer>();
        rootQ = new LinkedList<TreeNode>();
        holdQ = new LinkedList<TreeNode>();

        rootQ.offer(root);
        levelRun(rootQ);

        return ansList;
    }

    public void levelRun(Queue<TreeNode> rootQ){
        TreeNode tempnode;
        int last = 0;
        int cnt = 0;
        while(!rootQ.isEmpty()){
            tempnode = rootQ.poll();
            if(tempnode == null) continue;
            
            last = tempnode.val;
            cnt++;
            holdQ.offer(tempnode.left);
            holdQ.offer(tempnode.right);
        }

        if(cnt != 0){
            ansList.add(last);
        }

        while(!holdQ.isEmpty()){
            rootQ.offer(holdQ.poll());
        }

        levelRun(rootQ);
    }
}
