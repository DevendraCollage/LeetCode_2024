/*
 * LC2064
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC2064 {
    public static int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = Arrays.stream(quantities).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2;
            int needed = 0;

            for (int q : quantities) {
                needed += (q + mid - 1) / mid;
            }

            if (needed <= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The N Number Here : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] arr = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int answer = minimizedMaximum(n, arr);

        System.out.println(answer);

        sc.close();
    }
}