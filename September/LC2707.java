/*
 * LC2707
 */

import java.util.*;

public class LC2707 {
    static int dp[] = new int[50];

    public static int recur(String s, HashSet<String> dictionary, int index) {
        if (index == s.length()) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        StringBuilder sb = new StringBuilder();
        int minExtraChar = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int extraChar = 0;
            if (!dictionary.contains(sb.toString())) {
                extraChar = sb.length();
            }
            int currExtra = recur(s, dictionary, i + 1);
            minExtraChar = Math.min(minExtraChar, extraChar + currExtra);
        }

        return dp[index] = minExtraChar;
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Arrays.fill(dp, -1);
        HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));
        return recur(s, dict, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String Here : ");
        String str = sc.nextLine();
        System.out.println();

        System.out.print("Enter the Array Size : ");
        int size = sc.nextInt();
        sc.nextLine();
        System.out.println();

        String st[] = new String[size];

        System.out.println("Enter the String : ");
        for (int i = 0; i < st.length; i++) {
            System.out.printf("[%d] : ", i);
            st[i] = sc.nextLine();
        }
        System.out.println();

        int ans = minExtraChar(str, st);

        System.out.println(ans);

        sc.close();
    }
}
