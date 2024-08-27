/*
 * LC506
 */

import java.util.Scanner;

public class LC506 {
    public static int findMax(int score[]) {
        int max = Integer.MIN_VALUE;
        for (int elem : score) {
            max = Math.max(max, elem);
        }
        return max;
    }

    public static String[] findRelativeRanks(int[] score) {
        int maxValue = findMax(score);
        int countArr[] = new int[maxValue + 1];
        int n = score.length;
        for (int i = 0; i < score.length; i++) {
            countArr[score[i]] = i + 1;
        }
        String res[] = new String[n];
        int rank = 1;
        for (int i = maxValue; i >= 0; i--) {
            if (countArr[i] != 0) {
                int originalIndex = countArr[i] - 1;
                if (rank == 1) {
                    res[originalIndex] = "Gold Medal";
                } else if (rank == 2) {
                    res[originalIndex] = "Silver Medal";
                } else if (rank == 3) {
                    res[originalIndex] = "Bronze Medal";
                } else {
                    res[originalIndex] = Integer.toString(rank);
                }
                rank++;
            }
            if (rank > n) {
                break;
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

        String newArr[] = findRelativeRanks(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.printf("[%d] : [%s]\n", i, newArr[i]);
        }

        sc.close();
    }
}
