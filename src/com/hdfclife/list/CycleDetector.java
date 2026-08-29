package com.hdfclife.list;

public class CycleDetector {

    public static ClaimNode middleOfList(ClaimNode head){
        ClaimNode slow = head;
        ClaimNode fast = head;
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

    public static int cycleDetection(ClaimNode head){
        ClaimNode slow = head;
        ClaimNode fast = head;
        while(slow != fast && fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        if(fast != null && fast.next != null){
            //tell there is no cycle
        }

        slow = head;

        while(slow != fast){

            slow = slow.next;
            fast = fast.next;

        }

        return slow.amount;
    }
}
