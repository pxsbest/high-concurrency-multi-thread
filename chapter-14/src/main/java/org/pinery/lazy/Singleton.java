package org.pinery.lazy;

/**
 * 懒汉式
 **/
public final class Singleton {
    //实例变量
    private byte[] data = new byte[1024];

    //定义实例,但是不直接初始化
    private static Singleton instances = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instances == null) {
            instances = new Singleton();
        }
        return instances;
    }
}
