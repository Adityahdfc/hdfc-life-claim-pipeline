package com.hdfclife.queue;

public class CircularClaimQueue {
    int head = 0;
    int tail = 0;
    int size = 0;
    int[] queue;
    int capacity;

    public CircularClaimQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void enqueue(int amount) {
        if (!isFull()) {
            queue[head] = amount;
            head = (head + 1) % capacity;
            size ++;
        } else {
            System.out.println("Queue full");
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int ret = queue[tail];
            tail = (tail + 1) % capacity;
            size --;
            return ret;
        } else {
            System.out.println("Cant Dequeue an empty Queue");
            return -1;
        }
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    static void main() {
        CircularClaimQueue ccq = new CircularClaimQueue(4);
        ccq.enqueue(25000);
        ccq.enqueue(18000);
        ccq.enqueue(42000);
        System.out.println(ccq.dequeue());
        ccq.enqueue(15000);
        ccq.enqueue(31000);
        while (!ccq.isEmpty()) {
            System.out.println(ccq.dequeue());
        }
    }

}
