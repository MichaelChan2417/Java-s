package Q103_BTZigZagTrav;

import TreeNode.TreeNode;

import java.util.*;

public class BTZigZag {
    List<Integer> hold;
    List<List<Integer>> ans;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        hold = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        Deque<TreeNode> holdq = new LinkedList<>();
        q.offer(root);
        hold.add(root.val);
        ans.add(new ArrayList<>(hold));
        hold.clear();

        boolean flag = true;

        while(!q.isEmpty()){
            TreeNode cur = q.poll();

            if(cur.left != null){
                holdq.offer(cur.left);
            }
            if(cur.right != null){
                holdq.offer(cur.right);
            }

            if(q.isEmpty()){
                // insert
                q = new LinkedList<>(holdq);
                if(!flag){
                    while(!holdq.isEmpty()){
                        hold.add(holdq.poll().val);
                    }
                    ans.add(new ArrayList<>(hold));
                    hold.clear();
                }
                else{
                    while(!holdq.isEmpty()){
                        hold.add(holdq.pollLast().val);
                    }
                    ans.add(new ArrayList<>(hold));
                    hold.clear();
                }
                flag = !flag;
                holdq.clear();
            }
        }

        ans.remove(ans.size()-1);
        return ans;
    }
}
