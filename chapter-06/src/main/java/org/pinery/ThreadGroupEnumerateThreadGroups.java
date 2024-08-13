package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/7/19 21:32
 * @Description
 **/
public class ThreadGroupEnumerateThreadGroups {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup1 = new ThreadGroup("MyGroup1");
        ThreadGroup myGroup2 = new ThreadGroup(myGroup1, "MyGroup2");
        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup[] list = new ThreadGroup[mainGroup.activeGroupCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);
        recurseSize = mainGroup.enumerate(list, false);
        System.out.println(recurseSize);
    }
}
