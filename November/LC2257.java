/*
 * LC2257
 */

import java.util.*;

public class LC2257 {
    static int[][] grid;
    static int m1, n1;

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        grid = new int[m][n];
        m1 = m;
        n1 = n;

        // Mark guards with 2
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        // Mark walls with 3
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        // Traverse from each guard in all directions
        for (int[] guard : guards) {
            markGuarded(guard[0], guard[1], -1, 0); // Up
            markGuarded(guard[0], guard[1], 1, 0); // Down
            markGuarded(guard[0], guard[1], 0, 1); // Right
            markGuarded(guard[0], guard[1], 0, -1); // Left
        }

        // Count unguarded cells
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static void markGuarded(int i, int j, int di, int dj) {
        i += di;
        j += dj;

        // Traverse in the given direction
        while (i >= 0 && i < m1 && j >= 0 && j < n1) {
            // Stop if a wall or guard is encountered
            if (grid[i][j] == 3 || grid[i][j] == 2) {
                break;
            }

            // Mark the cell as guarded
            if (grid[i][j] == 0) {
                grid[i][j] = 1;
            }

            // Move further in the same direction
            i += di;
            j += dj;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the M Number : ");
        int m = sc.nextInt();
        System.out.println();

        System.out.print("Enter the N Number : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Guards Array Size : ");
        int n1 = sc.nextInt();
        System.out.println();

        int[][] guards = new int[n1][n1];

        System.out.println("Enter The Guards Array Elements : ");
        for (int i = 0; i < guards.length; i++) {
            for (int j = i; j < guards.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                guards[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.print("Enter The Walls Array Size : ");
        int n2 = sc.nextInt();
        System.out.println();

        int[][] walls = new int[n2][n2];

        System.out.println("Enter The Walls Array Elements : ");
        for (int i = 0; i < walls.length; i++) {
            for (int j = i; j < walls.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                walls[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = countUnguarded(m, n, guards, walls);

        System.out.println(ans);

        sc.close();
    }
}