/*
 * LC2981
 */

import java.util.*;

public class LC2981 {
    public static int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        // Generate all special substrings and store in map
        for (int i = 0; i < n; i++) {
            StringBuilder curString = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (curString.length() == 0 || s.charAt(j) == curString.charAt(curString.length() - 1)) {
                    curString.append(s.charAt(j));
                    String cur = curString.toString();
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                } else {
                    break;
                }
            }
        }
        int maxLength = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int freq = entry.getValue();
            if (freq > 2) {
                maxLength = Math.max(maxLength, str.length());
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        int ans = maximumLength(str);

        System.out.println(ans);

        sc.close();
    }
}