package Q130_BoundedArea;

public class BoundedArea {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;

        // top
        for(int i=0; i<n; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i, m, n);
            }
        }
        // bottom
        for(int i=0; i<n; i++){
            if(board[m-1][i] == 'O'){
                dfs(board, m-1, i, m, n);
            }
        }
        // left
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, m, n);
            }
        }
        // right
        for(int i=0; i<m; i++){
            if(board[i][n-1] == 'O'){
                dfs(board, i, n-1, m, n);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'C'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col, int m, int n){
        // Set the new val
        board[row][col] = 'C';
        int[] directions = new int[]{-1,0,1,0,-1};

        for(int i=0; i<4; i++){
            int nr = row + directions[i];
            int nc = col + directions[i+1];

            if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O'){
                dfs(board, nr, nc, m, n);
            }
        }
    }
}
