package com.kievprog.chukhnovm.lesson6;

import java.math.BigInteger;

public class FactorialTask implements Runnable {

    private int number = 0;
    private BigInteger factSum = new BigInteger("0");

    public BigInteger getFactSum() {
        return factSum;
    }

    public FactorialTask(int number) {
        this.number = number;
    }

    public BigInteger calculateFactorial(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();

        for (int i = 1; i <= number; i++){
            BigInteger f = calculateFactorial(i);
            System.out.println(thread.getName() + " => " + i + "!=" + f);
            factSum = factSum.add(f);
        }
    }
}
