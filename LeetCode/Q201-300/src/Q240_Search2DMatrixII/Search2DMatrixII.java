package Q240_Search2DMatrixII;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 这里很trick 从右上角来看向左就是减少，向下就是增加
        int m = matrix.length, n = matrix[0].length;

        int s_x = 0, s_y = n-1;
        int cur;

        while(s_x < m && s_y >= 0){
            cur = matrix[s_x][s_y];
            if(cur == target){
                return true;
            }
            if(cur > target){
                s_y--;
                continue;
            }
            s_x++;
        }

        return false;
    }
}
