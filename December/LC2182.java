/*
 * LC2182
 */

import java.util.Scanner;
import java.lang.StringBuilder;

public class LC2182 {
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int index = 25; // Start from the largest character

        while (index >= 0) {
            if (freq[index] == 0) {
                index--;
                continue;
            }

            int used = Math.min(freq[index], repeatLimit);

            for (int i = 0; i < used; i++) {
                sb.append((char) ('a' + index));
            }
            freq[index] -= used;

            if (freq[index] > 0) { // find a smaller character
                int prevIndex = index - 1;
                while (prevIndex >= 0 && freq[prevIndex] == 0) {
                    prevIndex--;
                }
                if (prevIndex < 0) {
                    break;
                }
                sb.append((char) ('a' + prevIndex));
                freq[prevIndex]--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String S : ");
        String s = sc.nextLine();
        System.out.println();

        System.out.print("Enter The Repeat Limit : ");
        int repeatLimit = sc.nextInt();
        System.out.println();

        String ans = repeatLimitedString(s, repeatLimit);

        System.out.println(ans);

        sc.close();
    }
}