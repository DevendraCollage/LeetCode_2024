/*
 * LC884
 */

import java.util.*;

public class LC884 {
    public static String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String res[] = new String[list.size()];
        list.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String-1 : ");
        String str1 = sc.nextLine();
        System.out.println();

        System.out.print("Enter the String-2 : ");
        String str2 = sc.nextLine();
        System.out.println();

        String arr[] = uncommonFromSentences(str1, str2);

        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}