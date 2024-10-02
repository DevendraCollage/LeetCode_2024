/*
 * LC1331
 */

import java.util.*;
import java.util.stream.Collectors;

public class LC1331 {
    public static int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && temp[i] != temp[i - 1]) {
                rank++;
            }
            map.put(temp[i], rank);
        }

        int[] ranks = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ranks[i] = map.get(arr[i]);
        }

        return ranks;
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

        List<Integer> ans = Arrays.stream(arrayRankTransform(arr)).boxed().collect(Collectors.toList());

        System.out.println(ans);

        sc.close();
    }
}