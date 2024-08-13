package org.pinery.holder;

/**
 * Holder方式
 **/
public final class Singleton {
    private byte[] data = new byte[1024];
    private Singleton() {
    }

    //在静态内部类中持有 Singleton的实例,并且可直接实例化
    private static class Holder{
        private static Singleton instance = new Singleton();
    }

    //调用getInstance方法,事实上是获得Holder的instance静态属性
    public static Singleton getInstance() {
        return Holder.instance;
    }
}
