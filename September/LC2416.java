/*
 * LC2416
 */

import java.util.*;

class Node {
    Node child[];
    int count;

    Node() {
        child = new Node[26]; // 0 to 9 digits
        count = 0;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.child[index] == null) {
                temp.child[index] = new Node();
            }
            temp.child[index].count++;
            temp = temp.child[index];
        }
    }

    public int findPrefixCount(String word) {
        Node temp = root;
        int count = 0;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            count = count + temp.child[index].count;
            temp = temp.child[index];
        }

        return count;
    }
}

public class LC2416 {
    public static int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int count[] = new int[words.length]; // result
        for (String word : words) {
            trie.addWord(word); // insert in prefix trie
        }
        int index = 0;
        for (String word : words) {
            count[index] = trie.findPrefixCount(word);
            index++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        sc.nextLine();
        System.out.println();

        String str[] = new String[size];

        System.out.println("Enter the String Here : ");
        for (int i = 0; i < str.length; i++) {
            System.out.printf("[%d] : ", i);
            str[i] = sc.nextLine();
        }
        System.out.println();

        int ans[] = sumPrefixScores(str);

        System.out.println(Arrays.toString(ans));

        sc.close();
    }
}