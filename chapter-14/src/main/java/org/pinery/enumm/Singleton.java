package org.pinery.enumm;


/**
 * 枚举方式
 **/
public enum Singleton {

    INSTANCE;
    //实例变量
    private byte[] data = new byte[1024];

    Singleton() {
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method() {
        //调用该方法则会主动调用Singleton,INSTANCE将会实例化
        System.out.println("method");
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }


}
