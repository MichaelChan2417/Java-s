package Q994_RottingOrange;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {

    public static int orangesRotting(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] directions = new int[]{-1, 0, 1, 0, -1};
        Queue<Integer> index = new LinkedList<Integer>();
        Queue<Integer> backq = new LinkedList<Integer>();
        int num_fresh = 0;
        int time_count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    num_fresh++;
                    continue;
                }
                if (grid[i][j] == 2){
                    index.offer(i*n + j);
                }
            }
        }

        while (!index.isEmpty()){
            int id = index.poll();
            int ix = id / n;
            int iy = id % n;

            for(int i=0; i<4; i++){
                int nx = ix + directions[i];
                int ny = iy + directions[i+1];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1){
                    backq.offer(nx*n + ny);
                    grid[nx][ny] = 2;
                    num_fresh--;
                }
            }

            if (index.isEmpty()){
                while (!backq.isEmpty()){
                    index.offer(backq.poll());
                }
                time_count++;
            }
        }

        return num_fresh==0 ? time_count-1 : -1;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(orangesRotting(grid));
    }
}
