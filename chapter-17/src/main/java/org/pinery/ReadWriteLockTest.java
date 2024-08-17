package org.pinery;

/**
 * 读写锁测试
 **/
public class ReadWriteLockTest {
   // private final static String text = "Thisistheexampleforreadwritelock";
    private final static String text = "123456789";

    public static void main(String[] args) {
        //定义共享数据
        final ShareData shareData = new ShareData(50);
        //创建两个线程进行写操作
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int index = 0; index < text.length(); index++) {
                    try {
                        char c = text.charAt(index);
                        shareData.write(c);
                        System.out.println(Thread.currentThread() + " write " + c);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        }

        //创建10个线程进行数据读操作
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        String ss = new String(shareData.read());
                        System.out.println(Thread.currentThread() + " read " + ss);
                        if (ss.contains("9")) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
