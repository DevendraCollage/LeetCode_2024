import java.util.HashSet;
import java.util.Scanner;

public class LC1593 {
    static int maxCount;

    public static void backTrack(String s, HashSet<String> set, int index) {
        int n = s.length();
        // base case
        if (index == s.length()) {
            maxCount = Math.max(maxCount, set.size());
            return;
        }
        // loop
        for (int i = index; i < n; i++) {
            // check if substring is present in set or not
            String sub = s.substring(index, i + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                backTrack(s, set, i + 1);
                set.remove(sub); // backtracking
            }
        }
    }

    public static int maxUniqueSplit(String s) {
        maxCount = 0;
        HashSet<String> set = new HashSet<>();
        backTrack(s, set, 0);
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String Here : ");
        String str = sc.nextLine();
        System.out.println();

        int ans = maxUniqueSplit(str);

        System.out.println(ans);

        sc.close();
    }
}
