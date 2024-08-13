package org.pinery.lazy.sync;

/**
 * 懒汉式 + 同步加载
 **/
public final class Singleton {
    //实例变量
    private byte[] data = new byte[1024];

    private static Singleton instance= null;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

}
