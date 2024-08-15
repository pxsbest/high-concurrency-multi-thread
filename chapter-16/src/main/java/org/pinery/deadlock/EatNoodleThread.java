package org.pinery.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 吃面条的线程
 **/
public class EatNoodleThread extends Thread {
    private final String name;
    //左手边的厨具
    private final Tableware leftTool;
    //右手边的厨具
    private final Tableware rightTool;

    public EatNoodleThread(String name,Tableware leftTool, Tableware rightTool) {
        this.name= name;
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    //吃面条
    private void eat() {
        synchronized (leftTool) {
            System.out.println(name + " take up " + leftTool + "(left)");
            synchronized (rightTool) {
                System.out.println(name + " take up" + rightTool + "(right)");
                System.out.println(name + " is eating now.");
                System.out.println(name +" put down "+rightTool+"(right)");
            }
            System.out.println(name + " put down " + leftTool + "(left)");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        new EatNoodleThread("A",fork,knife).start();
        TimeUnit.SECONDS.sleep(5);
        new EatNoodleThread("B",knife,fork).start();

    }
}
