package org.pinery.loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author gensci
 * @DateTime 2024/8/2 8:32
 * @Description
 **/
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = classLoader.loadClass("org.pinery.loader.HelloWorld");
        System.out.println(aClass.getClassLoader());
        //=========以上是类的加载阶段

        Object helloWorld = aClass.newInstance();
        System.out.println(helloWorld);
        Method welcomeMethod = aClass.getMethod("welcome");
        String result = (String)welcomeMethod.invoke(helloWorld);
        System.out.println("Result: "+result);
    }
}
