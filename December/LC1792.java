/*
 * LC1792
 */

import java.util.*;

public class LC1792 {
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        // [diff, pass, total]
        // Compare in decreasing order
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        // insert in priority queue (sorted on diff high to low)
        for (int[] arr : classes) {
            int pass = arr[0];
            int total = arr[1];
            double diff = findDiff(pass, total);
            pq.offer(new double[] { diff, pass, total });
        }
        // include extraStudents in that class which will have highest pass ratio
        while (extraStudents > 0) {
            double[] arr = pq.poll();
            int pass = (int) arr[1] + 1;
            int total = (int) arr[2] + 1;
            double diff = findDiff(pass, total);
            pq.offer(new double[] { diff, pass, total });
            extraStudents--;
        }
        // sum of pass ratio
        double totalPassRatio = 0;
        while (!pq.isEmpty()) {
            double[] arr = pq.poll();
            double pass = arr[1];
            double total = arr[2];
            totalPassRatio += (pass / total);
        }

        // average of pass ratio
        return totalPassRatio / classes.length;
    }

    // Helper function to find the difference on the basis of the given number
    public static double findDiff(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Classes Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] classes = new int[n][n];

        System.out.println("Enter The Classes Array Elements : ");
        for (int i = 0; i < classes.length; i++) {
            for (int j = 0; j < classes.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                classes[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.print("Enter Extra Students : ");
        int extraStudents = sc.nextInt();
        System.out.println();

        double ans = maxAverageRatio(classes, extraStudents);

        System.out.println(ans);

        sc.close();
    }
}