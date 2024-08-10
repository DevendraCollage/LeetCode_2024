/*
 * LC3016
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC3016 {
    public static int minimumPushes(String word) {
        int arr[] = new int[26];
        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }
        Arrays.sort(arr);
        int count = 0;
        int minKeyPress = 0;
        for (int i = 25; i >= 0; i--) {
            // ! This is lengthy process
            // int mul = 0;
            // if (count < 8) {
            // mul = 1;
            // } else if (count < 16) {
            // mul = 2;
            // } else if (count < 24) {
            // mul = 3;
            // } else {
            // mul = 4;
            // }
            if (arr[i] == 0) {
                break;
            }
            int val = arr[i] * (count / 8 + 1); // ! This is the shortest process
            minKeyPress += val;
            count++;
        }
        return minKeyPress;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String Here : ");
        String str = sc.nextLine();

        int min = minimumPushes(str);

        System.out.println(min);

        sc.close();
    }
}