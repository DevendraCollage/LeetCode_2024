/*
 * LC2940
 * This problem solved using Monotonic Decreasing Stack
 */

import java.util.*;

class BinaryIndexedTree {
    private final int inf = 1 << 30;
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
        Arrays.fill(c, inf);
    }

    public void update(int x, int y) {
        while (x <= n) {
            c[x] = Math.min(c[x], y);
            x += x & -x;
        }
    }

    public int query(int x) {
        int mi = inf;
        while (x > 0) {
            mi = Math.min(mi, c[x]);
            x -= x & -x;
        }
        return mi == inf ? -1 : mi;
    }
}

public class LC2940 {
    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int m = queries.length;
        for (int i = 0; i < m; i++) {
            if (queries[i][0] > queries[i][1]) {
                queries[i] = new int[] { queries[i][1], queries[i][0] };
            }
        }

        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (i, j) -> queries[j][1] - queries[i][1]);
        int[] s = heights.clone();
        Arrays.sort(s);
        int[] ans = new int[m];
        int j = n - 1;

        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int i : idx) {
            int list = queries[i][0], r = queries[i][1];
            while (j > r) {
                int k = n - Arrays.binarySearch(s, heights[j]) + 1;
                tree.update(k, j);
                --j;
            }
            if (list == r || heights[list] < heights[r]) {
                ans[i] = r;
            } else {
                int k = n - Arrays.binarySearch(s, heights[list]);
                ans[i] = tree.query(k);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Heights Arrays Size : ");
        System.out.print("Enter Row : ");
        int row = sc.nextInt();
        System.out.print("Enter Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] heights = new int[row][col];

        System.out.println("Enter The Heights Array Elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                heights[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.print("Enter Queries Arrays Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] queries = new int[n];

        System.out.println("Enter The Queries Array Elements : ");
        for (int i = 0; i < queries.length; i++) {
            System.out.printf("[%d] : ", i);
            queries[i] = sc.nextInt();
        }
        System.out.println();

        int[] ans = leftmostBuildingQueries(queries, heights);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d, ", ans[i]);
        }

        sc.close();
    }
}