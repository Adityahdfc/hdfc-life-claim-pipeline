package com.hdfclife.thread;

public class SeedRunnable implements Runnable{

    @Override
    public void run(){
        System.out.println("Running the runnable");
    }

    static void main() {
        SeedRunnable sr = new SeedRunnable();
        Thread t = new Thread(sr);

        System.out.println(t.getState());

        t.start();

        try{
            t.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println(t.getState());
    }
}
