/*
 * LC2406
 */

import java.util.*;

public class LC2406 {
    public static int minGroups(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][0]);
        }
        int eventCount[] = new int[max + 2];
        for (int i = 0; i < n; i++) {
            eventCount[intervals[i][0]]++;
            eventCount[intervals[i][1] + 1]--;
        }
        int maxOverlap = 0;
        int sum = 0;
        for (int i = min; i < max + 2; i++) {
            sum += eventCount[i];
            maxOverlap = Math.max(maxOverlap, sum);
        }
        return maxOverlap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Row Size : ");
        int row = sc.nextInt();
        System.out.println();
        System.out.print("Enter the Column Size : ");
        int col = sc.nextInt();
        System.out.println();

        int arr[][] = new int[row][col];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = minGroups(arr);

        System.out.println(ans);

        sc.close();
    }
}