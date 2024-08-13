package org.pinery;

// 测试类
public class TestExample {
    static {
       // System.out.println("TestExample will be initialized.");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //1.通过new关键字会导致类的初始化
        //Simple simple = new Simple();

        //2.访问类的静态变量 会导致类的初始化
        //int x = Simple.x;

        //3.访问类的静态方法 会导致类的初始化
        //Simple.test();

        //4.对某个类进行反射操作, 会导致类的初始化
        //Class.forName("org.pinery.Simple");

        //5.初始化子类会导致父类的初始化
        //int xx = SimpleChild.xx;
        //5.1 通过子类访问父类的静态变量,只会导致父类被初始化,子类不会被初始化
        //int x = SimpleChild.x;

        //6.启动类: 执行main函数所在的类会导致该类的初始化

        //7.引用类的静态常量 不会 导致类的初始化,但如果静态常量 有复杂的计算,只有初始化才能得到结果,因此还是需要初始化.
        int max = Simple.MAX;
        int random = Simple.RANDOM;
    }
}
