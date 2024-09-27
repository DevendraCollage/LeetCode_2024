/*
 * LC731
 */

import java.util.*;

class MyCalendarTwo {
    List<int[]> bookings;
    TreeMap<Integer, Integer> overlappedMap;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlappedMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // If event is present in overlapped then return false
        Integer prevValue = overlappedMap.lowerKey(end);
        if (prevValue != null && start <= overlappedMap.get(prevValue) - 1) {
            return false;
        } // Insert into bookings and if it is overlapping with any booking then insert
          // into overlapped map
        for (int booking[] : bookings) {
            // booking[0], start
            // booking[1], end
            int commStart = Math.max(booking[0], start);
            int commEnd = Math.min(booking[1], end);
            if (commStart < commEnd) {
                overlappedMap.put(commStart, commEnd);
            }
        }
        bookings.add(new int[] { start, end });
        return true;
    }
}