package Q542_01Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * First Solution:
 * Multi-Source BFS
 */
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] directions = new int[]{-1,0,1,0,-1};
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    row.offer(i);
                    col.offer(j);
                    visited[i][j] = true;
                }
            }
        }

        int cur = 0;
        Queue<Integer> holdq = new LinkedList<>();

        while(!row.isEmpty() && !col.isEmpty()){
            int c_row = row.poll();
            int c_col = col.poll();
            mat[c_row][c_col] = cur;
            visited[c_row][c_col] = true;

            for(int i=0; i<4; i++){
                int nr = c_row + directions[i];
                int nc = c_col + directions[i+1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    holdq.offer(nr);
                    holdq.offer(nc);
                }
            }

            if(row.isEmpty()){
                cur++;
                while(!holdq.isEmpty()){
                    row.offer(holdq.poll());
                    col.offer(holdq.poll());
                }
            }

        }
        return mat;
    }
}

/**
 * Similar with double-scan;
 * from the top-left to bottom-right and
 * back from bottom-right to top-left
 */
class solutionI{
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int[][] steps = new int[m][n];

            // firstly, fill with a large value;
            for(int i=0; i<m; i++){
                Arrays.fill(steps[i], m+n+1);
            }

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(mat[i][j] == 0){
                        steps[i][j] = 0;
                    }
                }
            }

            // Start Scan from top-left
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    // row comp first
                    if(i-1 >= 0){
                        steps[i][j] = Math.min(steps[i][j], steps[i-1][j] + 1);
                    }
                    // col comp
                    if(j-1 >= 0){
                        steps[i][j] = Math.min(steps[i][j], steps[i][j-1] + 1);
                    }
                }
            }

            // Start Scan from bottom-right
            for(int i=m-1; i>=0; i--){
                for(int j=n-1; j>=0; j--){
                    // row comp first
                    if(i+1 < m){
                        steps[i][j] = Math.min(steps[i][j], steps[i+1][j] + 1);
                    }
                    // col comp
                    if(j+1 < n){
                        steps[i][j] = Math.min(steps[i][j], steps[i][j+1] + 1);
                    }
                }
            }

            return steps;
        }
}