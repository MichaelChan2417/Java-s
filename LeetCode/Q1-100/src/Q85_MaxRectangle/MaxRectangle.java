package Q85_MaxRectangle;

public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;

        // construct dp for max pos height from each start
        int[][] dp = new int[row][col];
        for (int j=0; j<col; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
            }
        }
        for (int i=1; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == '0') continue;
                dp[i][j] = dp[i-1][j] + 1;
            }
        }

        // find max area
        int maxArea = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int curHeight = dp[i][j];

                for (int k=j; k>=0; k--) {
                    if (dp[i][k] < curHeight) {
                        curHeight = dp[i][k];
                    }
                    if (curHeight * (j - k + 1) > maxArea) {
                        maxArea = curHeight * (j - k + 1);
                    }
                }
            }
        }

        return maxArea;
    }
}
