/*
 * LC1671
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC1671 {
    private static List<Integer> LIS(List<Integer> nums) {
        int n = nums.size();
        List<Integer> lis = new ArrayList<>();
        List<Integer> lisLen = new ArrayList<>(Collections.nCopies(n, 1));

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int lb = Collections.binarySearch(lis, num);
            if (lb < 0) {
                lb = -lb - 1;
            }
            if (lb >= lis.size()) {
                lis.add(num);
            } else {
                lis.set(lb, num);
            }
            lisLen.set(i, lis.size());
        }
        return lisLen;
    }

    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        List<Integer> lisR = LIS(numList);

        Collections.reverse(numList);
        List<Integer> lisRL = LIS(numList);
        Collections.reverse(lisRL);

        int maxMountainSize = 0;
        for (int i = 0; i < n; i++) {
            if (lisR.get(i) > 1 && lisRL.get(i) > 1) {
                maxMountainSize = Math.max(maxMountainSize, lisR.get(i) + lisRL.get(i) - 1);
            }
        }

        return n - maxMountainSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] arr = new int[size];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int answer = minimumMountainRemovals(arr);

        System.out.println(answer);

        sc.close();
    }
}