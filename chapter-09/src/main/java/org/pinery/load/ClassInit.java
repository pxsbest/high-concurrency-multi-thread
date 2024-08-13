package org.pinery.load;

/**
 * @Author gensci
 * @DateTime 2024/7/27 10:24
 * @Description
 **/
public class ClassInit {
    static class Parent {
        static int value = 10;

        static {
            value = 20;
        }
    }

    static class Child extends Parent {
        static int i = value;
    }

    public static void main(String[] args) {
        System.out.println(Child.i);
    }


}
