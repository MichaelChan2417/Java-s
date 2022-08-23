package Q310_MinHeightTree;

import java.util.*;

/**
 * In order to stay in space; we should modify the connected[][] map
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int x = findLongestNode(0, parent, adj);
        int y = findLongestNode(x, parent, adj);
        List<Integer> path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visit = new boolean[n];
        queue.offer(u);
        visit[u] = true;
        int node = -1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            node = curr;
            for (int v : adj[curr]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = curr;
                    queue.offer(v);
                }
            }
        }
        return node;
    }
}


/**
 * OOM
 */
public class MinHeightTree {
    boolean[][] connected;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        connected = new boolean[n][n];
        for(int[] pair : edges){
            connected[pair[0]][pair[1]] = true;
            connected[pair[1]][pair[0]] = true;
        }

        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        // starting from 0, find the longest chain using bfs
        int x = bfs(0, parents, n);
        int y = bfs(x, parents, n);
        System.out.println(x + " " + y);
        // now from x to y is the longest path
        List<Integer> path = new ArrayList<>();
        while(y != x){
            path.add(y);
            y = parents[y];
        }
        path.add(x);
        System.out.println(path);

        List<Integer> ans = new ArrayList<>();
        int sis = path.size();
        ans.add(path.get(sis/2));
        if(sis % 2 == 0){
            ans.add(path.get(sis/2-1));
        }

        return ans;
    }

    public int bfs(int s, int[] parents, int n){
        // this means start from n, find the longest path
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int cur = s;
        boolean[] visited = new boolean[n];

        while(!q.isEmpty()){
            cur = q.poll();
            visited[cur] = true;

            for(int i=0; i<n; i++){
                if(connected[cur][i] && !visited[i]){
                    q.offer(i);
                    parents[i] = cur;
                }
            }
        }
        return cur;
    }

}

/**
 * Time overflow
 */
class mysolution{
    boolean[][] connected;
    int minHeight;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        connected = new boolean[n][n];
        int[] nodeCount = new int[n];

        for(int[] pair : edges){
            connected[pair[0]][pair[1]] = true;
            connected[pair[1]][pair[0]] = true;

            nodeCount[pair[0]]++;
            nodeCount[pair[1]]++;
        }

        HashMap<Integer, List<Integer>> weightToId = new HashMap<>();
        for(int i=0; i<n; i++){
            List<Integer> ct = weightToId.getOrDefault(nodeCount[i], new ArrayList<>());
            ct.add(i);
            weightToId.put(nodeCount[i], ct);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        for(Integer key : weightToId.keySet()){
            pq.offer(key);
        }
        List<Integer> order = new ArrayList<>();
        while(!pq.isEmpty()){
            List<Integer> it = weightToId.get(pq.poll());
            order.addAll(it);
        }

        HashMap<Integer, List<Integer>> heightMap = new HashMap<>();

        minHeight = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int id = order.get(i);
            int height = getHeight(id);

            List<Integer> lit = heightMap.getOrDefault(height, new ArrayList<>());
            lit.add(id);
            heightMap.put(height, lit);

            if(height < minHeight){
                minHeight = height;
            }
        }

        return heightMap.get(minHeight);
    }

    public int getHeight(int k){
        int n = connected.length;
        boolean[] visited = new boolean[n];
        visited[k] = true;
        int curHeight = 0;

        Queue<Integer> cq = new LinkedList<>();
        Queue<Integer> hold = new LinkedList<>();
        cq.offer(k);

        while(!cq.isEmpty()){
            int cur = cq.poll();

            for(int i=0;i<n;i++){
                if(connected[cur][i] && !visited[i]){
                    hold.offer(i);
                    visited[i] = true;
                }
            }

            if(cq.isEmpty()){
                while(!hold.isEmpty()){
                    cq.offer(hold.poll());
                }
                curHeight++;
                if(curHeight > minHeight){
                    return Integer.MAX_VALUE>>1;
                }
            }
        }
        return curHeight;
    }
}