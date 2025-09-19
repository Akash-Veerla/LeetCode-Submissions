class Solution {
    public int totalNQueens(int n) {
        boolean[][] arr = new boolean[n][n];
        return helper(arr, 0);
    }

    private int helper(boolean[][] arr, int r) {
        if (r == arr.length) {
            return 1;
        }
        int count = 0;
        for (int c = 0; c < arr[0].length; c++) {
            if (isSafe(arr, r, c)) {
                arr[r][c] = true;
                count += helper(arr, r + 1);
                arr[r][c] = false;
            }
        }
        return count;
    }

    private boolean isSafe(boolean[][] arr, int r, int c) {
        for (int i = r; i >= 0; i--) {
            if (arr[i][c])
                return false;
        }
        int min = Math.min(r, c);
        for (int i = min; i >= 0; i--) {
            if (arr[r - i][c - i])
                return false;
        }
        int minR = Math.min(r, arr.length - c - 1);
        for (int i = minR; i >= 0; i--) {
            if (arr[r - i][c + i])
                return false;
        }
        return true;
    }
}