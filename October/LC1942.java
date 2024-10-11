/*
 * LC1942
 */

import java.util.*;

public class LC1942 {
    public static int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });
        // Leaving time and chair no
        PriorityQueue<int[]> occupied = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> available = new PriorityQueue<>();
        int chairNo = 0;
        for (int time[] : times) {
            int arrTime = time[0];
            int leaveTime = time[01];
            while (!occupied.isEmpty() && occupied.peek()[0] <= arrTime) {
                available.offer(occupied.poll()[1]);
            }
            int currentChairNo;
            if (available.isEmpty()) {
                currentChairNo = chairNo;
                chairNo++;
            } else {
                currentChairNo = available.poll();
            }
            if (targetArrival == arrTime) {
                return currentChairNo;
            }
            occupied.offer(new int[] { leaveTime, currentChairNo });
        }
        return -1;
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.print("Enter the Target : ");
        int target = sc.nextInt();
        System.out.println();

        int ans = smallestChair(arr, target);

        System.out.println(ans);

        sc.close();
    }
}