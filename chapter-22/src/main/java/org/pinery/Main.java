package org.pinery;

/**
 * @Author ${USER}
 * @DateTime ${DATE} ${TIME}
 * @Description
 **/
public class Main {
    public static void main(String[] args) {
        new DocumentEditThread("D:\\","balking.txt").start();
    }
}