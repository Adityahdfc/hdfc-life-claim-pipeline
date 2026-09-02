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
    public static int cycleDetection(ClaimNode head) {

        ClaimNode slow = head;
        ClaimNode fast = head;

        // Phase 1: Detect cycle
        while (slow != fast || slow == head) {

            if (fast == null || fast.next == null) {
                System.out.println("No Cycle Present");
                return -1;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        // Phase 2: Find beginning of cycle
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.amount;
    }
}
