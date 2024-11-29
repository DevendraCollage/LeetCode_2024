/*
 * LC2577
 */

import java.util.*;

public class LC2577 {
    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int n, m;

    public static int minimumTime(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Early exit if the grid is blocked from the start
        if ((m > 1 && grid[1][0] > 1) && (n > 1 && grid[0][1] > 1)) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], time = curr[2];

            if (row == m - 1 && col == n - 1) {
                return time; // Reached the target
            }

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            for (int[] d : dir) {
                int r = row + d[0], c = col + d[1];

                if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c]) {
                    continue;
                }

                // Calculate waiting time
                int wait = (grid[r][c] > time && (grid[r][c] - time) % 2 == 0) ? 1 : 0;
                int nextTime = Math.max(time + 1, grid[r][c] + wait);

                pq.offer(new int[] { r, c, nextTime });
            }
        }

        return -1; // No path found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Row : ");
        int m = sc.nextInt();
        System.out.println();

        System.out.print("Enter Column : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] grid = new int[m][n];

        System.out.println("Enter The Grid Elements : ");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = minimumTime(grid);

        System.out.println(ans);

        sc.close();
    }
}