package Q662_MaxWidthOfBT;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxBTWidth {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> hrq = new LinkedList<>();

        Queue<TreeNode> tq = new LinkedList<>();
        Queue<TreeNode> htq = new LinkedList<>();

        tq.offer(root);
        rq.offer(0);

        int gmax = 0;
        List<Integer> widthHold = new ArrayList<>();

        while(true){
            while(!tq.isEmpty()){
                TreeNode node = tq.poll();
                int value = rq.poll();
                widthHold.add(value);

                if(node.left != null){
                    htq.offer(node.left);
                    hrq.offer(value*2);
                }
                if(node.right != null){
                    htq.offer(node.right);
                    hrq.offer(value*2+1);
                }
            }
            int dis = widthHold.get(widthHold.size()-1) - widthHold.get(0);
            if(dis+1 > gmax){
                gmax = dis+1;
            }
            widthHold.clear();

            if(htq.isEmpty()){
                break;
            }

            while(!htq.isEmpty()){
                tq.offer(htq.poll());
                rq.offer(hrq.poll());
            }
        }

        return gmax;
    }
}
