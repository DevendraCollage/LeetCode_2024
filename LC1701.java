/*
 * LC1701
 */

import java.util.Scanner;

public class LC1701 {
    public static double averageWaitingTime(int[][] customers) {
        int idleTime = 1;
        long totalWaitingTime = 0;
        for (int customer[] : customers) {
            if (idleTime <= customer[0]) {
                idleTime = customer[0] + customer[1];
            } else {
                idleTime = idleTime + customer[1];
            }
            totalWaitingTime += (idleTime - customer[0]);
        }
        double avg = (totalWaitingTime / (double) customers.length);

        return avg;
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

        double avgTime = averageWaitingTime(arr);

        System.out.printf("Average Waiting Time : %f", avgTime);

        sc.close();
    }
}