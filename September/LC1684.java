/*
 * LC1684
 */

import java.util.*;

public class LC1684 {
    public static int countConsistentStrings(String allowed, String[] words) {
        int counter = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        for (String character : words) {
            boolean flag = true;
            for (int i = 0; i < character.length(); i++) {
                if (!set.contains(character.charAt(i))) {
                    flag = false;
                }
            }
            if (flag) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String Here : ");
        String str = sc.nextLine();
        System.out.print("Enter the Size Array : ");
        int size = sc.nextInt();
        sc.nextLine();
        System.out.println();

        String arr[] = new String[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextLine();
        }
        System.out.println();

        int count = countConsistentStrings(str, arr);

        System.out.println(count);

        sc.close();
    }
}