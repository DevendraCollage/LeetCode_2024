/*
 * LC1590
 */

import java.util.*;

public class LC1590 {
    public static int minSubarray(int[] nums, int p) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum = (totalSum + nums[i]) % p;
        }

        if (totalSum == 0) {
            return 0;
        }

        int sumJ = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sumJ = (sumJ + nums[i]) % p;

            int sumI = (sumJ - totalSum + p) % p;

            if (map.containsKey(sumI)) {
                min = Math.min(min, i - map.get(sumI));
            }

            map.put(sumJ, i);
        }

        if (min == nums.length) {
            return -1;
        }

        return min;
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

        System.out.print("Enter Element P : ");
        int p = sc.nextInt();
        System.out.println();

        int ans = minSubarray(arr, p);

        System.out.println(ans);

        sc.close();
    }
}