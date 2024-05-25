package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/5/9 14:17
 * @Description
 **/
public class AnalyzeSourceCode {
    public static void main(String[] args) throws InterruptedException {
        //test();
        test1();

    }

    private static void test() {
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        };
        thread.start();  //连接启动线程,是会报错的
        thread.start();
    }

    private static void test1() throws InterruptedException {
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(2);//休眠主要是确保thread结束生命周期
        thread.start();  //企图重新激活该线程
    }


}
