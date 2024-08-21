import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class LC1636 {
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int n = nums.length;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Integer temp[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (freq.get(a) == freq.get(b)) {
                    return b - a;
                }
                return freq.get(a) - freq.get(b);
            }
        });
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size Array : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int newArr[] = frequencySort(arr);

        for (int i = 0; i < newArr.length; i++) {
            System.out.printf("[%d] : %d\n", i, newArr[i]);
        }

        sc.close();
    }
}
