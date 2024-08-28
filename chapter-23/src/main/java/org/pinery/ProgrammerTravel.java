package org.pinery;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 程序员旅游线程
 **/
public class ProgrammerTravel extends Thread{

    //门闩
    private final Latch latch;
    //程序员
    private final String programmer;
    //交通工具
    private final String tranportation;

    //通过构造函数注入
    public ProgrammerTravel(Latch latch, String programmer, String tranportation) {
        this.latch = latch;
        this.programmer = programmer;
        this.tranportation = tranportation;
    }

    @Override
    public void run() {
        System.out.println(programmer + " start take the transportation [" + tranportation + "]");
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(programmer + " arrived by " + tranportation);
        //完成任务时使计数减一
        latch.countDown();
    }
}
