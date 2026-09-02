package com.hdfclife.list;

public class ClaimLinkedList {


    ClaimNode head;
    int size = 0;


    public ClaimLinkedList() {
        head = new ClaimNode();
        size = 0;
    }

    public void addLast(int amount) {
        ClaimNode newNode = new ClaimNode(amount);

        ClaimNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;

        size++;
    }

    public void addFirst(int amount) {
        ClaimNode newNode = new ClaimNode(amount);

        newNode.next = head.next;
        head.next = newNode;

        size++;
    }

    public void insertAt(int index, int amount) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ClaimNode newNode = new ClaimNode(amount);
        ClaimNode ptr = head;

        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        newNode.next = ptr.next;
        ptr.next = newNode;

        size++;
    }

    public void deleteAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ClaimNode ptr = head;
        while (index-- > 0 && ptr != null) {
            ptr = ptr.next;
        }

//        if(index != 0) throw new InvalidIndexException();

        ptr.next = ptr.next.next;

        size--;
    }

    public ClaimNode nodeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ClaimNode ptr = head;
        while (index-- >= 0 && ptr != null) {
            ptr = ptr.next;
        }
        return ptr;
    }

    public int[] toArray() {
        int[] arr = new int[size];

        ClaimNode ptr = head.next;

        for (int i = 0; i < size; i++) {
            arr[i] = ptr.amount;
            ptr = ptr.next;
        }

        return arr;

    }

    public int size() {
        return size;
    }

    public ClaimNode clone() {
        ClaimNode cHead = new ClaimNode();
        ClaimNode ptr = cHead;
        ClaimNode ptrC = head.next;
        while (ptrC != null) {
            ptr.next = new ClaimNode(ptrC.amount);
            ptr = ptr.next;
            ptrC = ptrC.next;
        }
        return cHead.next;
    }
}
