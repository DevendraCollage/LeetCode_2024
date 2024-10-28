/*
 * LC2501
 */

import java.util.*;

public class LC2501 {
    public static int longestSquareStreak(int[] nums) {
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int num : nums) {
            sortedSet.add(num);
        }

        HashSet<Integer> numSet = new HashSet<>(sortedSet);

        int maxLength = 0;

        for (int num : sortedSet) {
            int length = 0;
            long current = num;

            while (current <= Integer.MAX_VALUE && numSet.contains((int) current)) {
                length++;
                current = current * current;
            }

            if (length > 1) {
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength > 1 ? maxLength : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] arr = new int[size];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int ans = longestSquareStreak(arr);

        System.out.println(ans);

        sc.close();
    }
}