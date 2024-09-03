/*
 * LC1894
 */

import java.util.Scanner;

public class LC1894 {
    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        int remainingChalks = (int) (k % sum);

        for (int i = 0; i < chalk.length; i++) {
            if (remainingChalks < chalk[i]) {
                return i;
            }
            remainingChalks -= chalk[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter chalk Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int chalk[] = new int[size];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < chalk.length; i++) {
            System.out.printf("[%d] : ", i);
            chalk[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter k value : ");
        int k = sc.nextInt();

        int repl = chalkReplacer(chalk, k);

        System.out.println(repl);

        sc.close();
    }
}