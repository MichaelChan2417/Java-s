package Q74_2DSearch;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;

        int l = 0, r = m;
        while(l < r){
            int mid = (l + r)>>1;

            if(matrix[mid][0] == target){
                return true;
            }
            if(matrix[mid][0] > target){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        if(l == 0) return false;

        int row = l - 1;

        l = 0;
        r = n;
        while(l < r){
            int mid = (l+r)>>1;

            if(matrix[row][mid] == target){
                return true;
            }
            if(matrix[row][mid] > target){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return false;

    }
}
