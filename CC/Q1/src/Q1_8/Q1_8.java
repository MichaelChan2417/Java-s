package Q1_8;

public class Q1_8 {
    public static void zeroMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        boolean isFirstColZero = false;
        boolean isFirstRowZero = false;
        for(int i=0; i<n; i++){
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        for(int i=0; i<m; i++){
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        // inner judge: map to the 1st row and 1st col
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if (matrix[i][j] == 0) {
                   matrix[0][j] = 0;
                   matrix[i][0] = 0;
                }
            }
        }

        // based on first row; mapping down
        for(int i=1; i<n; i++){
            if (matrix[0][i] == 0) {
                // all down is zero
                for(int j=1; j<m; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        // based on first col; mapping right
        for(int i=1; i<m; i++){
            if (matrix[i][0] == 0) {
                // all right is zero
                for(int j=1; j<n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // init condition of zero_col && zero_row
        if (isFirstColZero) {
            for(int j=0; j<m; j++){
                matrix[j][0] = 0;
            }
        }
        if (isFirstRowZero) {
            for(int j=0; j<n; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
