/*
 * LC1051
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC1051 {
    public static void countSort(int[] expected) {
        int count[] = new int[101];
        for (int num : expected) {
            count[num]++;
        }

        int j = 0;
        for (int i = 0; i <= 100; i++) {
            if (count[i] != 0) {
                while (count[i] > 0) {
                    expected[j] = i;
                    j++;
                    count[i]--;
                }
            }
            if (j == expected.length) {
                break;
            }
        }
    }

    public static int heightChecker(int[] heights) {
        int expected[] = heights.clone();
        countSort(expected);
        Arrays.sort(expected); // This is direct approach you can also use this
        int count = 0;
        for (int i = 0; i < expected.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }

        int count = heightChecker(arr);

        System.out.println(count);

        sc.close();
    }
}