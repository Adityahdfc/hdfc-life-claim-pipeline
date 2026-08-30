package com.hdfclife.queue;

public class CircularClaimQueue {
    int head;
    int tail;
    int[] queue;
    int capacity;

    public CircularClaimQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void enqueue(int amount) {
        queue[(head++) % capacity] = amount;
    }

    public int dequeue() {
        return queue[(tail++) % capacity];
    }

    

}
