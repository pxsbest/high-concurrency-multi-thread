package org.pinery.names;

import org.pinery.loader.BrokerDelegateClassLoader;
import org.pinery.loader.MyClassLoader;

import java.util.function.DoubleToIntFunction;

/**
 * 类加载器命名空间,运行时包,类的卸载
 **/
public class NameSpace {

    private static final String dir="D:\\IT\\Java\\high-concurrency-multi-thread\\multi-thread\\classloader1";


    //2.相同类加载器 加载同一个class
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader1 = new MyClassLoader(dir, null);
        MyClassLoader classLoader2 = new MyClassLoader(dir, null);
        Class<?> aClass = classLoader1.loadClass("org.pinery.loader.HelloWorld");
        Class<?> bClass = classLoader2.loadClass("org.pinery.loader.HelloWorld");
        System.out.println(aClass.getClassLoader());
        System.out.println(bClass.getClassLoader());
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass == bClass);
    }


    //1.不同类加载器 加载同一个class
    public static void main2(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader1 = new MyClassLoader(dir, null);
        BrokerDelegateClassLoader classLoader2 = new BrokerDelegateClassLoader(dir, null);
        Class<?> aClass = classLoader1.loadClass("org.pinery.loader.HelloWorld");
        Class<?> bClass = classLoader2.loadClass("org.pinery.loader.HelloWorld");
        System.out.println(aClass.getClassLoader());
        System.out.println(bClass.getClassLoader());
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass==bClass);
    }



    //同一个类加载器实例 加载 同一个类
    public static void main1(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = NameSpace.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("org.pinery.loader.MyClassLoaderTest");
        Class<?> bClass = classLoader.loadClass("org.pinery.loader.MyClassLoaderTest");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass == bClass);

    }
}
