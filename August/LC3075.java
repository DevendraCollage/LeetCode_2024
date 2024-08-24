/*
 * LC3075
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC3075 {
    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        int turns = 0;
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum = sum + Math.max(happiness[i] - turns, 0);
            turns++;
            if (turns >= k) {
                break;
            }
        }
        return sum;
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

        System.out.print("Enter number of children you want to select : ");
        int k = sc.nextInt();

        long sum = maximumHappinessSum(arr, k);

        System.out.println(sum);

        sc.close();
    }
}
