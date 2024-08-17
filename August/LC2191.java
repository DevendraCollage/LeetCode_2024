/*
 * LC2191
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LC2191 {

    public static int[] convertToNewSystem(int[] mapping, int[] nums) {
        int n = nums.length;
        int newSys[] = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 0) {
                newSys[i] = mapping[0];
                continue;
            }
            int j = 0;
            int res = 0;
            while (num > 0) {
                int digit = num % 10; // Digit Extraction
                int newD = mapping[digit];// Digits Conversion
                res = newD * (int) Math.pow(10, j) + res; // Formation
                num = num / 10; // Remove the last digit
                j++; // Move to the next power
            }
            newSys[i] = res;
        }

        return newSys;
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int newSys[] = convertToNewSystem(mapping, nums);
        Integer index[] = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return newSys[a] - newSys[b];
            }
        });
        int result[] = new int[n];
        int i = 0;
        for (int ind : index) {
            result[i] = nums[ind];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of Array : ");
        int size = sc.nextInt();
        System.out.println();

        int mapping[] = new int[size];

        System.out.println("Enter the Elements of the Mappings : ");
        for (int i = 0; i < mapping.length; i++) {
            System.out.printf("[%d] : ", i);
            mapping[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter the Size of new Array : ");
        int numSize = sc.nextInt();
        System.out.println();

        int nums[] = new int[numSize];

        System.out.println("Enter the Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }

        int newArray[] = sortJumbled(mapping, nums);

        System.out.println("This is the result");
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }

        sc.close();
    }
}