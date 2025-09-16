class Solution {

    int m, n;
    Map<Integer, int[]> map;
    Queue<int[]> queue;
    int distance[][];

    public int snakesAndLadders(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        distance = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);

        buildMap(grid);

        queue = new ArrayDeque<>();

        queue.offer(new int[] { 1, 0 });
        distance[m - 1][0] = 0;

        while (!queue.isEmpty()) {
            int curr[] = queue.poll();

            int currCellNum = curr[0];
            int currStep = curr[1];

            if (currCellNum == m * m) {
                return currStep;
            }

            if (currStep > m * m)
                continue;

            for (int i = 1; i <= 6; i++) {
                int nextCellNum = currCellNum + i;

                if (nextCellNum > m * m)
                    break;

                int nextCell[] = map.get(nextCellNum);

                int nx = nextCell[0];
                int ny = nextCell[1];

                int nextCellVal = grid[nx][ny];

                if (nextCellVal == -1) {
                    if (currStep + 1 < distance[nx][ny]) {
                        distance[nx][ny] = currStep + 1;
                        queue.offer(new int[] { nextCellNum, currStep + 1 });
                    }
                } else {
                    if (currStep + 1 < distance[nx][ny]) {
                        distance[nx][ny] = currStep + 1;
                        queue.offer(new int[] { nextCellVal, currStep + 1 });
                    }
                }

            }
        }

        return -1;
    }

    private void buildMap(int[][] grid) {
        map = new HashMap<>();
        int counter = 0;
        int inc = 1;

        for (int i = m - 1; i >= 0; i--) {
            int row[] = grid[i];

            if (counter == 0) {
                for (int j = 0; j < row.length; j++) {
                    map.put(inc++, new int[] { i, j });
                }

                counter = 1;
            } else {
                for (int j = row.length - 1; j >= 0; j--) {
                    map.put(inc++, new int[] { i, j });
                }
                counter = 0;
            }
        }

    }
}