/*
 * LC1813
 */

import java.util.*;

public class LC1813 {
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() > sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        String smallerWords[] = sentence1.split(" ");
        String largerWords[] = sentence2.split(" ");
        int start = 0;
        int end1 = smallerWords.length - 1;
        int end2 = largerWords.length - 1;
        while (start <= end1 && smallerWords[start].equals(largerWords[start])) {
            start++;
        }
        while (start <= end1 && smallerWords[end1].equals(largerWords[end2])) {
            end1--;
            end2--;
        }
        return (start > end1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String-1 Here : ");
        String str1 = sc.nextLine();
        System.out.println();

        System.out.print("Enter String-2 Here : ");
        String str2 = sc.nextLine();
        System.out.println();

        boolean ans = areSentencesSimilar(str1, str2);

        System.out.println(ans);

        sc.close();
    }
}