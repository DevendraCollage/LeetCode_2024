/*
 * LC3133
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC3133 {
    private static List<Integer> getBin(int n) {
        List<Integer> res = new ArrayList<>();
        while (n > 0) {
            if ((n & 1) == 1) {
                res.add(1);
            } else {
                res.add(0);
            }
            n >>= 1;
        }

        return res;
    }

    public static long minEnd(int n, int x) {
        if (n == 1) {
            return x;
        }

        // Step1: Record zero positions
        List<Integer> zeroPos = new ArrayList<>();
        int count = 0;
        int val = x;
        while (val > 0) {
            if ((val & 1) == 0) {
                zeroPos.add(count);
            }
            count++;
            val >>= 1;
        }

        // Step2: Find the number of bits required to make N combinations
        int reqdBits = (int) Math.ceil(Math.log(n) / Math.log(2));

        // Step3: Append more bits in zeroPos as per requirement
        for (int i = zeroPos.size(); i < reqdBits; i++) {
            zeroPos.add(count++);
        }

        // Ste4: Find bits to be appended
        List<Integer> appendBits = getBin(n - 1);

        // Step5: Form the answer
        long ans = x;
        int pos = appendBits.size();
        while (pos-- > 0) {
            if (appendBits.get(pos) == 1) {
                ans = ans + (1L << zeroPos.get(pos));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number n : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter the number x : ");
        int x = sc.nextInt();
        System.out.println();

        long answer = minEnd(n, x);

        System.out.println(answer);

        sc.close();
    }
}