package com.hdfclife.list;

public class ListReverser {
    public static ClaimNode iterativeReverse(ClaimNode ptr) {

        ClaimNode prev = null;
        ClaimNode curr = ptr;
        ClaimNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    public static ClaimNode recurHead;

    public static ClaimNode recurReverse(ClaimNode ptr) {
        return helper(ptr);
    }

    private static ClaimNode helper(ClaimNode ptr) {

        // Base case
        if (ptr == null || ptr.next == null) {
            return ptr;
        }

        // Reverse everything after ptr
        ClaimNode newHead = helper(ptr.next);

        // Put ptr after its next node
        ptr.next.next = ptr;

        // ptr becomes the last node
        ptr.next = null;

        return newHead;
    }
// 1 -> 2 -> 3 -> 4 -> 5 -> 6


}

