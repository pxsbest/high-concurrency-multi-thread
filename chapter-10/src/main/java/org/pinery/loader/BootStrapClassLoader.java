package org.pinery.loader;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;

/**
 * @Author gensci
 * @DateTime 2024/7/27 15:42
 * @Description
 **/
public class BootStrapClassLoader {


    public static void main3(String[] args) {
        //java11
        ClassLoader bootstrapClassLoader = getBootstrapClassLoader();
        System.out.println("Bootstrap ClassLoader: " + bootstrapClassLoader);
    }

    private static ClassLoader getBootstrapClassLoader() {
        try {
        //使用反射获取类加载器的父类加载器字段
            Field field = ClassLoader.class.getDeclaredField("parent");
            field.setAccessible(true);
            //获取系统类加载器并一直向上查找直到没有父类加载器为止
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            while (systemClassLoader != null) {
                ClassLoader parent = (ClassLoader) field.get(systemClassLoader);
                if (parent == null) {
                    //根加载器就是 systemClassLoader
                    return systemClassLoader;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main2(String[] args) {
        //java11
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        while (loader.getParent() != null) {
            loader = loader.getParent();
        }
        //获取JDK的版本
        //System.out.println(Runtime.version());

        //获取并打印根类加载器的URLs
        for (URL url : ((URLClassLoader) loader).getURLs()) {
            System.out.println(url.toExternalForm());
        }

    }


    public static void main(String[] args){
        //jdk 1.8(注意不同版本的JDK获取方式不同)
        System.out.println("Bootstrap:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
