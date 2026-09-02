package com.hdfclife;

import com.hdfclife.exception.PipelineException;
import com.hdfclife.list.*;
import com.hdfclife.model.Claim;
import com.hdfclife.model.Urgency;
import com.hdfclife.queue.BranchBfs;
import com.hdfclife.queue.CircularClaimQueue;
import com.hdfclife.queue.ClaimPriorityDesk;
import com.hdfclife.stack.ParenthesesChecker;
import com.hdfclife.stack.PostfixEvaluator;
import com.hdfclife.thread.ProducerConsumer;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        /*
         * ============================================================
         * CLAIM DATA
         * ============================================================
         */

        Claim c1 = new Claim(
                "CLM-01",
                25000,
                "HDFC-LIFE-1001",
                "Anita Sharma",
                Urgency.HIGH
        );

        Claim c2 = new Claim(
                "CLM-02",
                18000,
                "HDFC-LIFE-1002",
                "Rahul Mehta",
                Urgency.MEDIUM
        );

        Claim c3 = new Claim(
                "CLM-03",
                42000,
                "HDFC-LIFE-1005",
                "Sneha Patel",
                Urgency.HIGH
        );

        Claim c4 = new Claim(
                "CLM-04",
                15000,
                "HDFC-LIFE-1004",
                "Vikram Singh",
                Urgency.LOW
        );

        Claim c5 = new Claim(
                "CLM-05",
                31000,
                "HDFC-LIFE-1001",
                "Anita Sharma",
                Urgency.MEDIUM
        );

        Claim c6 = new Claim(
                "CLM-06",
                9000,
                "HDFC-LIFE-1003",
                "Priya Nair",
                Urgency.LOW
        );

        List<Claim> claims = List.of(c1, c2, c3, c4, c5, c6);


        /*
         * ============================================================
         * LINKED LIST
         * ============================================================
         */

        ClaimLinkedList cll = new ClaimLinkedList();

        cll.addLast(25000);
        cll.addLast(18000);
        cll.addLast(42000);
        cll.addLast(15000);
        cll.addLast(31000);
        cll.addLast(9000);

        System.out.println(
                "Seed list → " + arrayToString(cll.toArray())
        );


        cll.insertAt(2, 22000);

        System.out.println(
                "After insertAt(2, 22000) → " + arrayToString(cll.toArray())
        );


        cll.deleteAt(2);

        System.out.println(
                "After deleteAt(2) → " + arrayToString(cll.toArray())
        );


        /*
         * ============================================================
         * REVERSE
         * ============================================================
         */

        ClaimNode iterativeCopy = cll.clone();

        ClaimNode itrRev =
                ListReverser.iterativeReverse(iterativeCopy);

        System.out.println(
                "Reverse iterative → " + nodeListToString(itrRev)
        );


        ClaimNode recursiveCopy = cll.clone();

        ClaimNode recurRev =
                ListReverser.recurReverse(recursiveCopy);

        System.out.println(
                "Reverse recursive → " + nodeListToString(recurRev)
        );


        /*
         * ============================================================
         * MIDDLE + CYCLE
         * ============================================================
         */

        ClaimNode middleNode =
                CycleDetector.middleOfList(cll.clone().next);

        System.out.println(
                "Middle of seed → " + middleNode.amount
        );


        boolean hasCycle =
                CycleDetector.cycleDetection(cll.nodeAt(0)) != -1;

        System.out.println(
                "hasCycle on seed → " + hasCycle
        );


        // tail -> index 2
        cll.nodeAt(5).next = cll.nodeAt(2);

        int cycleStart =
                CycleDetector.cycleDetection(cll.nodeAt(0));

        System.out.println(
                "hasCycle after linking tail to index 2 → "
                        + (cycleStart != -1)
        );

        System.out.println(
                "Cycle start amount → " + cycleStart
        );


        /*
         * ============================================================
         * ADD TWO NUMBERS
         *
         * 00052
         * 00081
         * -----
         * 00133
         *
         * Stored least-significant digit first:
         * 0 -> 0 -> 0 -> 5 -> 2
         * 0 -> 0 -> 0 -> 8 -> 1
         *
         * Result:
         * 0 -> 0 -> 0 -> 3 -> 4
         * ============================================================
         */

        ClaimLinkedList num1 = new ClaimLinkedList();

        num1.addLast(0);
        num1.addLast(0);
        num1.addLast(0);
        num1.addLast(5);
        num1.addLast(2);


        ClaimLinkedList num2 = new ClaimLinkedList();

        num2.addLast(0);
        num2.addLast(0);
        num2.addLast(0);
        num2.addLast(8);
        num2.addLast(1);


        ClaimNode sum =
                DigitListAdder.addTwoLists(
                        num1.nodeAt(0),
                        num2.nodeAt(0)
                );

        System.out.println(
                "Add-two-numbers → " + nodeListToString(sum)
        );


        /*
         * ============================================================
         * STACK / PARENTHESES
         * ============================================================
         */

        System.out.println(
                "Balanced ((TERM)(ULIP)) → "
                        + ParenthesesChecker.parenthesesCheck(
                        "((TERM)(ULIP))"
                )
        );

        System.out.println(
                "Balanced ((TERM)(ULIP) → "
                        + ParenthesesChecker.parenthesesCheck(
                        "((TERM)(ULIP)"
                )
        );

        System.out.println(
                "Balanced ([)] → "
                        + ParenthesesChecker.parenthesesCheck(
                        "([)]"
                )
        );


        /*
         * ============================================================
         * POSTFIX
         * ============================================================
         */

        System.out.println(
                "Postfix 25000 18000 + 1000 - → "
                        + PostfixEvaluator.evaluate(
                        "25000 18000 + 1000 -"
                )
        );


        /*
         * ============================================================
         * CIRCULAR QUEUE
         * ============================================================
         */

        CircularClaimQueue cq =
                new CircularClaimQueue(4);

        cq.enqueue(25000);
        cq.enqueue(18000);
        cq.enqueue(42000);

        int dequeued = cq.dequeue();

        System.out.println(
                "Circular dequeue() → " + dequeued
        );

        cq.enqueue(15000);
        cq.enqueue(31000);

        List<Integer> queueValues = new ArrayList<>();

        queueValues.add(cq.dequeue());
        queueValues.add(cq.dequeue());
        queueValues.add(cq.dequeue());
        queueValues.add(cq.dequeue());

        System.out.println(
                "Circular queue after wrap → "
                        + commaSeparated(queueValues)
        );


        /*
         * ============================================================
         * BFS
         * ============================================================
         */

        List<String> traversed = BranchBfs.bfs();
        System.out.println(commaSeparatedStrings(traversed));

        /*
         * ============================================================
         * PRIORITY QUEUE
         * ============================================================
         */

        List<Claim> priorityResult =
                ClaimPriorityDesk.claimPriorityDesk(claims);

        System.out.print(
                "PriorityQueue poll ids → "
        );

        for (int i = 0; i < priorityResult.size(); i++) {

            System.out.print(
                    priorityResult.get(i).getClaimId()
            );

            if (i < priorityResult.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();


        /*
         * ============================================================
         * THREAD STATE
         * ============================================================
         */

        Thread stateThread = new Thread(() -> {
            // Nothing required here
        });

        System.out.println(
                "Thread state before start → "
                        + stateThread.getState()
        );

        stateThread.start();

        try {
            stateThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
                "Thread state after join → "
                        + stateThread.getState()
        );


        /*
         * ============================================================
         * CALLABLE + FUTURE
         * ============================================================
         */

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Callable<Integer> callableSum = () ->
                25000 + 18000 + 42000
                        + 15000 + 31000 + 9000;

        Future<Integer> future =
                executor.submit(callableSum);

        try {

            System.out.println(
                    "Callable Future.get() sum → "
                            + future.get()
            );

            System.out.println(
                    "isDone after get → "
                            + future.isDone()
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } catch (ExecutionException e) {

            System.out.println(e.getMessage());

        }


        /*
         * ============================================================
         * COMPLETABLE FUTURE
         * ============================================================
         */

        CompletableFuture<Integer> completableFuture =
                CompletableFuture.supplyAsync(() ->
                        25000 + 18000 + 42000
                                + 15000 + 31000 + 9000
                );

        try {

            System.out.println(
                    "CompletableFuture.supplyAsync sum → "
                            + completableFuture.get()
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } catch (ExecutionException e) {

            System.out.println(e.getMessage());

        }


        /*
         * ============================================================
         * CANCELLED FUTURE
         * ============================================================
         */

        CompletableFuture<Integer> cancelledFuture =
                new CompletableFuture<>();

        boolean cancelled =
                cancelledFuture.cancel(true);

        System.out.println(
                "Cancelled future → " + cancelled
        );


        /*
         * ============================================================
         * DAEMON THREAD
         * ============================================================
         */

        Thread daemonThread = new Thread(() -> {
            // daemon work
        });

        daemonThread.setDaemon(true);

        System.out.println(
                "Daemon flag → "
                        + daemonThread.isDaemon()
        );


        /*
         * ============================================================
         * PRODUCER / CONSUMER
         * ============================================================
         */

        ProducerConsumer pc =
                new ProducerConsumer();

        List<Integer> consumed =
                Collections.synchronizedList(
                        new ArrayList<>()
                );


        Runnable producer = new Runnable() {

            @Override
            public void run() {
                pc.produce(25000);
                pc.produce(18000);
                pc.produce(42000);
            }
        };


        Runnable consumer = new Runnable() {

            @Override
            public void run() {

                consumed.add(pc.consume());
                consumed.add(pc.consume());
                consumed.add(pc.consume());
            }
        };


        Thread producerThread =
                new Thread(producer);

        Thread consumerThread =
                new Thread(consumer);


        producerThread.start();
        consumerThread.start();

        try {

            producerThread.join();
            consumerThread.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }


        System.out.println(
                "Producer-consumer takes → "
                        + commaSeparated(consumed)
        );


        /*
         * ============================================================
         * EXCEPTION HANDLING
         * ============================================================
         */

        try {

            cll.nodeAt(99);

        } catch (Exception e) {

            System.out.println(
                    "Caught message for invalid list index 99"
            );
        }


        /*
         * Empty stack
         *
         * IMPORTANT:
         * Change the method name below if your stack class
         * uses a different pop API.
         */

        try {

            // Example:
            // ClaimStack stack = new ClaimStack();
            // stack.pop();

            throw new PipelineException(
                    "Empty stack pop"
            );

        } catch (PipelineException e) {

            System.out.println(
                    "Caught message for empty stack pop"
            );
        }


        /*
         * Empty queue
         */

        try {

            CircularClaimQueue emptyQueue =
                    new CircularClaimQueue(4);

            emptyQueue.dequeue();

        } catch (PipelineException e) {

            System.out.println(
                    "Caught message for empty queue dequeue"
            );
        }


        executor.shutdown();
    }


    /*
     * ================================================================
     * HELPER METHODS
     * ================================================================
     */

    private static String arrayToString(int[] array) {

        StringBuilder result =
                new StringBuilder();

        for (int i = 0; i < array.length; i++) {

            result.append(array[i]);

            if (i < array.length - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }


    private static String nodeListToString(ClaimNode node) {

        StringBuilder result =
                new StringBuilder();

        while (node != null) {

            result.append(node.amount);

            if (node.next != null) {
                result.append(", ");
            }

            node = node.next;
        }

        return result.toString();
    }


    private static String commaSeparated(
            List<Integer> list) {

        StringBuilder result =
                new StringBuilder();

        for (int i = 0; i < list.size(); i++) {

            result.append(list.get(i));

            if (i < list.size() - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    private static String commaSeparatedStrings(
            List<String> list) {

        StringBuilder result =
                new StringBuilder();

        for (int i = 0; i < list.size(); i++) {

            result.append(list.get(i));

            if (i < list.size() - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }


}