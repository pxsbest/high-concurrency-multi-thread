package org.pinery;

/**
 * @Author gensci
 * @DateTime 2024/7/19 22:32
 * @Description
 **/
public class ThreadGroupDestroy {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("TestGroup");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("group.isDestroy=" + group.isDestroyed());
        mainGroup.list();

        group.destroy();

        System.out.println("group.isDestroyed=" + group.isDestroyed());
        mainGroup.list();
    }
}
