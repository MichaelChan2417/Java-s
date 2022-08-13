package Q261_Graph2Tree;

import java.util.*;

public class isGraphTree {
    HashSet<Integer> set;
    HashMap<Integer, List<Integer>> grid;

    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0){
            return n == 1;
        }
        set = new HashSet<>();
        grid = new HashMap<>();

        for(int[] pair : edges){
            int n0 = pair[0];
            int n1 = pair[1];

            List<Integer> temp = grid.getOrDefault(n0, new ArrayList<>());
            temp.add(n1);
            grid.put(n0, temp);

            temp = grid.getOrDefault(n1, new ArrayList<>());
            temp.add(n0);
            grid.put(n1, temp);
        }

        int inserted = grid.keySet().size();
        if(inserted < n){
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> holdq = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            int index = q.poll();

            if(set.contains(index)){
                return false;
            }
            set.add(index);

            // offer the new queue
            List<Integer> its_neighbor = grid.get(index);
            for(int i=0; i<its_neighbor.size(); i++){
                int ni = its_neighbor.get(i);
                holdq.offer(ni);
                List<Integer> neighbor_list = grid.get(ni);
                neighbor_list.remove((Integer) index);
            }

            while(!holdq.isEmpty()){
                q.offer(holdq.poll());
            }
        }

        return set.size() == n;
    }
}

class solution{
    public  boolean validTree(int n, int[][] edges) {
        if(edges.length != (n-1)) return false;
        int[] p = new int[n];
        for(int i=0; i<n; i++){
            p[i] = i;
        }

        for(int[] pair : edges){
            int n0 = pair[0];
            int n1 = pair[1];

            if(find(n0, p) == find(n1, p)){
                return false;
            }
            union(n0, n1, p);
        }

        int root = 0;
        for(int i=0; i<n; i++){
            // if only one root!!!
            if(p[i] == i){
                root++;
            }
        }

        return root == 1;
    }

    public int find(int node, int[] p){
        if(node != p[node]){
            p[node] = find(p[node], p);
        }
        return p[node];
    }

    public void union(int n0, int n1, int[] p){
        int parent0 = find(n0, p);
        int parent1 = find(n1, p);

        if(parent0 != parent1){
            p[parent0] = parent1;
        }

    }
}
