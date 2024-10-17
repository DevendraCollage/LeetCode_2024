/*
 * LC670
 */

import java.util.*;

public class LC670 {
    public static int maximumSwap(int num) {
        char numArr[] = Integer.toString(num).toCharArray();
        int n = numArr.length;
        char maxElem = numArr[n - 1];
        int maxIndex = n - 1;
        int swapIde1 = -1;
        int swapIde2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (numArr[i] > maxElem) {
                maxElem = numArr[i];
                maxIndex = i;
            } else if (numArr[i] < maxElem) {
                swapIde1 = i;
                swapIde2 = maxIndex;
            }
        }
        // Swapping
        if (swapIde1 != -1) {
            char temp = numArr[swapIde1];
            numArr[swapIde1] = numArr[swapIde2];
            numArr[swapIde2] = temp;
        }

        return Integer.parseInt(new String(numArr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number here : ");
        int n = sc.nextInt();
        System.out.println();

        int ans = maximumSwap(n);

        System.out.println(ans);

        sc.close();
    }
}