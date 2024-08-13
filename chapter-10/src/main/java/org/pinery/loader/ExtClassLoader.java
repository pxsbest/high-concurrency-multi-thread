package org.pinery.loader;

/**
 * @Author gensci
 * @DateTime 2024/7/27 18:18
 * @Description
 **/
public class ExtClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("java.ext.dirs"));
        Class<?> helloClass = Class.forName("org.pinery.Hello");
        System.out.println(helloClass.getClassLoader());
    }
}
