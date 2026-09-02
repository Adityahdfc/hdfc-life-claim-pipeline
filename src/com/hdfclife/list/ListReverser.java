package com.hdfclife.list;

public class ListReverser {
    public static ClaimNode iterativeReverse(ClaimNode ptr){

        ClaimNode prev = null;
        ClaimNode curr = ptr;
        ClaimNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    static ClaimNode recurHead;
    public static ClaimNode recurReverse(ClaimNode ptr){
        if(ptr.next != null){
            ClaimNode newPtr  = recurReverse(ptr.next);
            newPtr.next = ptr;
            ptr.next = null;
            return ptr;
        }
        else{
            recurHead = ptr;
            return ptr;
        }
    }
// 1 -> 2 -> 3 -> 4 -> 5 -> 6


}

