package Q200_NumbersOfIsland;

import java.util.LinkedList;
import java.util.Queue;

public class NumIsland {
    // 4-directions island
    boolean[][] visited;
    int n = 0;

    public int numIslands(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    n++;
                    dfs(grid, i, j);
                }
            }
        }
        return n;
    }

    public void dfs(char[][]grid, int x, int y){
        int[] directions = new int[]{-1, 0, 1, 0, -1};
        visited[x][y] = true;

        for(int idx=0; idx<4; idx++){
            int ix = directions[idx] + x;
            int iy = directions[idx+1] + y;

            if(ix >= 0 && ix < grid.length && iy >= 0 && iy < grid[0].length && !visited[ix][iy] && grid[ix][iy] == '1'){
                dfs(grid, ix, iy);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{1,2,2,3,4},{1,2,3,4,5},{1,2,3,4,5}};
        System.out.println(grid.length);
    }
}

class NumIslandBFS{

    public int numIslands(char[][] grid){
        int num = 0;
        int m = grid.length, n = grid[0].length;
        Queue<Integer> is = new LinkedList<>();
        Queue<Integer> js = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    num++;
                    is.offer(i);
                    js.offer(j);
                    grid[i][j] = '0';

                    while(!is.isEmpty()){
                        int ci = is.poll();
                        int cj = js.poll();

                        // up
                        if (ci-1 >= 0 && grid[ci-1][cj] == '1'){
                            is.offer(ci-1);
                            js.offer(cj);
                            grid[ci-1][cj] = '0';
                        }
                        // down
                        if (ci+1 < m && grid[ci+1][cj] == '1'){
                            is.offer(ci+1);
                            js.offer(cj);
                            grid[ci+1][cj] = '0';
                        }
                        // left
                        if (cj-1 >= 0 && grid[ci][cj-1] == '1'){
                            is.offer(ci);
                            js.offer(cj-1);
                            grid[ci][cj-1] = '0';
                        }
                        if (cj+1 < n && grid[ci][cj+1] == '1'){
                            is.offer(ci);
                            js.offer(cj+1);
                            grid[ci][cj+1] = '0';
                        }
                    }
                }
            }
        }
        return num;
    }
}