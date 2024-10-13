/*
 * LC632
 */

import java.util.*;

public class LC632 {
    public static int[] smallestRange(List<List<Integer>> nums) {
        // min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0]; // sort element in increasing order
            }
        });
        int k = nums.size();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int minVal = nums.get(i).get(0);
            pq.offer(new int[] { minVal, i, 0 });
            max = Math.max(max, minVal);
        }
        int[] minRange = { 0, Integer.MAX_VALUE };
        while (true) {
            int top[] = pq.poll();
            int minElem = top[0], listIndex = top[1], elementIndex = top[2];
            if (max - minElem < minRange[1] - minRange[0]) {
                minRange[0] = minElem;
                minRange[1] = max;
            }

            // if one of the list is ended break
            if (elementIndex == nums.get(listIndex).size() - 1) {
                break;
            }

            // otherwise move to the next
            int next = nums.get(listIndex).get(elementIndex + 1);
            max = Math.max(max, next);
            pq.offer(new int[] { next, listIndex, elementIndex + 1 });
        }
        return minRange;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<Integer>> nums = new ArrayList<>();

        System.out.print("Enter the number of lists : ");
        int nLists = sc.nextInt();

        for (int i = 0; i < nLists; i++) {
            System.out.print("Enter the number of elements for list " + (i + 1) + " : ");
            int numberOfElem = sc.nextInt();

            List<Integer> curList = new ArrayList<>();

            System.out.println("Enter the elements for list : " + (i + 1) + " : ");
            for (int j = 0; j < numberOfElem; j++) {
                curList.add(sc.nextInt());
            }

            nums.add(curList);
        }

        int ans[] = smallestRange(nums);

        System.out.println("Answer Is : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }

        sc.close();
    }
}