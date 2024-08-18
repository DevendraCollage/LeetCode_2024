/*
 * LC2418
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LC2418 {
    public static String[] sortPeople(String[] names, int[] height) {
        int n = height.length;
        Integer index[] = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return height[b] - height[a];
            }
        });
        String res[] = new String[n];
        int i = 0;
        for (Integer ind : index) {
            res[i] = names[ind];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of Names Array : ");
        int sizen = sc.nextInt();
        sc.nextLine();
        System.out.println();

        String names[] = new String[sizen];

        System.out.println("Enter the Names Elements : ");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("[%d] : ", i);
            names[i] = sc.nextLine();
        }
        System.out.println();

        System.out.print("Enter Size of Height Array : ");
        int sizeh = sc.nextInt();
        System.out.println();

        int height[] = new int[sizeh];

        System.out.println("Enter the Height Elements : ");
        for (int i = 0; i < height.length; i++) {
            System.out.printf("[%d] : ", i);
            height[i] = sc.nextInt();
        }
        System.out.println();

        String n[] = sortPeople(names, height);

        System.out.println("Sorted Name Array is : ");
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }

        sc.close();
    }
}
