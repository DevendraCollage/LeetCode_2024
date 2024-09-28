/*
 * LC641
 */

import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque {
    // Declaration
    Deque<Integer> d;
    int size;

    public MyCircularDeque(int k) {
        // Initialization in Constructor
        d = new LinkedList<>();
        size = k;
    }

    public boolean insertFront(int value) {
        // Insert element from First
        if (d.size() < size) {
            d.addFirst(value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        // Insert element from Last
        if (d.size() < size) {
            d.addLast(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        // Remove element from First
        if (d.size() > 0) {
            d.removeFirst();
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        // Remove element from Last
        if (d.size() > 0) {
            d.removeLast();
            return true;
        }
        return false;
    }

    public int getFront() {
        // Get the first element
        if (d.size() <= 0) {
            return -1;
        }
        return d.getFirst();
    }

    public int getRear() {
        // Get the last element
        if (d.size() <= 0) {
            return -1;
        }
        return d.getLast();
    }

    public boolean isEmpty() {
        // Check the deque is empty or not
        if (d.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        // Check the deque is full or not
        if (d.size() == size) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */