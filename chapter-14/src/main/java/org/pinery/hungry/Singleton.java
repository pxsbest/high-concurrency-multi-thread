package org.pinery.hungry;

/**
 * 饿汉式
 * final 不允许被继承
 **/
public final class Singleton {
    //实例变量
    private byte[] data = new byte[1024];

    //在定义实例的时候直接初始化
    private static Singleton instances = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instances;
    }
}