package Q329_LongestIncreaseInMatrix;

public class LongestIncrease {
    boolean[][] locked;
    int[][] pathWay;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        locked = new boolean[m][n];
        pathWay = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dfs(matrix, i, j);
                locked[i][j] = true;

            }
        }

        int curMax = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (pathWay[i][j] > curMax) {
                    curMax = pathWay[i][j];
                }
            }
        }
        return curMax+1;
    }

    private void dfs(int[][] matrix, int x, int y) {
        // this node has been visited and loced
        if (locked[x][y]) return;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] diff = new int[]{-1,0,1,0,-1};

        for (int i=0; i<4; i++) {
            int dx = diff[i];
            int dy = diff[i+1];

            int nx = x+dx;
            int ny = y+dy;

            if (nx>=0 && nx<m && ny>=0 && ny<n && matrix[nx][ny]>matrix[x][y]) {
                if (!locked[nx][ny]) {
                    dfs(matrix, nx, ny);
                }
                if (pathWay[nx][ny] + 1 > pathWay[x][y]) {
                    pathWay[x][y] = pathWay[nx][ny] + 1;
                }
            }
        }

        locked[x][y] = true;

    }
}
