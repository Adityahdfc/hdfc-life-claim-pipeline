package com.hdfclife.thread;

import java.util.List;
import java.util.concurrent.*;

public class ClaimTotalCallable implements Callable<Integer> {

    List<Integer> amounts;

    public ClaimTotalCallable(List<Integer> amounts) {

        this.amounts = amounts;

    }

    public Integer call() {
        int sum = 0;

        for (int amount : amounts) {
            sum += amount;
        }

        return sum;
    }

    static void main() {
        List<Integer> amounts = List.of(25000, 18000, 42000, 15000, 9000, 31000);
        ClaimTotalCallable ctc = new ClaimTotalCallable(amounts);

        ExecutorService es = Executors.newSingleThreadExecutor();

        Future f = es.submit(ctc);

        int total = 0;
        try {
            total = (int) f.get();

            System.out.println(total);
            System.out.println(f.isDone());

        } catch (Exception e) {
            System.out.println(e);
        }

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Running on: "
                            + Thread.currentThread().getName());

                    return 140000;
                });

        System.out.println("Main thread: "
                + Thread.currentThread().getName());

        int result = 0;

        try{
            result = future.get();
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println(result);

    }

}
