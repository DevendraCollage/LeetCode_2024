/*
 * LC2914
 */

import java.util.Scanner;

public class LC2914 {
    public static int minChanges(String s) {
        char curr = s.charAt(0);

        int flips = 0,
                seqCount = 0;

        int i = 0;

        while (i < s.length()) {
            if (curr == s.charAt(i)) {
                seqCount++;
                i++;
                continue;
            }

            if (seqCount % 2 == 0) {
                // Even Case
                seqCount = 0;
            } else {
                // Odd Case
                flips++;
                i++;
                seqCount = 0;
            }

            if (i == s.length()) {
                break;
            }
            curr = s.charAt(i);
        }
        return flips;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        int ans = minChanges(str);

        System.out.println(ans);

        sc.close();
    }
}
