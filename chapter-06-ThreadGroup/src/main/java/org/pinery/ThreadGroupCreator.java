package org.pinery;

/**
 * Thread与ThreadGroup
 **/
public class ThreadGroupCreator {
    public static void main(String[] args) {
        //1.获取当前线程Group
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        //2.定义一个新的Group
        ThreadGroup group1 = new ThreadGroup("group1");
        //3.程序输出 true
        System.out.println(group1.getParent() == currentGroup);
        //4.定义group2 ,指定group1为其父group
        ThreadGroup group2 = new ThreadGroup(group1, "group2");
        //5.程序输出 true
        System.out.println(group2.getParent() == group1);
    }
}
