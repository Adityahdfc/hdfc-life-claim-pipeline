package com.hdfclife.queue;

import com.hdfclife.exception.QueueEmptyException;

public class CircularClaimQueue {
    int head = 0;
    int tail = 0;
    int size = 0;
    int[] queue;
    int capacity;

    public CircularClaimQueue(int capacity) {
        if (capacity <= 0) {
            throw new QueueEmptyException("Capacity must be greater than 0");
        }
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


}
