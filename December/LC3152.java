/*
 * LC3152
 */

import java.util.*;

public class LC3152 {
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] count = new int[n];
        count[0] = 0;
        for (int i = 1; i < n; i++) {
            int parity = (nums[i] % 2 == nums[i - 1] % 2) ? 1 : 0;
            count[i] = count[i - 1] + parity;
        }
        int m = queries.length;
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = ((count[end] - count[start]) == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Nums Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The Queries Array Length : ");
        int size = sc.nextInt();
        System.out.println();

        int[][] queries = new int[size][size];

        System.out.println("Enter The Queries Array Elements : ");
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < queries.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                queries[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        boolean[] ans = isArraySpecial(nums, queries);

        System.out.println("Answers : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d, ", ans[i]);
        }

        sc.close();
    }
}