/*
 * LC1455
 */

import java.util.Scanner;

public class LC1455 {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        // form an array
        String words[] = sentence.split(" ");
        int n = words.length;
        int m = searchWord.length();
        for (int i = 0; i < n; i++) {
            if (words[i].length() >= searchWord.length()) {
                if (words[i].substring(0, m).equals(searchWord)) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    // public static int isPrefixOfWord(String sentence, String searchWord) {
    // // 2nd Approach
    // int n = searchWord.length();
    // int m = sentence.length();
    // int i = 0, j = 0;
    // int index = 1;
    // while (i < n) {
    // // Compare any leading space / trailing space
    // while (i < n && sentence.charAt(i) == ' ') {
    // i++;
    // }
    // // Compare the words
    // while (i < n && j < m && sentence.charAt(i) == searchWord.charAt(j)) {
    // i++;
    // j++;
    // }
    // if (j == m) {
    // return index;
    // }
    // j = 0;
    // // Search next space
    // while (i < n && sentence.charAt(i) != ' ') {
    // i++;
    // }
    // // Move to the next word
    // i++;
    // index++;
    // }
    // return -1;
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Sentence Here : ");
        String sentence = sc.nextLine();
        System.out.println();

        System.out.print("Enter Search Word Here : ");
        String searchWord = sc.next();
        System.out.println();

        int ans = isPrefixOfWord(sentence.toLowerCase(), searchWord.toLowerCase());

        System.out.println(ans);

        sc.close();
    }
}