package org.pinery.begin;

import java.util.concurrent.TimeUnit;

/**
 * 初识volatile关键字
 **/
public class VolatileFoo {
    final static int Max = 5;
    static  int init_value = 0;

    public static void main(String[] args) {

        //启动一个Reader线程,当发现local_value和init_value不相等时,则输出 init_value被修改的信息
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < Max) {
                if (init_value != localValue) {
                    System.out.printf("The init_value is update to [%d]\n", init_value);
                    localValue = init_value;
                }
            }
        },"Reader").start();

        //启动一个Update线程,主要用于修改init_value, 当local_value>=5 的时候则退出生命周期
        new Thread(()->{
            int localValue = init_value;
            while (localValue < Max) {
                System.out.printf("The init_value will be changed to [%d] \n",++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Update").start();
    }
}
