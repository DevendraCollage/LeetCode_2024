/*
 * LC1371
 * We are using Bit Masking
 */

import java.util.*;

public class LC1371 {
    public static int findTheLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char vowels[] = { 'a', 'e', 'i', 'o', 'u' };

        int mask = 1;
        for (char c : vowels) {
            hashMap.put(c, mask);
            mask = mask * 2;
        }

        mask = 0;
        int ans = 0;
        int seen[] = new int[32];
        Arrays.fill(seen, -1);
        for (int i = 0; i < n; i++) {
            mask = mask ^ (hashMap.getOrDefault(s.charAt(i), 0));
            if (mask != 0 && seen[mask] == -1) {
                seen[mask] = i;
            }
            ans = Math.max(ans, i - seen[mask]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String Here : ");
        String str = sc.nextLine();
        System.out.println();

        int answer = findTheLongestSubstring(str);

        System.out.println(answer);

        sc.close();
    }
}