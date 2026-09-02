package com.hdfclife;

import com.hdfclife.list.ClaimLinkedList;
import com.hdfclife.list.ClaimNode;
import com.hdfclife.list.CycleDetector;
import com.hdfclife.list.ListReverser;
import com.hdfclife.model.Claim;
import com.hdfclife.model.Urgency;
import com.hdfclife.queue.ClaimPriorityDesk;
import com.hdfclife.thread.ProducerConsumer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        Claim c1 = new Claim("CLM-01", 25000, "HDFC-LIFE-1001", "Anita Sharma", Urgency.HIGH);
        Claim c2 = new Claim("CLM-02", 18000, "HDFC-LIFE-1002", "Rahul Mehta", Urgency.MEDIUM);
        Claim c3 = new Claim("CLM-03", 42000, "HDFC-LIFE-1005", "Sneha Patel", Urgency.HIGH);
        Claim c4 = new Claim("CLM-04", 15000, "HDFC-LIFE-1004", "Vikram Singh", Urgency.LOW);
        Claim c5 = new Claim("CLM-05", 31000, "HDFC-LIFE-1001", "Anita Sharma", Urgency.MEDIUM);
        Claim c6 = new Claim("CLM-06", 9000, "HDFC-LIFE-1003", "Priya Nair", Urgency.LOW);


        List<Claim> claims = List.of(c1, c2, c3, c4, c5, c6);
        List<Integer> amounts = List.of(c1.getAmount(), c2.getAmount(), c3.getAmount(), c4.getAmount(), c5.getAmount(), c6.getAmount());
        List<Claim> ret = ClaimPriorityDesk.claimPriorityDesk(claims);
        ret.stream().forEach(System.out::println);

//        ClaimLinkedList cll = new ClaimLinkedList();
//        for (int amount : amounts) {
//            cll.addLast(amount);
//        }
//
//        cll.insertAt(2, 20000);
//        cll.deleteAt(2);
//
//
//
//        ClaimNode itrRev = ListReverser.iterativeReverse(cll.clone().next);
//
//        ClaimNode RecurRev = ListReverser.recurReverse(cll.clone());
//
//        ClaimNode middleNode = CycleDetector.middleOfList(cll.clone().next);
//        System.out.println("Middle of the List : " + middleNode.amount);
//
//
//        System.out.println(CycleDetector.cycleDetection(cll.clone().next));
//
//        System.out.println("After Linking");
//        cll.nodeAt(5).next = cll.nodeAt(2);
//        System.out.println(CycleDetector.cycleDetection(cll.nodeAt(0)));0


//        List<Claim> result = ClaimPriorityDesk.claimPriorityDesk();
//        for (Claim res : result) {
//            System.out.println(res);
//        }
//
//        ProducerConsumer pc = new ProducerConsumer();
//
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                pc.produce(25000);
//                pc.produce(18000);
//                pc.produce(42000);
//            }
//        };
//
//        List<Integer> list = new ArrayList<>();
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                list.add(pc.consume());
//                list.add(pc.consume());
//                list.add(pc.consume());
//            }
//        };
//
//        Thread t1 = new Thread(r1);
//
//        Thread t2 = new Thread(r2);
//
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        System.out.println(list.toString());
//

    }
}
