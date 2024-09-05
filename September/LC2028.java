/*
 * LC2028
 */

import java.util.Scanner;

public class LC2028 {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (n + m);
        for (int i = 0; i < m; i++) {
            sum -= rolls[i];
        }
        if (sum < n || sum > 6 * n) {
            return new int[0];
        }
        int avg = sum / n;
        int rem = sum % n;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = avg;
            if (rem > 0) {
                res[i]++;
                rem--;
            }
        }
        return res;
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
        System.out.println();

        System.out.print("Enter mean value : ");
        int mean = sc.nextInt();
        System.out.println();

        System.out.print("Enter length : ");
        int len = sc.nextInt();
        System.out.println();

        int newArr[] = missingRolls(arr, mean, len);

        for (int i = 0; i < newArr.length; i++) {
            System.out.printf("[%d] : %d\t", i, newArr[i]);
            System.out.println();
        }

        sc.close();
    }
}
