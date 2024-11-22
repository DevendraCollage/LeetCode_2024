/*
 * LC1072
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LC1072 {
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        // Store Our Answer
        int maxCount = 0;

        // Store the Matrix
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder key = new StringBuilder("");

            for (int i = 0; i < matrix[0].length; i++) {
                if (row[i] == row[0]) {
                    key.append("x");
                } else {
                    key.append("y");
                }
            }

            String keyStr = key.toString();

            if (!map.containsKey(keyStr)) {
                map.put(keyStr, 0);
            }

            map.put(keyStr, map.get(keyStr) + 1);
        }

        for (int val : map.values()) {
            maxCount = Math.max(maxCount, val);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Size Matrix : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] matrix = new int[n][n];

        System.out.println("Enter The Matrix Elements : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = maxEqualRowsAfterFlips(matrix);

        System.out.println(ans);

        sc.close();
    }
}