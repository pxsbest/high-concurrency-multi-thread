package org.pinery.loader;

/**
 * @Author gensci
 * @DateTime 2024/7/27 21:44
 * @Description
 **/
public class ApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
        //系统类加载器的父加载器是 扩展类加载器
        System.out.println(ApplicationClassLoader.class.getClassLoader().getParent());
    }
      /*
        什么是类路径?
        https://blog.csdn.net/weixin_43836337/article/details/139224257
      */

}
