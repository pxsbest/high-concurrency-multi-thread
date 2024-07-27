package org.pinery;

import java.util.Random;

/**
 * 类的主动使用和被动使用
 */
public class Simple {
    static {
        System.out.println("I will be initialized.");
    }
    //静态变量
    public static int x = 10;

    //静态常量
    public final static int MAX = 100;

    //复杂的 静态常量
    public final static int RANDOM = new Random().nextInt();

    public static void test() {

    }

}