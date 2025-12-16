class Solution {
    public int nearestExit(char[][] A, int[] e) {
        Queue<int[]> q = new LinkedList<>();
        int dir[] = new int[] { 1, 0, -1, 0, 1 };
        q.add(new int[] { e[0], e[1], 0 });
        A[e[0]][e[1]] = '+';
        int m = A.length, n = A[0].length;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = dir[i] + cur[0], y = dir[i + 1] + cur[1];
                if (x < m && y < n && x >= 0 && y >= 0 && A[x][y] == '.') {
                    if (x == m - 1 || y == n - 1 || x == 0 || y == 0)
                        return cur[2] + 1;
                    q.add(new int[] { x, y, cur[2] + 1 });
                    A[x][y] = '+';
                }
            }
        }
        return -1;
    }
}