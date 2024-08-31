/*
 * LC2485
 */

import java.util.Scanner;

public class LC2485 {
    public static int pivotInteger(int n) {
        // ! Formula One
        // int ls = 0;
        // int rs = n * (n + 1) / 2;
        // for (int i = 1; i <= n; i++) {
        // ls += i;
        // rs -= (i - 1);

        // if (ls == rs) {
        // return i;
        // }
        // }

        // return -1;

        // ! Formula Two
        int cumSum = n * (n + 1) / 2;
        double pivot = (int) Math.sqrt(cumSum);
        if (pivot % 1 != 0) {
            return -1;
        }
        return ((int) pivot);

        // ? We can also check like this
        // return (pivot * pivot == cumSum) ? pivot : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number here : ");
        int n = sc.nextInt();
        System.out.println();

        int pivot = pivotInteger(n);

        System.out.println(pivot);

        sc.close();
    }
}