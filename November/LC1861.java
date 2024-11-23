/*
 * LC1861
 */

import java.util.*;

public class LC1861 {
    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];

        for (int i = 0; i < m; i++) {
            char[] row = applyGravity(box[i]);

            for (int j = 0; j < n; j++) {
                ans[j][m - 1 - i] = row[j];
            }
        }

        return ans;
    }

    // Helper function to fill the boxes
    private static char[] applyGravity(char[] row) {
        int stones = 0, cells = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '*') {
                int j = i - 1;
                while (cells-- > 0) {
                    if (stones > 0) {
                        stones -= 1;
                        row[j] = '#';
                    } else {
                        row[j] = '.';
                    }
                    j--;
                }
            } else if (row[i] == '#') {
                stones++;
            }
            cells++;
        }
        int j = row.length - 1;
        while (cells-- > 0) {
            if (stones > 0) {
                stones -= 1;
                row[j] = '#';
            } else {
                row[j] = '.';
            }
            j--;
        }

        return row;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Box Character Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        char[][] box = new char[n][n];

        System.out.println("Enter The Character Elements : ");
        for (int i = 0; i < box.length; i++) {
            for (int j = i; j < box.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                box[i][j] = sc.nextLine().charAt(0);
            }
        }

        char[][] ans = rotateTheBox(box);

        System.out.println("This is the Answer : ");
        for (int i = 0; i < ans.length; i++) {
            for (int j = i; j < ans.length; j++) {
                System.out.printf("[%d][%d] : %s\n", i, j, ans[i][j]);
            }
        }

        sc.close();
    }
}