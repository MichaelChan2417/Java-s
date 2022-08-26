package Q221_MaxSquare;

/**
 * An direct solution for DP each height in each row to find the max;
 * space -> time
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        // heightDP stores the cur maximum height upper
        int[][] heightDP = new int[m][n];
        for (int j=0; j<n; j++) {
            // the first row
            heightDP[0][j] = matrix[0][j]=='1' ? 1 : 0;
        }
        for (int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == '0') continue;
                heightDP[i][j] = heightDP[i-1][j] + 1;
            }
        }

        int maxSide = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (heightDP[i][j] == 0) {
                    continue;
                }
                int curHeight = heightDP[i][j];
                for (int k=j; k>=0; k--) {
                    if (heightDP[i][k] == 0) break;
                    if (heightDP[i][k] < curHeight) {
                        curHeight = heightDP[i][k];
                    }

                    int curSide = Math.min(j-k+1, curHeight);
                    maxSide = Math.max(curSide, maxSide);
                }
            }
        }

        return maxSide * maxSide;
    }
}

/**
 * We can tell a square by 3 mins
 * 1. left square
 * 2. upper square
 * 3. left-upper square
 */
class solution{
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;

        int[][] dp = new int[row+1][col+1]; // we add left bound and upper bound
        int maxSide = 0;

        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                if (matrix[i-1][j-1] == '0') continue;
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                if (dp[i][j] > maxSide) {
                    maxSide = dp[i][j];
                }
            }
        }

        return maxSide * maxSide;
    }
}
