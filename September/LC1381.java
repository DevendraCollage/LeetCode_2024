/*
 * LC1381
 */

class CustomStack {
    int stack[];
    int operations[];
    int capacity;
    int size;
    int index;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        operations = new int[maxSize];
        capacity = maxSize;
        size = 0;
        index = -1;
    }

    public void push(int x) {
        if (isFull()) {
            return;
        }
        index++;
        size++;
        stack[index] = x;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int value = stack[index];
        value += operations[index];
        // ? This will also perform in the constant time
        if (index > 0) {
            operations[index - 1] += operations[index];
        }
        operations[index] = 0;
        index--;
        size--;
        return value;
    }

    public void increment(int k, int val) {
        if (isEmpty()) {
            return;
        }
        int num = Math.min(size, k);
        // ? This is helpful technique to do in a constant time
        operations[num - 1] += val;

        // ? This will not perform in a constant time
        // for (int i = 0; i < num; i++) {
        // stack[i] += val;
        // }
    }

    private boolean isFull() {
        return (size == capacity);
    }

    private boolean isEmpty() {
        return (size == 0);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */