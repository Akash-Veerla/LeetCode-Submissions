class Solution {
    void dfs(char[][] board, int m, int n, int i, int j, boolean[][] visited) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return;
        }

        if (board[i][j] == 'X') {
            return;
        }

        if (board[i][j] == 'O') {
            board[i][j] = ' ';
        }

        if (visited[i][j])
            return;

        visited[i][j] = true;

        dfs(board, m, n, i + 1, j, visited);
        dfs(board, m, n, i, j + 1, visited);
        dfs(board, m, n, i - 1, j, visited);
        dfs(board, m, n, i, j - 1, visited);

    }

    public void solve(char[][] board) {

        if (board.length == 0)
            return;
        if (board[0].length == 0)
            return;
        if (board.length == 1 || board[0].length == 1)
            return;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i = i + m - 1) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = ' ';
                    dfs(board, m, n, i, j, visited);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j = j + n - 1) {
                if (board[i][j] == 'O') {
                    board[i][j] = ' ';
                    dfs(board, m, n, i, j, visited);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}