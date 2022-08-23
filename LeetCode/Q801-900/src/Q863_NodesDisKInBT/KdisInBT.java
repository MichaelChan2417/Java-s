package Q863_NodesDisKInBT;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KdisInBT {
    List<TreeNode> path;
    boolean foundPath;
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // get the path from root to target
        path = new ArrayList<>();
        dfs(root, target);

        // for(int i=0; i<path.size(); i++){
        //     System.out.print(path.get(i).val + " ");
        // }
        // System.out.println();

        ans = new ArrayList<>();

        int n = path.size();
        for(int i=0; i<n-1; i++){
            int deg = k-n+i+1;
            if(deg >= 0){
                search(i, deg);
            }
        }

        selfsearch(path.get(path.size()-1), k);

        return ans;
    }


    public void selfsearch(TreeNode root, int k){
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> holdq = new LinkedList<>();
        q.offer(root);
        if(k == 0){
            ans.add(root.val);
            return;
        }

        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left != null){
                holdq.offer(cur.left);
            }
            if(cur.right != null){
                holdq.offer(cur.right);
            }

            if(q.isEmpty()){
                k--;
                if(k == 0){
                    while(!holdq.isEmpty()){
                        ans.add(holdq.poll().val);
                    }
                    break;
                }
                q = new LinkedList<>(holdq);
                holdq.clear();
            }
        }
    }


    public void search(int rootId, int deg){
        TreeNode node = path.get(rootId);
        TreeNode avd = path.get(rootId+1);

        if(deg == 0){
            ans.add(node.val);
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> holdq = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            TreeNode cur = q.poll();

            if(cur.left != avd && cur.left != null){
                holdq.offer(cur.left);
            }
            if(cur.right != avd && cur.right != null){
                holdq.offer(cur.right);
            }

            if(q.isEmpty()){
                deg--;
                if(deg == 0){
                    while(!holdq.isEmpty()){
                        ans.add(holdq.poll().val);
                    }
                }
                q = new LinkedList<>(holdq);
                holdq.clear();
            }
        }
    }


    public void dfs(TreeNode root, TreeNode target){
        if(root == null) return;
        path.add(root);

        if(root == target){
            foundPath = true;
        }

        if(foundPath) return;

        dfs(root.left, target);
        if(!foundPath){
            dfs(root.right, target);
        }

        if(!foundPath){
            path.remove(path.size()-1);
        }
    }
}
