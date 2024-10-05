/*
 * LC2491
 */

import java.util.*;

public class LC2491 {
    public static long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n / 2;
        int totalSum = 0;
        int freqMap[] = new int[1001];
        for (int element : skill) {
            freqMap[element]++;
            totalSum += element;
        }
        if (totalSum % teams != 0) {
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for (int element : skill) {
            if (freqMap[element] == 0) {
                continue;
            }
            freqMap[element]--;
            int partner = targetPoints - element;
            if (freqMap[partner] == 0) {
                return -1;
            }
            freqMap[partner]--;
            res = res + ((long) element * (long) partner);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        long ans = dividePlayers(arr);

        System.out.println(ans);

        sc.close();
    }
}
