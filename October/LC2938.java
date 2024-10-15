/*
 * LC2938
 */

import java.util.*;

public class LC2938 {
    public static long minimumSteps(String s) {
        int n = s.length();
        long swapCount = 0;
        int last = 0;
        for (int cur = 0; cur < n; cur++) {
            if (s.charAt(cur) == '0') { // White Ball
                swapCount += (cur - last);
                last++;
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String Here : ");
        String str = sc.nextLine();
        System.out.println();

        long ans = minimumSteps(str);

        System.out.println(ans);

        sc.close();
    }
}