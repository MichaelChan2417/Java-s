package Q310_MinHeightTree;

import java.util.*;

public class MinHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

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

        List<Integer> ans = heightMap.get(minHeight);

        return ans;
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