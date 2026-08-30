package com.hdfclife.stack;

import com.hdfclife.list.ClaimNode;

public class LinkedClaimStack implements ClaimStack {

    ClaimNode top = null;

    @Override
    public void push(int x) {
        ClaimNode newNode = new ClaimNode(x);

        if (top == null) {
            top = newNode;
            return;
        }

        newNode.next = top;
        top = newNode;
    }

    @Override
    public int pop() {
        if (top == null) {
            throw new RuntimeException("top is null");
        }
        int amount = top.amount;
        top = top.next;
        return amount;
    }

    @Override
    public int peek() {
        if (top == null) {
            throw new RuntimeException("top is null");
        }
        return top.amount;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
