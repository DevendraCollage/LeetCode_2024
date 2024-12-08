/*
 * LC2054
 */

import java.util.*;

public class LC2054 {
    public static int maxTwoEvents(int[][] events) {
        // sort on end time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // sort on start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int prevMax = 0;
        int res = 0;
        for (int[] event : events) {
            // find previous max
            while (!pq.isEmpty() && pq.peek()[1] < event[0]) {
                prevMax = Math.max(prevMax, pq.peek()[2]);
                pq.poll();
            }
            res = Math.max(res, prevMax + event[2]);
            pq.offer(event);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[][] arr = new int[size][size];

        System.out.println("Enter The Matrix Events Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = maxTwoEvents(arr);

        System.out.println(ans);

        sc.close();
    }
}