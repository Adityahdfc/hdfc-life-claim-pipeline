package com.hdfclife.list;

public class DigitListAdder {
    public static ClaimNode addTwoLists(ClaimNode l1, ClaimNode l2) {
        ClaimNode ptr1 = l1;
        ClaimNode ptr2 = l2;
        int carry = 0;
        ClaimNode head = new ClaimNode(0);
        ClaimNode cur = head;

        while(ptr1 != null || ptr2 != null){
            int x = ptr1 != null ? ptr1.amount : 0;
            int y = ptr2 != null ? ptr2.amount : 0;
            int sum = x + y + carry;
            carry = 0;
            if(sum > 9){
                sum = sum - 10;
                carry = 1;
            }
            cur.next = new ClaimNode(sum);
            cur = cur.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        if(carry > 0){
            cur.next = new ClaimNode(carry);
        }
        return head.next;
    }

}
