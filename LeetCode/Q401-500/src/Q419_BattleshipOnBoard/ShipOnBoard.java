package Q419_BattleshipOnBoard;

public class ShipOnBoard {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int ans = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int[] diff = new int[]{-1, 0, 1, 0, -1};

        board[x][y] = '.';

        for (int i=0; i<4; i++) {
            int dx = diff[i];
            int dy = diff[i+1];

            int nx = x + dx;
            int ny = y + dy;

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'X') {
                dfs(board, nx, ny);
            }
        }
    }
}
