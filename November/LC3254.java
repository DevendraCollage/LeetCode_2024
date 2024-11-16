/*
 * LC3254
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class LC3254 {
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) // Remove elements outside of current window
                dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] != nums[i] - 1) // If elements are not consecutive & ASC ordered
                dq.pollLast();

            dq.offerLast(i);
            if (i >= k - 1) {
                if (dq.size() == k)
                    res.add(nums[dq.peekLast()]);
                else
                    res.add(-1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The K Element Value : ");
        int k = sc.nextInt();
        System.out.println();

        int[] ans = resultsArray(arr, k);

        System.out.println("This is the Answer Array");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("[%d] : %d\n", i, ans[i]);
        }

        sc.close();
    }
}