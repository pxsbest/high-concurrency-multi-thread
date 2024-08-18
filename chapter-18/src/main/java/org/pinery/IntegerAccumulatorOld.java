package org.pinery;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author gensci
 * @DateTime 2024/8/18 9:47
 * @Description
 **/
public class IntegerAccumulatorOld {
    private int init;

    //构造时传入初始值
    public IntegerAccumulatorOld(int init) {
        this.init = init;
    }

    //对初始值加1
    public int add(int i) {
        this.init+=i;
        return this.init;
    }

    //返回当前的初始值
    public int getValue() {
        return this.init;
    }

    public static void main(String[] args) {
        //定义累加器,并且将设置初始值为0
        IntegerAccumulatorOld accumulatorOld = new IntegerAccumulatorOld(0);
        //定义3个线程,并且分别启动
        IntStream.range(0,3).forEach(i->new Thread(()->{
            int inc=0;
            while (true){
                //首先获得老值
                int oldValue = accumulatorOld.getValue();
                //然后调用add方法计算
                int result = accumulatorOld.add(inc);
                System.out.println(oldValue + "+" + inc + "=" + result);
                //经验证如何不合理,则输出错误信息
                if (inc + oldValue != result) {
                    System.out.println("ERROR:" + oldValue + "+" + inc + "=" + result);
                }
                inc++;
                //模拟延迟
                slowly();
            }
        }).start());
    }

    private static void slowly() {
        try{
            TimeUnit.MILLISECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
