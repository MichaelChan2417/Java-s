package Q1706_BallsFall;

public class BallsFalling {
    public static int getBall(int[][] grid, int start){
        // the init dimension should always be 0 which is pointing down
        // 0-down; 1-right; 2-up; 3-left;
        int m = grid.length, n = grid[0].length;
        int dim = 0;
        int x = 0, y = start;

        while(true){
            switch (dim){
                case 0:
                    if(grid[x][y] == 1){
                        dim = 1;
                        y++;
                        if(y == n){
                            return -1;
                        }
                    }
                    else{
                        dim = 3;
                        y--;
                        if(y == -1){
                            return -1;
                        }
                    }
                    break;

                case 1:
                    if(grid[x][y] == 1){
                        dim = 0;
                        x++;
                        if(x == m){
                            return y;
                        }
                    }
                    else{
                        return -1;
                    }
                    break;

                case 3:
                    if(grid[x][y] == 1){
                        return -1;
                    }
                    else{
                        dim = 0;
                        x++;
                        if(x == m){
                            return y;
                        }
                    }
            }
        }
    }

    public static int[] findBall(int[][] grid){
        int m = grid.length, n = grid[0].length;
        // return list
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int tar = getBall(grid, i);
            ans[i] = tar;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}

