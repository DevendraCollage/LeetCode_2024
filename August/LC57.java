/*
 * LC57
 */

import java.util.Scanner;
import java.util.ArrayList;

public class LC57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        // Stores intervals before overlap
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // Merge overlapping intervals if any
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        // Append the remaining intervals
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of 2D Array : ");
        int size1 = sc.nextInt();
        System.out.println();

        int arr[][] = new int[size1][size1];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.print("Enter the size of t Internal : ");
        int size2 = sc.nextInt();
        System.out.println();

        int arr2[] = new int[size2];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("[%d] : ", i);
            arr2[i] = sc.nextInt();
        }
        System.out.println();

        int newArr[][] = insert(arr, arr2);

        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("[%d][%d] : [%d] ", i, j, newArr[i][j]);
            }
        }

        sc.close();
    }
}