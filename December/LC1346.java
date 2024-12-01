/*
 * LC1346
 */

import java.util.*;

public class LC1346 {
    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : arr) {
            if (set.contains(element * 2) || ((element % 2 == 0) && (set.contains(element / 2)))) {
                return true;
            }
            set.add(element);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        boolean ans = checkIfExist(arr);

        System.out.println(ans);

        sc.close();
    }
}