package com.kievprog.chukhnovm.lesson6;

public class Main {

    public static void main(String[] args) {

        FactorialTask t1 = new FactorialTask(10);
        FactorialTask t2 = new FactorialTask(10);
        FactorialTask t3 = new FactorialTask(10);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);

        thread1.start();
        thread2.start();
        thread3.start();

        try{
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();

        System.out.println("Sum 1 = " + t1.getFactSum());
        System.out.println("Sum 2 = " + t2.getFactSum());
        System.out.println("Sum 3 = " + t3.getFactSum());
    }

    public static void test1(){
        Thread thread1 = Thread.currentThread();

        System.out.println(thread1.getId());
        System.out.println(thread1.getName() + " Start");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread1.isDaemon());
        System.out.println(thread1.getName() + " End");

//        System.out.println(thread1.getContextClassLoader().getName());
//        System.out.println();
    }
}
