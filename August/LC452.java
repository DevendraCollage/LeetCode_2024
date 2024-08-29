/*
 * LC452
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class LC452 {
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int a1[], int a2[]) {
                if (a1[0] == a2[0]) {
                    return 0;
                }
                if (a1[0] < a2[0]) {
                    return -1;
                }
                return 1;
            }
        });
        int arrows = 1;
        // int commonInterval[] = points[0];

        // ? Optimization
        int commonEndPoint = points[0][1];
        for (int i = 1; i < n; i++) {
            int currS = points[i][0];
            int currE = points[i][1];
            // If intervals are overlapping then we can use existing arrow to burst it
            if (currS <= commonEndPoint) {
                // commonInterval[0] = Math.max(commonInterval[0], currS);

                commonEndPoint = Math.min(commonEndPoint, currE);
            } else {
                // Start a new interval
                // commonInterval[0] = currS;

                commonEndPoint = currE;
                arrows++;
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[][] = new int[size][size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int balloonNum = findMinArrowShots(arr);

        System.out.println(balloonNum);

        sc.close();
    }
}