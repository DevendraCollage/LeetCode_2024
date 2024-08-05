import java.util.*;

public class LC1460 {
    public static boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int element : target) {
            map1.put(element, map1.getOrDefault(element, 0) + 1);
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int element : arr) {
            map2.put(element, map2.getOrDefault(element, 0) + 1);
        }

        for (int key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                return false;
            }
            if (map1.get(key) != map2.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Size of Array-1 : ");
        int size1 = sc.nextInt();

        int arr1[] = new int[size1];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("[%d] : ", i);
            arr1[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter the Size of Array-2 : ");
        int size2 = sc.nextInt();

        int arr2[] = new int[size2];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("[%d] : ", i);
            arr2[i] = sc.nextInt();
        }

        boolean n = canBeEqual(arr1, arr2);
        System.out.println(n);

        sc.close();
    }
}