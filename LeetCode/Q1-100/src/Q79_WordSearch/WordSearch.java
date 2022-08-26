package Q79_WordSearch;

public class WordSearch {
    static boolean[][] visited;
    static int[] directions = new int[]{-1, 0, 1, 0, -1};

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        char startChar = word.charAt(0);

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (board[i][j] == startChar){
                    boolean retFlag = dfs(i, j, board, word, 1);
                    if (retFlag){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean dfs(int x, int y, char[][] board, String word, int curLen){
        if (curLen == word.length()) return true;

        int m = board.length, n = board[0].length;
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + directions[i];
            int ny = y + directions[i+1];

            if (nx>=0 && ny>=0 && nx<m && ny<n && board[nx][ny]==word.charAt(curLen) && !visited[nx][ny]) {
                boolean flag = dfs(nx, ny, board, word, curLen+1);
                if (flag) return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','V','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        exist(board, "SEE");
    }
}
