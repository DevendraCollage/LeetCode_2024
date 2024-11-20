/*
 * LC2516
 */

import java.util.*;

public class LC2516 {
    static int k;

    public static int takeCharacters(String s, int kParam) {
        k = kParam;
        int[] count = new int[3];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        int n = s.length();

        // Base Case
        if (!valid(count)) {
            return -1;
        }

        // Get the middle string that we have to remove
        int begin = 0, end = 0;
        int max = -1;
        while (end < n) {
            char ch = s.charAt(end);
            count[ch - 'a']--;

            while (begin <= end && !valid(count)) {
                count[s.charAt(begin) - 'a']++;
                begin++;
            }

            max = Math.max(max, end - begin + 1);
            end++;
        }

        return n - max;
    }

    private static boolean valid(int[] count) {
        for (int i : count) {
            if (i < k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String s = sc.nextLine();
        System.out.println();

        System.out.print("Enter The k Minute Here : ");
        int k = sc.nextInt();
        System.out.println();

        int answer = takeCharacters(s, k);

        System.out.println(answer);

        sc.close();
    }
}