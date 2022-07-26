package Q59_SpiralMatrixII;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n){
        int[][] m = new int[n][n];
        int i = 0, j = 0, cnt = 1; // start point
        int direction = 0;  // 0-right; 1-down; 2-left; 3-up

        while(true){
            switch (direction){
                case 0:
                    while(j<n && m[i][j]==0){
                        m[i][j] = cnt++;
                        j++;
                    }
                    j--;
                    i++;
                    direction = 1;
                    break;

                case 1:
                    while(i<n && m[i][j]==0){
                        m[i][j] = cnt++;
                        i++;
                    }
                    i--;
                    j--;
                    direction = 2;
                    break;

                case 2:
                    while(j>=0 && m[i][j]==0){
                        m[i][j] = cnt++;
                        j--;
                    }
                    j++;
                    i--;
                    direction = 3;
                    break;

                case 3:
                    while(i>=0 && m[i][j]==0){
                        m[i][j] = cnt++;
                        i--;
                    }
                    i++;
                    j++;
                    direction = 0;
                    break;

                default:
                    break;
            }

            if(cnt == n*n+1){
                break;
            }
        }
        return m;

    }


    public static void main(String[] args) {

    }

}
