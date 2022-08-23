package Q787_KStopsFlight;

import java.util.Arrays;

/**
 * Time Overflow
 */
public class KStopsFlight {
    int[][] prices;
    int minPrice;
    boolean[] visited;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        prices = new int[n][n];
        minPrice = Integer.MAX_VALUE;
        visited = new boolean[n];

        // set up the prices
        for(int[] flight : flights){
            int start = flight[0];
            int end = flight[1];
            prices[start][end] = flight[2];
        }

        dfs(n, src, dst, k, 0);

        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    public void dfs(int n, int src, int dst, int k, int curPrice){
        // it comes to an end
        if(src == dst){
            if(curPrice < minPrice){
                minPrice = curPrice;
            }
            return;
        }
        // if no more trans
        if(k < 0) return;

        visited[src] = true;

        for(int next = 0; next < n; next++){
            if(!visited[next] && prices[src][next] > 0){
                dfs(n, next, dst, k-1, curPrice + prices[src][next]);
            }
        }

        visited[src] = false;
    }
}

class solution{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] f = new int[k+2][n];
        for(int i=0; i<k+2; i++){
            Arrays.fill(f[i], INF);
        }
        // the start point is 0 cost
        f[0][src] = 0;

        // the outer round is k-stops
        for(int t=1; t<=k+1; t++){
            for(int[] pair : flights){
                int i = pair[0], j = pair[1];
                int cost = pair[2];
                f[t][j] = Math.min(f[t][j], f[t-1][i] + cost);
            }
        }

        // for each round, find the smallest
        int ans = INF;
        for(int t=1; t<=k+1; t++){
            ans = Math.min(f[t][dst], ans);
        }
        return ans == INF ? -1 : ans;
    }
}
