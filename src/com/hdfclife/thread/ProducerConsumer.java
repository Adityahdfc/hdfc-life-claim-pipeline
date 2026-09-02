package com.hdfclife.thread;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {
    private ArrayBlockingQueue<Integer> abq;

    public ProducerConsumer(){
        abq = new ArrayBlockingQueue<>(2);
    }

    public void produce(int amount){
        try{
            abq.put(amount);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public int consume(){
        int num = 0;
        try{
             num = abq.take();
        }catch (Exception e){
            System.out.println(e);
        }
        return num;
    }
}
