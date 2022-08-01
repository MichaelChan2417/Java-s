package Q417_PacificAtlanticWaterflow;

import java.util.ArrayList;
import java.util.List;

public class PAWaterFlow {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int m, n;
    int[][] height;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.height = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] amaze = new boolean[m][n];
        boolean[][] pmaze = new boolean[m][n];


        // upper
        for(int i=0; i<n; i++){
            dfs(0, i, pmaze);
        }

        // left
        for(int i=0; i<m; i++){
            dfs(i, 0, pmaze);
        }

        // right
        for(int i=0; i<m; i++){
            dfs(i, n-1, pmaze);
        }

        // bottom
        for(int i=0; i<n; i++){
            dfs(m-1, i, pmaze);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pmaze[i][j] && amaze[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    void dfs(int i, int j, boolean[][] maze){
        if(maze[i][j]){
            return;
        }

        maze[i][j] = true;

        // upper i -> i-1
        if(i >= 1 && height[i-1][j] > height[i][j]){
            dfs(i-1, j, maze);
        }

        // bottom i -> i+1
        if(i+1 < m && height[i+1][j] > height[i][j]){
            dfs(i+1, j, maze);
        }

        // left j -> j-1
        if(j >= 1 && height[i][j-1] > height[i][j]){
            dfs(i, j-1, maze);
        }

        // right j -> j+1
        if(j+1 < n && height[i][j+1] > height[i][j]){
            dfs(i, j+1, maze);
        }

        return;
    }
}
