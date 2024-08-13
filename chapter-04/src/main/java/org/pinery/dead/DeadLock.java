package org.pinery.dead;

import java.sql.SQLOutput;

/**
 * 交叉死锁
 **/
public class DeadLock {
    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(Thread.currentThread().getName() + " get READ lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            }
            System.out.println(Thread.currentThread().getName() + " release READ lock");
        }
    }

    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            synchronized (MUTEX_READ) {
                System.out.println(Thread.currentThread().getName()+" get READ lock");
            }
            System.out.println(Thread.currentThread().getName()+ " release WRITE lock");
        }
    }

    public static void main(String[] args) {
        final DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            while (true) {
                deadLock.read();
            }
        }, "Read-Thread").start();

        new Thread(()->{
            while (true){
                deadLock.write();
            }
        },"Write-Thread").start();

    }
}
