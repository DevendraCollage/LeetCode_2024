/*
 * LC386
 */

import java.util.*;
// import java.util.stream.Collectors;

public class LC386 {
    public static List<Integer> lexicalOrder(int n) {
        // ? This type-1
        // List<String> nums = new ArrayList<>();
        // for (int i = 1; i <= n; i++) {
        // nums.add(String.valueOf(i));
        // }
        // Collections.sort(nums);
        // return nums.stream().map(Integer::parseInt).collect(Collectors.toList());

        // ? This type-2
        int numberToPrint = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(numberToPrint);

            if (numberToPrint * 10 <= n) {
                numberToPrint *= 10;
            } else {
                if (numberToPrint + 1 <= n && numberToPrint % 10 != 9) {
                    numberToPrint++;
                } else {
                    while (((numberToPrint / 10) % 10) == 9) {
                        numberToPrint = numberToPrint / 10;
                    }
                    numberToPrint = numberToPrint / 10 + 1;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number here : ");
        int n = sc.nextInt();
        System.out.println();

        List<Integer> ans = lexicalOrder(n);

        System.out.println(ans);

        sc.close();
    }
}