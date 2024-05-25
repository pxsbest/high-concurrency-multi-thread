package org.pinery;

/**
 * @Author gensci
 * @DateTime 2024/5/25 9:03
 * @Description
 **/
public class ThreadConstruction {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread("t1");

        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group, "t2");

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

        System.out.println("Main thread belong group:" + mainThreadGroup.getName());
        System.out.println("t1 and main belong the same group:" + (t1.getThreadGroup() == mainThreadGroup));
        System.out.println("t2 thread group not belong main group:" + (t2.getThreadGroup() == mainThreadGroup));
        System.out.println("t2 thread group belong main TestGroup:" + (t2.getThreadGroup() == group));

        Thread.sleep(1000*1000);
    }
}
