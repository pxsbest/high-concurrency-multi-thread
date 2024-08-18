package org.pinery;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        IntegerAccumulatorOld accumulator = new IntegerAccumulatorOld(0);
        IntStream.range(0,3).forEach(i->new Thread(()->{
            int inc=0;
            while (true){
                int oldValue;
                int result;
                synchronized (IntegerAccumulatorOld.class) {
                    oldValue = accumulator.getValue();
                    result = accumulator.add(inc);
                }
                System.out.println(oldValue + "+" + inc + "=" + result);
                if (inc + oldValue != result) {
                    System.out.println("ERROR:" + oldValue + "+" + inc + "=" + result);
                }
                inc++;
                slowly();
            }
        }));
    }

    private static void slowly() {
        try{
            TimeUnit.MILLISECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}