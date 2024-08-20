/*
 * LC1122
 */

import java.util.*;

public class LC1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        int n = arr1.length;
        int m = arr2.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr1[i]);
        }
        int countArr[] = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int elem = arr1[i];
            countArr[elem]++;
        }
        int res[] = new int[n];

        int j = 0;
        for (int i = 0; i < m; i++) {
            int elem = arr2[i];
            while (countArr[elem] > 0) {
                res[j] = elem;
                j++;
                countArr[elem]--;
            }
        }

        for (int i = 0; i < max + 1; i++) {
            while (countArr[i] > 0) {
                res[j] = i;
                j++;
                countArr[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Size of Array-1 : ");
        int size1 = sc.nextInt();
        System.out.println();

        int arr1[] = new int[size1];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("[%d] : ", i);
            arr1[i] = sc.nextInt();
        }
        System.out.println();

        System.out.println("Enter the Size of Array-2 : ");
        int size2 = sc.nextInt();
        System.out.println();

        int arr2[] = new int[size2];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("[%d] : ", i);
            arr2[i] = sc.nextInt();
        }
        System.out.println();

        int newArr[] = relativeSortArray(arr1, arr2);

        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }

        sc.close();
    }
}