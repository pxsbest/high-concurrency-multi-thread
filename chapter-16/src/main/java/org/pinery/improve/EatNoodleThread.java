package org.pinery.improve;


import org.pinery.deadlock.Tableware;

public class EatNoodleThread extends Thread {
    private final String name;
    private final TablewarePair tablewarePair;

    private EatNoodleThread(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (tablewarePair) {
            System.out.println(name + " take up " + tablewarePair.getLeftTool());
            System.out.println(name + " take up " + tablewarePair.getRightTool());
            System.out.println(name + " is eating now");
            System.out.println(name + " put down " + tablewarePair.getRightTool());
            System.out.println(name + " put down " + tablewarePair.getLeftTool());
        }
    }


    public static void main(String[] args) {
        Tableware knife = new Tableware("knife");
        Tableware fork = new Tableware("fork");
        TablewarePair pair = new TablewarePair(knife, fork);
        new EatNoodleThread("A", pair).start();
        new EatNoodleThread("B", pair).start();
    }
}
