package com.hdfclife.stack;

public class ArrayClaimStack implements ClaimStack {

    int[] stack = new int[32];
    int top = -1;

    @Override
    public void push(int value){
        stack[++top] = value;
    }

    @Override
    public int pop(){
        return stack[top--];
    }

    @Override
    public int peek(){
        return stack[top];
    }

    @Override
    public boolean isEmpty(){
        return top == -1;
    }
}
